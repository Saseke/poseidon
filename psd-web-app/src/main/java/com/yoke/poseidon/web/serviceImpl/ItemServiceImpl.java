package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.entity.ItemCat;
import com.yoke.poseidon.web.mapper.ItemCatMapper;
import com.yoke.poseidon.web.mapper.ItemMapper;
import com.yoke.poseidon.web.service.ConvertService;
import com.yoke.poseidon.web.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item>
		implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Autowired
	private ConvertService convertService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ItemCatDto> getIndexCatWithItems() {
		Optional<List<ItemCat>> itemRootCats = Optional
				.ofNullable(itemCatMapper.selectList(new QueryWrapper<ItemCat>()
						.eq("parent_id", 0).eq("remark", "index")));
		return itemRootCats.map(itemCatList -> getItemsByRootCat(itemCatList, 8))
				.orElse(Collections.emptyList());
	}

	@Override
	public List<ItemCatDto> getRootCatsWithItems(Integer limit) {
		// 得到所有的根分类
		Optional<List<ItemCat>> itemRootCats = Optional
				.ofNullable(itemCatMapper.selectRootCat());
		// 得到每个根分类的所有子分类
		// 查找每个子分类的商品
		// 进行封装
		return itemRootCats.map(itemCatList -> getItemsByRootCat(itemCatList, null))
				.orElse(Collections.emptyList());
	}

	@Override
	public List<List<ItemCatDto>> getRootCatsWithItemsParted(Integer limit) {
		return Lists.partition(getRootCatsWithItems(limit), 2);
	}

	private List<ItemCatDto> getItemsByRootCat(List<ItemCat> itemRootCatList,
			Integer limit) {
		return itemRootCatList.stream().map(itemRootCat -> {
			ItemCatDto itemCatDto = modelMapper.map(itemRootCat, ItemCatDto.class);
			List<Long> ids = new ArrayList<>();
			ids.add(itemRootCat.getItemCatId());
			Optional<List<Long>> childIdsOptional = Optional.ofNullable(
					itemCatMapper.selectChildIdsByParentId(itemRootCat.getItemCatId()));
			childIdsOptional.map(ids::addAll);
			List<ItemDto> itemDtos = itemMapper.selectByCIds(ids, limit).stream()
					.map(item -> modelMapper.map(item, ItemDto.class))
					.collect(Collectors.toList());
			itemCatDto.setItems(itemDtos);
			return itemCatDto;
		}).collect(Collectors.toList());
	}

}

package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.entity.ItemCat;
import com.yoke.poseidon.web.itemShow.mapper.ItemCatMapper;
import com.yoke.poseidon.web.itemShow.service.ConvertService;
import com.yoke.poseidon.web.itemShow.service.ItemCatService;
import com.yoke.poseidon.web.itemShow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class ItemCatServiceImpl extends ServiceImpl<ItemCatMapper, ItemCat>
		implements ItemCatService {

	private final ItemCatMapper itemCatMapper;

	private final ItemService itemService;

	private final ConvertService convertService;

	@Autowired
	public ItemCatServiceImpl(ItemCatMapper itemCatMapper, ItemService itemService,
			ConvertService convertService) {
		this.itemCatMapper = itemCatMapper;
		this.itemService = itemService;
		this.convertService = convertService;
	}

	@Override
	public List<ItemCatDto> getByParentId(@NonNull Long pId, Integer limit) {
		List<ItemCat> itemCatList = itemCatMapper.selectByParentId(pId, null, limit);
		return convertService.convertItemCat(itemCatList);
	}

	@Override
	public List<Long> getIdsByParentId(@NonNull Long pId, Integer limit) {
		return itemCatMapper.selectIdsByParentId(pId, null, limit);
	}

	@Override
	public List<List<ItemCatDto>> getRootCat(Integer catLimit, Integer itemLimit) {
		return Lists.partition(getItemCatWithItems("index", catLimit, itemLimit), 2);
	}

	@Override
	public List<ItemCatDto> getByRemark(@NonNull String remark, Integer limit) {
		List<ItemCat> itemCatList = itemCatMapper.selectByRemark(remark, null, limit);
		return convertService.convertItemCat(itemCatList);
	}

	@Override
	public List<ItemCatDto> getItemCatWithItems(String remark, Integer catLimit,
			Integer itemLimit) {
		List<ItemCatDto> remarkItemCatDtoList = convertService
				.convertItemCat(list(new QueryWrapper<ItemCat>().eq("remark", remark)
						.last("limit " + catLimit)));
		remarkItemCatDtoList.forEach(itemCatDto -> {
			List<Long> ids = getChildCatIds(itemCatDto.getItemCatId());
			List<ItemDto> itemData = itemService.getByCatIds(ids, itemLimit);
			itemCatDto.setItems(itemData);
		});
		return remarkItemCatDtoList;
	}

	@Override
	public List<Long> getChildCatIds(Long itemCatId) {
		List<Long> ret = itemCatMapper.selectChildIdsById(itemCatId);
		ret.add(itemCatId);
		return ret;
	}

}
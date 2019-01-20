package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.entity.Item;
import com.yoke.poseidon.web.itemShow.mapper.ItemMapper;
import com.yoke.poseidon.web.itemShow.service.ConvertService;
import com.yoke.poseidon.web.itemShow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

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
	private ConvertService convertService;

	@Override
	public ItemDto getById(@NonNull String itemId, int intBlob) {
		boolean blob = intBlob == 1;
		Optional<Item> itemOptional = ofNullable(itemMapper.selectById(itemId, blob));
		return itemOptional.map(item -> convertService.convertItem(item))
				.orElse(new ItemDto());
	}

	@Override
	public List<ItemDto> getIdIn(@NonNull List<String> itemIds, int intBlob) {
		boolean blob = intBlob == 1;
		List<Item> itemList = itemMapper.selectIdIn(itemIds, null, blob);
		return convertService.convertItem(itemList);
	}

	@Override
	public List<ItemDto> getByCId(@NonNull Long cId, @NonNull Integer limit,
			int intBlob) {
		boolean blob = intBlob == 1;
		List<Item> itemList = itemMapper.selectByCId(cId, limit, null, blob);
		return convertService.convertItem(itemList);
	}

	@Override
	public List<ItemDto> getByCIds(@NonNull List<Long> cIds, @NonNull Integer limit,
			int intBlob) {
		boolean blob = intBlob == 1;
		List<Item> itemList = itemMapper.selectByCIds(cIds, limit, null, blob);
		return convertService.convertItem(itemList);
	}

	@Override
	public List<ItemDto> getByCatIds(@NonNull List<Long> itemCatIds,
			@NonNull Integer limit) {
		List<Item> data = list(
				new QueryWrapper<Item>().in("c_id", itemCatIds).last("limit " + limit));
		return convertService.convertItem(data);
	}

	@Override
	public List<ItemDto> get() {
		List<Item> itemList = list(new QueryWrapper<>());
		return convertService.convertItem(itemList);
	}

}
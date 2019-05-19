package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.entity.Item;
import com.yoke.poseidon.web.itemShow.event.EventDispatcher;
import com.yoke.poseidon.web.itemShow.mapper.ItemCatMapper;
import com.yoke.poseidon.web.itemShow.mapper.ItemMapper;
import com.yoke.poseidon.web.itemShow.service.ConvertService;
import com.yoke.poseidon.web.itemShow.service.ItemService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

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

	private final ItemMapper itemMapper;

	private final ItemCatMapper itemCatMapper;

	private final ConvertService convertService;

	private final EventDispatcher eventDispatcher;

	public ItemServiceImpl(ItemMapper itemMapper, ItemCatMapper itemCatMapper,
			ConvertService convertService, EventDispatcher eventDispatcher) {
		this.itemMapper = itemMapper;
		this.itemCatMapper = itemCatMapper;
		this.convertService = convertService;
		this.eventDispatcher = eventDispatcher;
	}

	@Override
	public ItemDto getById(@NonNull String itemId, int intBlob) {
		boolean blob = intBlob == 1;
		return convertService.convertItem(itemMapper.select(itemId, blob));
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
		List<ItemDto> ret = convertService.convertItem(itemList);
		ret.forEach(itemDto -> {
			itemDto.setItemCatName(itemCatMapper.selectById(itemDto.getcId()).getName());
		});
		return ret;
	}

	@Override
	public void test() {
		ItemDto itemDto = new ItemDto();
		itemDto.setName("Hello");
		eventDispatcher.send(itemDto);
	}

}
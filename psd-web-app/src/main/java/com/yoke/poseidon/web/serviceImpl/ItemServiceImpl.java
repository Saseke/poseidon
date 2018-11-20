package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.mapper.ItemMapper;
import com.yoke.poseidon.web.service.ConvertService;
import com.yoke.poseidon.web.service.ItemService;
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
	public List<ItemDto> getIdIn(@NonNull List<String> itemIds, String sort,
			int intBlob) {
		boolean blob = intBlob == 1;
		List<Item> itemList = itemMapper.selectIdIn(itemIds, sort, blob);
		return convertService.convertItem(itemList);
	}

	@Override
	public List<ItemDto> getByCId(@NonNull Long cId, Integer limit, String sort,
			int intBlob) {
		boolean blob = intBlob == 1;
		List<Item> itemList = itemMapper.selectByCId(cId, limit, sort, blob);
		return convertService.convertItem(itemList);
	}

	@Override
	public List<ItemDto> getByCIds(@NonNull List<Long> cIds, Integer limit, String sort,
			int intBlob) {
		boolean blob = intBlob == 1;
		List<Item> itemList = itemMapper.selectByCIds(cIds, limit, sort, blob);
		return convertService.convertItem(itemList);

	}

}

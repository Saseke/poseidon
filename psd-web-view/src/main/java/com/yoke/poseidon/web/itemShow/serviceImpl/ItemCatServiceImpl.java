package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.entity.ItemCat;
import com.yoke.poseidon.web.itemShow.mapper.ItemCatMapper;
import com.yoke.poseidon.web.itemShow.mapper.ItemMapper;
import com.yoke.poseidon.web.itemShow.service.ConvertService;
import com.yoke.poseidon.web.itemShow.service.ItemCatService;
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

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private ConvertService convertService;

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
	public List<ItemCatDto> getRootCat(Integer limit) {
		List<ItemCat> itemCatList = itemCatMapper.selectRootCat(null, limit);
		System.out.println(itemCatList.get(0));
		System.out.println(convertService.convertItemCat(itemCatList).get(0));
		return convertService.convertItemCat(itemCatList);
	}

	@Override
	public List<ItemCatDto> getByRemark(@NonNull String remark, Integer catLimit,
			Integer itemLimit, int itemBlob) {
		boolean blob = itemBlob == 1;
		List<ItemCatDto> itemCatDtoList = getRootCat(catLimit);
		itemCatDtoList.forEach(System.out::println);
		itemCatDtoList.forEach(itemCatDto -> {
			List<ItemDto> itemDtoList = convertService.convertItem(itemMapper
					.selectByCId(itemCatDto.getItemCatId(), itemLimit, null, blob));
			itemCatDto.getItems().addAll(itemDtoList);
			if (itemCatDto.getIsParent()) {
				List<Long> ids = itemCatMapper
						.selectIdsByParentId(itemCatDto.getItemCatId(), null, catLimit);
				if (ids.size() != 0) {
					List<ItemDto> childCatsItemDtoList = convertService.convertItem(
							itemMapper.selectByCIds(ids, itemLimit, null, blob));
					itemCatDto.getItems().addAll(childCatsItemDtoList);
				}
			}
		});
		return itemCatDtoList;
	}

}
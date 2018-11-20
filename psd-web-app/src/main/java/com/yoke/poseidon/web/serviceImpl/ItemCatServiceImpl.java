package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.ItemCat;
import com.yoke.poseidon.web.mapper.ItemCatMapper;
import com.yoke.poseidon.web.mapper.ItemMapper;
import com.yoke.poseidon.web.service.ConvertService;
import com.yoke.poseidon.web.service.ItemCatService;
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
	public List<ItemCatDto> getByParentId(@NonNull Long pId, String sort, Integer limit) {
		List<ItemCat> itemCatList = itemCatMapper.selectByParentId(pId, sort, limit);
		return convertService.convertItemCat(itemCatList);
	}

	@Override
	public List<Long> getIdsByParentId(@NonNull Long pId, String sort, Integer limit) {
		return itemCatMapper.selectIdsByParentId(pId, sort, limit);
	}

	@Override
	public List<ItemCatDto> getRootCat(String sort, Integer limit) {
		List<ItemCat> itemCatList = itemCatMapper.selectRootCat(sort, limit);
		return convertService.convertItemCat(itemCatList);
	}

	@Override
	public List<ItemCatDto> getByRemark(@NonNull String remark, String catSort,
			String itemSort, Integer catLimit, Integer itemLimit, @NonNull int itemBlob) {
		boolean blob = itemBlob == 1;
		List<ItemCatDto> itemCatDtoList = getRootCat(catSort, catLimit);
		itemCatDtoList.forEach(itemCatDto -> {
			List<ItemDto> itemDtoList = convertService.convertItem(itemMapper
					.selectByCId(itemCatDto.getItemCatId(), itemLimit, itemSort, blob));
			itemCatDto.getItems().addAll(itemDtoList);
			if (itemCatDto.getIsParent()) {
				List<Long> ids = itemCatMapper.selectIdsByParentId(
						itemCatDto.getItemCatId(), catSort, catLimit);
				if (ids.size() != 0) {
					List<ItemDto> childCatsItemDtoList = convertService.convertItem(
							itemMapper.selectByCIds(ids, itemLimit, itemSort, blob));
					itemCatDto.getItems().addAll(childCatsItemDtoList);
				}
			}
		});
		return itemCatDtoList;
	}

}
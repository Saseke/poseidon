package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
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
	public List<List<ItemCatDto>> getRootCat(Integer limit) {
		List<ItemCat> itemCatList = itemCatMapper.selectRootCat(null, limit);
		List<ItemCatDto> itemCatDtoList = convertService.convertItemCat(itemCatList);
		return Lists.partition(itemCatDtoList, 2);
	}

	@Override
	public List<ItemCatDto> getByRemark(@NonNull String remark, Integer limit) {
		List<ItemCat> itemCatList = itemCatMapper.selectByRemark(remark, null, limit);
		return convertService.convertItemCat(itemCatList);
	}

}
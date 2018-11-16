package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.entity.ItemCat;
import com.yoke.poseidon.web.mapper.ItemCatMapper;
import com.yoke.poseidon.web.service.ConvertService;
import com.yoke.poseidon.web.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	private ConvertService convertService;

	@Override
	public List<ItemCatDto> getByRemark(@NonNull String remark, Integer limit) {
		Optional<List<ItemCat>> itemCats = Optional
				.ofNullable(itemCatMapper.selectByRemark(remark, limit));
		return itemCats.map(itemCatList -> itemCatList.stream()
				.map(itemCat -> convertService.convert(itemCat))
				.collect(Collectors.toList())).orElse(Collections.emptyList());
	}

}

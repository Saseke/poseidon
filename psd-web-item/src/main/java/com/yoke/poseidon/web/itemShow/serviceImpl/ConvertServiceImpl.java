package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.entity.Item;
import com.yoke.poseidon.web.itemShow.entity.ItemCat;
import com.yoke.poseidon.web.itemShow.service.ConvertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Yoke
 * @Date 2018/10/23 下午3:19
 */

@Service
public class ConvertServiceImpl implements ConvertService {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ItemDto convertItem(@NonNull Item item) {
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	public List<ItemDto> convertItem(@NonNull List<Item> items) {
		return items.stream().map(item -> modelMapper.map(item, ItemDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ItemCatDto convertItemCat(@NonNull ItemCat itemCat) {
		return modelMapper.map(itemCat, ItemCatDto.class);
	}

	@Override
	public List<ItemCatDto> convertItemCat(@NonNull List<ItemCat> itemCats) {
		return itemCats.stream()
				.map(itemCat -> modelMapper.map(itemCat, ItemCatDto.class))
				.collect(Collectors.toList());
	}

}

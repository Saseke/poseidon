package com.yoke.poseidon.cart.serviceImpl;

import com.yoke.poseidon.cart.dto.ItemCartDto;
import com.yoke.poseidon.cart.entity.ItemCart;
import com.yoke.poseidon.cart.service.ConvertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Yoke
 * @Date 2019/01/11 下午8:51
 */
@Service
public class ConvertServiceImpl implements ConvertService {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ItemCartDto convert(ItemCart itemCart) {
		return modelMapper.map(itemCart, ItemCartDto.class);
	}

	@Override
	public List<ItemCartDto> convert(List<ItemCart> itemCartList) {
		return itemCartList.stream()
				.map(itemCart -> modelMapper.map(itemCart, ItemCartDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ItemCart convertToBean(ItemCartDto itemCartDto) {
		return modelMapper.map(itemCartDto, ItemCart.class);
	}

	@Override
	public List<ItemCart> convertToBean(List<ItemCartDto> itemCartDtos) {
		return itemCartDtos.stream()
				.map(itemCartDto -> modelMapper.map(itemCartDto, ItemCart.class))
				.collect(Collectors.toList());
	}

}

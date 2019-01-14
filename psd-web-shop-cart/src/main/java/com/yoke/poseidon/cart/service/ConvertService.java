package com.yoke.poseidon.cart.service;

import com.yoke.poseidon.cart.dto.ItemCartDto;
import com.yoke.poseidon.cart.entity.ItemCart;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2019/01/11 下午8:47
 */
public interface ConvertService {

	ItemCartDto convert(ItemCart itemCart);

	List<ItemCartDto> convert(List<ItemCart> itemCartList);

	ItemCart convertToBean(ItemCartDto itemCartDto);

	List<ItemCart> convertToBean(List<ItemCartDto> itemCartDtos);

}

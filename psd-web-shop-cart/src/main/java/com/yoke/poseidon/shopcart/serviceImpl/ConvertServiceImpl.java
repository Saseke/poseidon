package com.yoke.poseidon.shopcart.serviceImpl;

import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.entity.ShopCart;
import com.yoke.poseidon.shopcart.service.ConvertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/21 下午12:06
 */
@Service
public class ConvertServiceImpl implements ConvertService {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ShopCartDto convertShopCart(@NonNull ShopCart shopcart) {
		return modelMapper.map(shopcart, ShopCartDto.class);
	}

	@Override
	public List<ShopCartDto> convertShopCart(@NonNull List<ShopCart> shopCartList) {
		List<ShopCartDto> ret = new ArrayList<>();
		shopCartList.forEach(shopCart -> {
			ShopCartDto shopCartDto = modelMapper.map(shopCart, ShopCartDto.class);
			ret.add(shopCartDto);
		});
		return ret;
	}

}

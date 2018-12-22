package com.yoke.poseidon.shopcart.service;

import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.entity.ShopCart;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/23 下午3:20
 */
public interface ConvertService {

	ShopCartDto convertShopCart(@NonNull ShopCart shopCart);

	List<ShopCartDto> convertShopCart(@NonNull List<ShopCart> shopCartList);

}

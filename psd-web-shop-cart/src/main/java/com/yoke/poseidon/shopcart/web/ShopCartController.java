package com.yoke.poseidon.shopcart.web;

import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
@RestController
@RequestMapping("/shopCart")
public class ShopCartController {

	@Autowired
	private ShopCartService shopCartService;

	@GetMapping("/{mId}")
	public ShopCartDto shopCart(@PathVariable("mId") Long mId) {
		return shopCartService.getByMemberId(mId);
	}

}

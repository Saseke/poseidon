package com.yoke.poseidon.shopcart.serviceImpl;

import com.yoke.poseidon.shopcart.service.ShopCartItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Yoke
 * @Date 2018/12/23 上午8:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCartItemServiceImplTest {

	@Autowired
	private ShopCartItemService shopCartItemService;

	@Test
	public void addItemsToShopCart() {
		Map<String, Integer> map = new HashMap<>();
		map.put("BRGVDSVSD", 3);
		shopCartItemService.addItemsToShopCart(1L, map);
	}

	@Test
	public void deleteItemsFromShop() {

		List<String> list = new ArrayList<>();
		list.add("BRGVDSVSD");
		shopCartItemService.deleteItemsFromShopCart(1L, list);
	}

}
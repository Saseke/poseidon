package com.yoke.poseidon.shopcart.serviceImpl;

import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.service.ShopCartService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Yoke
 * @Date 2018/12/22 上午11:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertServiceImplTest {

	@Autowired
	private ShopCartService shopCartService;

	@Test
	public void convertShopCart() {
		ShopCartDto shopCartDto = shopCartService.getByMemberId(1L);
		Assert.assertNotNull(shopCartDto);
	}

	@Test
	public void convertShopCart1() {
	}

}
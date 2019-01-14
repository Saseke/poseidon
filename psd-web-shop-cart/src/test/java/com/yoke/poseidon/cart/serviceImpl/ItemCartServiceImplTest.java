package com.yoke.poseidon.cart.serviceImpl;

import com.yoke.poseidon.cart.service.ItemCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Yoke
 * @Date 2019/01/11 下午9:35
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemCartServiceImplTest {

	@Autowired
	private ItemCartService itemCartService;

	@Test
	public void list() {
	}

}
package com.yoke.poseidon.elasticsearch.service.impl;

import com.yoke.poseidon.elasticsearch.entity.Item;
import com.yoke.poseidon.elasticsearch.service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/13 上午11:23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemServiceImplTest {

	@Autowired
	private ItemService itemService;

	@Test
	public void getByName() {
		List<Item> item = itemService.getByName("ha");
		item.forEach(System.out::println);
	}

	@Test
	public void add() {
		Item item = new Item();
		item.setName("ha你好");
		itemService.add(item);
	}

	@Test
	public void delete() {
	}

	@Test
	public void update() {
	}

	@Test
	public void getByKey() {
		List<Item> list = itemService.getByKey("ha");
		list.forEach(System.out::println);
	}

	@Test
	public void getAll() {
		List<Item> list = itemService.getAll();
		Assert.assertEquals(3, list.size());
	}

}
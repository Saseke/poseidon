package com.yoke.poseidon.web.mapper;

import com.yoke.poseidon.web.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @Author Yoke
 * @Date 2018/11/17 下午2:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {

	@Autowired
	private ItemMapper itemMapper;

	@Test
	public void selectById() {
		Item item = itemMapper.selectById("rjoifjclsadcfj", false);
		Item item1 = itemMapper.selectById("BHTRTGVR", true);
		Assert.assertNull(item.getDescription());
		Assert.assertNotNull(item1.getDescription());
	}

	@Test
	public void selectIdIn() {
		List<String> list = newArrayList("BHTRTGVR", "BMRTGVFSD");
		List<Item> items = itemMapper.selectIdIn(list, "order by sort_order desc", false);
		items.forEach(System.out::println);
	}

	@Test
	public void selectByCId() {
		List<Item> list = itemMapper.selectByCId(8L, 8, null, false);
		list.forEach(System.out::println);
	}

	@Test
	public void selectByCIds() {
		List<Long> itemCatIds = newArrayList(8L, 22L);
		List<Item> list = itemMapper.selectByCIds(itemCatIds, 8, null, false);
		list.forEach(System.out::println);
	}

}
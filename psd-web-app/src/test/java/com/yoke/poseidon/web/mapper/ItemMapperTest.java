package com.yoke.poseidon.web.mapper;

import com.google.common.collect.Lists;
import com.yoke.poseidon.web.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/31 下午8:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {

	@Autowired
	private ItemMapper itemMapper;

	@Test
	public void selectById() {
		Item item = itemMapper.selectById("BHTRTGVR");
		Assert.assertNotNull(item);
	}

	@Test
	public void selectByCId() {
		ArrayList<String> orderBy = new ArrayList<String>() {
			private static final long serialVersionUID = 7438452364005054326L;

			{
				add("sort_order");
				add("price");
			}
		};
		List<Item> req2 = itemMapper.selectByCId(8L, 6, "price DESC");
		Assert.assertEquals(5399.00, req2.get(0).getPrice());
	}

}

package com.yoke.poseidon.web.mapper;

import com.yoke.poseidon.web.entity.ItemCat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/11/19 下午4:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCatMapperTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemCatMapperTest.class);

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Test
	public void selectByParentId() {
		List<ItemCat> itemCatList1 = itemCatMapper.selectByParentId(1L, null, null);
		itemCatList1.forEach(System.out::println);
		LOGGER.info("-----------------------------------------------------------------");
		List<ItemCat> itemCatList2 = itemCatMapper.selectByParentId(1L,
				"order by item_cat_id desc", 1);
		itemCatList2.forEach(System.out::println);
	}

	@Test
	public void selectIdsByParentId() {
		List<Long> integers = itemCatMapper.selectIdsByParentId(1L, null, null);
		Assert.assertNotNull(integers);
	}

	@Test
	public void selectRootCat() {
		List<ItemCat> itemCats = itemCatMapper.selectRootCat(null, 2);
		Assert.assertNotNull(itemCats);
	}

	@Test
	public void selectByRemark() {
		List<ItemCat> itemCats = itemCatMapper.selectByRemark("index", null, null);
		Assert.assertNotNull(itemCats);
	}

}
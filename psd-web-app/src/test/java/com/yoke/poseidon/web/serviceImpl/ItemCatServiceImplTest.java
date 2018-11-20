package com.yoke.poseidon.web.serviceImpl;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.service.ItemCatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/11/19 下午7:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCatServiceImplTest {

	@Autowired
	private ItemCatService itemCatService;

	@Test
	public void getByParentId() {
		List<ItemCatDto> itemCatList = itemCatService.getByParentId(1L, null, 8);
		itemCatList.forEach(System.out::println);
	}

	@Test
	public void getIdsByParentId() {
		List<Long> longList = itemCatService.getIdsByParentId(1L, null, 8);
		longList.forEach(System.out::println);
	}

	@Test
	public void getRootCat() {
		List<ItemCatDto> itemCatDtoList = itemCatService.getRootCat(null, null);
		itemCatDtoList.forEach(System.out::println);
	}

	@Test
	public void getByRemark() {
		List<ItemCatDto> itemCatDtoList = itemCatService.getByRemark("index", null, null,
				null, null, false);
		itemCatDtoList.forEach(System.out::println);
	}

}
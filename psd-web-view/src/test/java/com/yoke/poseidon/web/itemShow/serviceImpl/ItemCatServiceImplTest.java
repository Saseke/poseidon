package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.service.ItemCatService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/18 上午8:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCatServiceImplTest {

	@Autowired
	private ItemCatService itemCatService;

	@Test
	public void getByParentId() {
	}

	@Test
	public void getIdsByParentId() {
	}

	@Test
	public void getRootCat() {
		List<ItemCatDto> list = itemCatService.getRootCat(null);
		Assert.assertNotNull(list.get(0).getIsParent());
	}

	@Test
	public void getByRemark() {
	}

}
package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.yoke.poseidon.web.itemShow.dto.PanelDto;
import com.yoke.poseidon.web.itemShow.service.PanelService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/21 上午9:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PanelServiceImplTest {

	@Autowired
	private PanelService panelService;

	@Test
	public void getPanelByRemark() {
	}

	@Test
	public void getPanelByItemCatId() {
		List<PanelDto> list = panelService.getPanelByItemCatId(1L);
		Assert.assertNotNull(list);
	}

}
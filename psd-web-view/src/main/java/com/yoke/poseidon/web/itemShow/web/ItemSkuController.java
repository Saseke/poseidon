package com.yoke.poseidon.web.itemShow.web;

import com.yoke.poseidon.web.itemShow.dto.Message;
import com.yoke.poseidon.web.itemShow.entity.ItemAttribute;
import com.yoke.poseidon.web.itemShow.service.ItemSkuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yoke
 * @since 2019-06-02
 */
@RestController
@RequestMapping("/itemSku")
public class ItemSkuController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemSkuController.class);

	@Autowired
	private ItemSkuService itemSkuService;

	@GetMapping("/list")
	public Message list() {
		List<ItemAttribute> itemAttributes = itemSkuService
				.getItemInfo("GROTIGJROTIGJROTI");
		return Message.success(itemAttributes);
	}

}

package com.yoke.poseidon.web.controller;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.service.ItemCatService;
import com.yoke.poseidon.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/15 下午8:22
 */
@Controller
public class IndexController {

	@Autowired
	private ItemCatService itemCatService;

	@Autowired
	private ItemService itemService;

	@GetMapping("/")
	public String index(Model model) {
		List<ItemCatDto> itemCatDtos = itemService.getIndexCatWithItems();
		model.addAttribute("item_cat_items_list", itemCatDtos);
		return "index";
	}

	@GetMapping("/catDtl")
	public String catDtl(Model model) {
		return "catDtl";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}

}

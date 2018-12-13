package com.yoke.poseidon.elasticsearch.controller;

import com.yoke.poseidon.elasticsearch.entity.Item;
import com.yoke.poseidon.elasticsearch.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/13 下午12:10
 */
@RestController
@RequestMapping("/item/search")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/{name}/{page}/{size}")
	public List<Item> searchByKey(@PathVariable("name") String name,
			@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return itemService.getByKey(name, PageRequest.of(page - 1, size)).getContent();
	}

}

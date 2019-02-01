package com.yoke.poseidon.elasticsearch.web;

import com.yoke.poseidon.elasticsearch.dto.Message;
import com.yoke.poseidon.elasticsearch.entity.EsItem;
import com.yoke.poseidon.elasticsearch.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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
	public List<EsItem> searchByKey(@PathVariable("name") String name,
                                    @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return itemService.getByKey(name, PageRequest.of(page - 1, size)).getContent();
	}

	@GetMapping("")
	public Message list() {
		return Message.success(itemService.getAll());
	}

	@PostMapping("/sync")
	public Message syncData() {
		List<EsItem> list = itemService.syncData();
		return Message.success(null);
	}

	@GetMapping(path = "/test")
	public Message test() {
		return Message.success(itemService.test());
	}

}

package com.yoke.poseidon.web.controller;

import com.google.common.collect.Lists;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/item")
@Api(value = "itemController", description = "handle item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "get item by id", response = ItemDto.class)
	@GetMapping("/{id}/{blob}")
	public ItemDto item(@PathVariable("id") String id, @PathVariable("blob") int blob) {
		return itemService.getById(id, blob);
	}

	@ApiOperation(value = "get list of item by ids", response = List.class)
	@GetMapping("/{ids}/{sort}/{blob}")
	public List<ItemDto> items(@PathVariable("ids") String ids,
			@PathVariable("sort") String sort, @PathVariable("blob") int blob) {
		List<String> itemIds = Lists.newArrayList(ids.split(","));
		return itemService.getIdIn(itemIds, sort, blob);
	}

	@ApiOperation(value = "get list of items by cId", response = List.class)
	@GetMapping("/{cId}/{limit}/{sort}/{blob}")
	public List<ItemDto> items(@PathVariable("cId") Long cId,
			@PathVariable("limit") Integer limit, @PathVariable("sort") String sort,
			@PathVariable("blob") int blob) {
		return itemService.getByCId(cId, limit, sort, blob);
	}

	@ApiOperation(value = "get list of items by cIds", response = List.class)
	@GetMapping("/{cIds}/{limit}/{sort}/{blob}")
	public List<ItemDto> items(@PathVariable("cIds") String cIds,
			@PathVariable("limit") Integer limit, @PathVariable("sort") String sort,
			@PathVariable("blob") int blob) {
		List<Long> cIdLong = Lists.newArrayList(cIds.split(",")).stream()
				.map(Long::valueOf).collect(Collectors.toList());
		return itemService.getByCIds(cIdLong, limit, sort, blob);
	}

}

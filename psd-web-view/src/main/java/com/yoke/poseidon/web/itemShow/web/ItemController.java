package com.yoke.poseidon.web.itemShow.web;

import com.google.common.collect.Lists;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "id", value = "商品id", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob", value = "0代表不包含大字段信息,1表示包含大字段信息", required = true) })

	@GetMapping("/{id}/{blob}")
	public ItemDto item(@PathVariable("id") String id, @PathVariable("blob") int blob) {
		return itemService.getById(id, blob);
	}

	@ApiOperation(value = "get list of item by ids", response = List.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "ids", value = "商品ids,多个id用\",\"分割拼接成一个字符串", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob", value = "0代表不包含大字段信息,1表示包含大字段信息", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "sort", value = "默认按照 :order by sort_order排序,这个字段一般不用写") })
	@GetMapping({ "/{ids}/{blob}", "/{ids}/{blob}/{sort}" })
	public List<ItemDto> items(@PathVariable("ids") String ids,
			@PathVariable("blob") int blob,
			@PathVariable(value = "sort", required = false) String sort) {
		List<String> itemIds = Lists.newArrayList(ids.split(","));
		return itemService.getIdIn(itemIds, sort, blob);
	}

	@ApiOperation(value = "get list of items by cId", response = List.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "cId", value = "商品分类的id", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob", value = "0代表不包含大字段信息,1表示包含大字段信息", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制查询的条数"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "sort", value = "默认按照 :order by sort_order排序,这个字段一般不用写") })
	@GetMapping({ "/c/{cId}/{blob}/{limit}", "/c/{cId}/{blob}/{limit}",
			"/c/{cId}/{blob}/{limit}/{sort}" })
	public List<ItemDto> items(@PathVariable("cId") Long cId,
			@PathVariable("blob") int blob,
			@PathVariable(value = "limit", required = false) Integer limit,
			@PathVariable(value = "sort", required = false) String sort) {
		return itemService.getByCId(cId, limit, sort, blob);
	}

	@ApiOperation(value = "get list of items by cIds", response = List.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "cIds", value = "商品分类ids", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob", value = "0代表不包含大字段信息,1表示包含大字段信息", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制查询的条数"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "sort", value = "默认按照 :order by sort_order排序,这个字段一般不用写") })
	@GetMapping({ "/{cIds}/{blob}/{limit}", "/{cIds}/{blob}/{sort}",
			"/{cIds}/{blob}/{limit}/{sort}" })

	public List<ItemDto> items(@PathVariable("cIds") String cIds,
			@PathVariable("blob") int blob,
			@PathVariable(value = "limit", required = false) Integer limit,
			@PathVariable(value = "sort", required = false) String sort) {
		List<Long> cIdLong = Lists.newArrayList(cIds.split(",")).stream()
				.map(Long::valueOf).collect(Collectors.toList());
		return itemService.getByCIds(cIdLong, limit, sort, blob);
	}

}

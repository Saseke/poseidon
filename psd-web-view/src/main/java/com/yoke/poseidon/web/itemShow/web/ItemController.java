package com.yoke.poseidon.web.itemShow.web;

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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
	public Mono<ItemDto> item(@PathVariable("id") String id,
			@PathVariable("blob") int blob) {
		return Mono.justOrEmpty(itemService.getById(id, blob));
	}

	@ApiOperation(value = "get list of items by cId", response = Flux.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "cId", value = "商品分类的id", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob", value = "0代表不包含大字段信息,1表示包含大字段信息", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制查询的条数") })
	@GetMapping({ "/c/{cId}/{blob}", "/c/{cId}/{blob}/{limit}" })
	public Flux<ItemDto> items(@PathVariable("cId") Long cId,
			@PathVariable("blob") int blob,
			@PathVariable(value = "limit", required = false) Integer limit) {
		return Flux.fromIterable(itemService.getByCId(cId, limit, blob));
	}

}

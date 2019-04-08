package com.yoke.poseidon.cart.web;

import com.yoke.poseidon.cart.dto.ItemCartDto;
import com.yoke.poseidon.cart.dto.Message;
import com.yoke.poseidon.cart.service.ItemCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author yoke
 * @since 2019-01-11
 */
@RestController
@RequestMapping(path = "/cart")
@Api(value = "购物车")
public class ItemCartController {

	private final ItemCartService itemCartService;

	@Autowired
	public ItemCartController(ItemCartService itemCartService) {
		this.itemCartService = itemCartService;
	}

	@ApiOperation(value = "添加购物车记录", response = Boolean.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "insert", dataType = "ItemCartDto", name = "itemCartDto", value = "购物车记录信息") })
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message add(@RequestBody ItemCartDto itemCartDto) {
		if (itemCartService.add(itemCartDto)) {
			return Message.success(null);
		}
		else {
			return Message.failed("添加商品到购物车失败,请重试");
		}
	}

	@ApiOperation(value = "列出指定用户的购物车记录", response = ItemCartDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称") })
	@GetMapping(path = "/list/{nickName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message list(@PathVariable String nickName) {
		return Message.success(itemCartService.list(nickName));
	}

	@ApiOperation(value = "更新指定用户的某个商品的数量")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "itemId", value = "商品的id"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "quantity", value = "商品更新后的数量"), })
	@PatchMapping(path = "/{nickName}/{itemId}/{quantity}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message patch(@PathVariable String nickName, @PathVariable String itemId,
			@PathVariable Integer quantity) {
		if (itemCartService.updateQuantity(nickName, itemId, quantity)) {
			return Message.success();
		}
		else {
			return Message.failed("更新商品数量失败");
		}
	}

	@ApiOperation(value = "清空某个用户的购物车")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称") })
	@DeleteMapping(path = "/{nickName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message clear(@PathVariable String nickName) {
		if (itemCartService.clear(nickName)) {
			return Message.success();
		}
		else {
			return Message.failed("清空购物车失败");
		}
	}

	@ApiOperation(value = "删除购物车中单个商品")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "itemId", value = "商品的id") })
	@DeleteMapping(path = "/{nickName}/{itemId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message delete(@PathVariable String nickName, @PathVariable String itemId) {
		if (itemCartService.delete(nickName, itemId)) {
			return Message.success();
		}
		else {
			return Message.failed("删除失败");
		}
	}

	@ApiOperation(value = "更新购物车中多种商品状态信息为订单状态")
	@ApiImplicitParam(paramType = "update", dataType = "List<Long>", name = "itemCartIds", value = "购物车条目的ids")
	@PatchMapping(path = "")
	public Message submitOrder(@RequestBody List<Long> itemCartIds) {
		if (itemCartService.submitOrder(itemCartIds)) {
			return Message.success();
		}
		else {
			return Message.failed();
		}
	}

}

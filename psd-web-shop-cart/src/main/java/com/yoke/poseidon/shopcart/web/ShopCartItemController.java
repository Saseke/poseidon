package com.yoke.poseidon.shopcart.web;

import com.yoke.poseidon.shopcart.dto.Message;
import com.yoke.poseidon.shopcart.service.ShopCartItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.yoke.poseidon.shopcart.dto.Message.failed;
import static com.yoke.poseidon.shopcart.dto.Message.success;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
@RestController
@RequestMapping("/shopCartItem")
@Api(value = "购物车与商品交接", description = "处理将商品添加至购物车")
public class ShopCartItemController {

	@Autowired
	private ShopCartItemService shopCartItemService;

	@ApiOperation(value = "添加商品到指定的购物车", response = Message.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "insert", dataType = "Long", name = "shopCartId", value = "购物车id"),
			@ApiImplicitParam(paramType = "insert", dataType = "Map", name = "map", value = "商品信息,Map中key为商品id,value为商品的数量")

	})
	@PostMapping("/{shopCartId}")
	public Message add(@PathVariable("shopCartId") Long shopCartId,
			@RequestBody Map<String, Integer> map) {
		try {
			shopCartItemService.addItemsToShopCart(shopCartId, map);
			return success(null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

	@ApiOperation(value = "更新购物车信息", response = Message.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "update", dataType = "Long", name = "shopCartId", value = "购物车id"),
			@ApiImplicitParam(paramType = "update", dataType = "String", name = "itemId", value = "商品id"),
			@ApiImplicitParam(paramType = "update", dataType = "Integer", name = "count", value = "更新以后的商品的数量") })
	@PutMapping("/{shopCartId}/{itemId}/{count}")
	public Message put(@PathVariable("shopCartId") Long shopCartId,
			@PathVariable("itemId") String itemId, @PathVariable("count") Integer count) {
		try {
			Integer data = shopCartItemService.updateItemsFromShopCart(shopCartId, itemId,
					count);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

	@ApiOperation(value = "删除某个商品的信息", response = Message.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "delete", dataType = "Long", name = "shopCartId", value = "购物车的id"),
			@ApiImplicitParam(paramType = "delete", dataType = "List", name = "itemIds", value = "商品id的集合") })
	@DeleteMapping("/{shopCartId}")
	public Message delete(@NonNull @PathVariable("shopCartId") Long shopCartId,
			@RequestBody List<String> itemIds) {
		try {
			shopCartItemService.deleteItemsFromShopCart(shopCartId, itemIds);
			return success(null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

}

package com.yoke.poseidon.order.web;

import com.yoke.poseidon.order.dto.Message;
import com.yoke.poseidon.order.dto.OrderDto;
import com.yoke.poseidon.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yoke
 * @since 2019-02-03
 */
@RestController
@RequestMapping("/order")
@Api(value = "订单处理")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping(path = "/list/{buyerId}/{status}")
	@ApiOperation(value = "得到指定用户的所有订单信息", response = OrderDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "buyerId",
					value = "买家的id"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "status",
					value = "查询订单的类型: 0为未支付订单,1为支付成功的订单") })
	public Message list(@PathVariable Long buyerId, @PathVariable Integer status) {
		return Message.success(orderService.getByBuyerId(buyerId, status));
	}

	@GetMapping(path = "/list/{buyerId}/{status}/{cur}/{size}")
	@ApiOperation(value = "分页查询用户的订单")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "buyerId",
					value = "买家的id"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "status",
					value = "查询订单的类型: 0为未支付订单,1为待收,-1为查询所有订单"),
			@ApiImplicitParam(paramType = "query", dataType = "long", name = "cur",
					value = "当前页数"),
			@ApiImplicitParam(paramType = "query", dataType = "long", name = "size",
					value = "每一页返回的条数") })
	public Message list(@PathVariable Long buyerId,
			@PathVariable(required = false) Integer status, @PathVariable long cur,
			@PathVariable long size) {
		return Message.success(orderService.getPageByBuyerId(buyerId, status, cur, size));
	}

	@PostMapping(path = "")
	@ApiOperation(value = "创建一个新的订单", response = OrderDto.class)
	@ApiImplicitParam(paramType = "insert", dataType = "OrderDto", name = "orderDto",
			value = "订单信息")
	public Message create(@RequestBody OrderDto orderDto) {
		OrderDto data = orderService.createOrder(orderDto);
		if (data != null) {
			return Message.success();
		}
		else {
			return Message.failed();
		}
	}

	@DeleteMapping("/{orderId}")
	@ApiOperation(value = "取消订单", response = Message.class)
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "orderId",
			value = "订单的id")
	public Message delete(@PathVariable String orderId) {
		if (orderService.cancelOrder(orderId)) {
			return Message.success();
		}
		return Message.failed();
	}

	@PatchMapping("/{orderId}/{status}")
	@ApiOperation("更新订单的状态")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orderId", value = "订单的id"),
			@ApiImplicitParam(name = "status", value = "订单的新状态") })
	public Message update(@PathVariable String orderId, @PathVariable Integer status) {
		if (orderService.update(orderId, status)) {
			return Message.success();
		}
		return Message.failed();
	}

	@GetMapping("/{buyerId}")
	@ApiOperation(value = "对订单进行分组,0为未支付,1为待收货,2为关闭")
	@ApiImplicitParam(value = "买家的id")
	public Message groupByStatus(@PathVariable Long buyerId) {
		return Message.success(orderService.statisticStatus(buyerId));
	}

}

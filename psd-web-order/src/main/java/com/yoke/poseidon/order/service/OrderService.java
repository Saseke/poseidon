package com.yoke.poseidon.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.order.dto.OrderDto;
import com.yoke.poseidon.order.entity.Order;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yoke
 * @since 2019-02-03
 */
public interface OrderService extends IService<Order> {

	/**
	 * 根据买家id获取所有的订单信息
	 */
	List<OrderDto> getByBuyerId(@NotNull Long buyerId);

	/**
	 * 创建一个新订单
	 */
	OrderDto createOrder(@NotNull OrderDto orderDto);

	/**
	 * 取消指定id的订单信息
	 */
	boolean cancelOrder(@NotNull String orderId);

}

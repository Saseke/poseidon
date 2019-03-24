package com.yoke.poseidon.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
	List<OrderDto> getByBuyerId(@NotNull Long buyerId, @NotNull Integer status);

	/**
	 * 创建一个新订单
	 */
	OrderDto createOrder(@NotNull OrderDto orderDto);

	/**
	 * 取消指定id的订单信息
	 */
	boolean cancelOrder(@NotNull String orderId);

	/**
	 * 根据买家的id查询买家的订单,进行分页后的数据
	 * @param buyerId 买家id
	 * @param status 订单的状态
	 * @param current 当前页数
	 * @param size 每页显示的条数
	 * @return 分页后的数据
	 */
	IPage<OrderDto> getPageByBuyerId(@NotNull Long buyerId, @NotNull Integer status,
			@NotNull long current, @NotNull long size);

}

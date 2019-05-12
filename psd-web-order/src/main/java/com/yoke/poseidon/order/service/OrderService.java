package com.yoke.poseidon.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.order.dto.OrderDto;
import com.yoke.poseidon.order.entity.Order;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

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
	 * 根据买家id获取订单信息
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
	IPage<OrderDto> getPageByBuyerId(Long buyerId, Integer status, long current,
			long size);

	/**
	 * 修改订单的状态
	 * @param orderId 订单的id号
	 * @param status 0: 未支付,1:已支付，待收货,2是已收货
	 * @return 修改订单状态是否成功
	 */
	boolean update(String orderId, Integer status);

	/**
	 * 订单根据状态进行分类统计
	 * @param buyerId 买家id
	 * @return 统计得到的分类以及条数
	 */
	List<Map<Integer, Integer>> statisticStatus(Long buyerId);

}

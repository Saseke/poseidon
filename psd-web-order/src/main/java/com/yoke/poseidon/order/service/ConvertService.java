package com.yoke.poseidon.order.service;

import com.yoke.poseidon.order.dto.OrderDto;
import com.yoke.poseidon.order.dto.OrderItemDto;
import com.yoke.poseidon.order.entity.Order;
import com.yoke.poseidon.order.entity.OrderItem;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2019/02/10 下午2:51
 */
public interface ConvertService {

	OrderDto convertOrder(@NotNull Order order);

	List<OrderDto> convertOrder(@NotNull List<Order> orders);

	Order convertOrderDto(@NotNull OrderDto orderDto);

	List<Order> convertOrderDto(@NotNull List<OrderDto> orderDtoList);

	OrderItemDto convertOrderItem(@NotNull OrderItem orderItem);

	List<OrderItemDto> convertOrderItem(@NotNull List<OrderItem> orderItems);

	OrderItem convertOrderItemDto(@NotNull OrderItemDto orderItemDto);

	List<OrderItem> convertOrderItemDto(@NotNull List<OrderItemDto> orderItemDtoList);

}

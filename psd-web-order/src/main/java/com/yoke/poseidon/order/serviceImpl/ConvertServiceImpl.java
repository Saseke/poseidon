package com.yoke.poseidon.order.serviceImpl;

import com.yoke.poseidon.order.dto.OrderDto;
import com.yoke.poseidon.order.dto.OrderItemDto;
import com.yoke.poseidon.order.entity.Order;
import com.yoke.poseidon.order.entity.OrderItem;
import com.yoke.poseidon.order.service.ConvertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Yoke
 * @Date 2019/02/10 下午2:53
 */
@Service
public class ConvertServiceImpl implements ConvertService {

	private final ModelMapper modelMapper;

	@Autowired
	public ConvertServiceImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public OrderDto convertOrder(@NotNull Order order) {
		return modelMapper.map(order, OrderDto.class);
	}

	@Override
	public List<OrderDto> convertOrder(@NotNull List<Order> orders) {
		return orders.stream().map(order -> modelMapper.map(order, OrderDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Order convertOrderDto(@NotNull OrderDto orderDto) {
		return modelMapper.map(orderDto, Order.class);
	}

	@Override
	public List<Order> convertOrderDto(@NotNull List<OrderDto> orderDtoList) {
		return orderDtoList.stream()
				.map(orderDto -> modelMapper.map(orderDto, Order.class))
				.collect(Collectors.toList());
	}

	@Override
	public OrderItemDto convertOrderItem(@NotNull OrderItem orderItem) {
		return modelMapper.map(orderItem, OrderItemDto.class);
	}

	@Override
	public List<OrderItemDto> convertOrderItem(@NotNull List<OrderItem> orderItems) {
		return orderItems.stream()
				.map(orderItem -> modelMapper.map(orderItem, OrderItemDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public OrderItem convertOrderItemDto(@NotNull OrderItemDto orderItemDto) {
		return modelMapper.map(orderItemDto, OrderItem.class);
	}

	@Override
	public List<OrderItem> convertOrderItemDto(
			@NotNull List<OrderItemDto> orderItemDtoList) {
		return orderItemDtoList.stream()
				.map(orderItemDto -> modelMapper.map(orderItemDto, OrderItem.class))
				.collect(Collectors.toList());
	}

}

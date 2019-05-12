package com.yoke.poseidon.order.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.order.constants.OrderConstant;
import com.yoke.poseidon.order.dto.OrderDto;
import com.yoke.poseidon.order.dto.OrderItemDto;
import com.yoke.poseidon.order.entity.Order;
import com.yoke.poseidon.order.entity.OrderItem;
import com.yoke.poseidon.order.mapper.OrderItemMapper;
import com.yoke.poseidon.order.mapper.OrderMapper;
import com.yoke.poseidon.order.service.ConvertService;
import com.yoke.poseidon.order.service.OrderItemService;
import com.yoke.poseidon.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2019-02-03
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
		implements OrderService {

	private final OrderMapper orderMapper;

	private final ConvertService convertService;

	private final OrderItemMapper orderItemMapper;

	private final OrderItemService orderItemService;

	@Autowired
	public OrderServiceImpl(OrderMapper orderMapper, ConvertService convertService,
			OrderItemMapper orderItemMapper, OrderItemService orderItemService) {
		this.orderMapper = orderMapper;
		this.convertService = convertService;
		this.orderItemMapper = orderItemMapper;
		this.orderItemService = orderItemService;
	}

	@Override
	public List<OrderDto> getByBuyerId(@NotNull Long buyerId, @NotNull Integer op) {
		List<OrderDto> ret = convertService.convertOrder(orderMapper.selectList(
				new QueryWrapper<Order>().eq("buyer_id", buyerId).eq("status", op)));
		ret.forEach(orderDto -> {
			List<OrderItemDto> orderDetails = convertService.convertOrderItem(
					orderItemMapper.selectByOrderId(orderDto.getOrderId()));
			orderDto.setOrderItemDtoList(orderDetails);
		});
		return ret;
	}

	@Override
	public OrderDto createOrder(@NotNull OrderDto orderDto) {
		try {
			Order order = convertService.convertOrderDto(orderDto);
			String orderId = UUID.randomUUID().toString().replace("-", "");
			order.setOrderId(orderId);
			order.setCreateTime(new Date());
			order.setStatus(OrderConstant.UN_PAID);
			List<OrderItem> orderItemList = convertService
					.convertOrderItemDto(orderDto.getOrderItemDtoList());
			orderItemList.forEach(orderItem -> {
				String orderItemId = UUID.randomUUID().toString().replace("-", "");
				orderItem.setOrderId(orderId);
				orderItem.setId(orderItemId);
			});
			orderMapper.insert(order);
			orderItemService.saveBatch(orderItemList);
			return orderDto;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cancelOrder(@NotNull String orderId) {
		Order order = orderMapper.selectById(orderId);
		order.setStatus(OrderConstant.CANCEL);
		return updateById(order);
	}

	@Override
	public IPage<OrderDto> getPageByBuyerId(Long buyerId, Integer status, long current,
			long size) {
		Page page = new Page(current, size);
		IPage<OrderDto> orderDtoIPage = orderMapper.selectPageByBuyerId(page, buyerId,
				status);
		List<OrderDto> records = orderDtoIPage.getRecords();
		records.forEach(orderDto -> {
			List<OrderItemDto> orderDetails = convertService.convertOrderItem(
					orderItemMapper.selectByOrderId(orderDto.getOrderId()));
			orderDto.setOrderItemDtoList(orderDetails);
		});
		return orderDtoIPage.setRecords(records);
	}

	@Override
	public boolean update(String orderId, Integer status) {
		Order order = getById(orderId);
		if (order != null) {
			order.setStatus(status);
			return updateById(order);
		}
		return false;
	}

	@Override
	public List<Map<Integer, Integer>> statisticStatus(Long buyerId) {
		return orderMapper.groupByStatus(buyerId);
	}

}

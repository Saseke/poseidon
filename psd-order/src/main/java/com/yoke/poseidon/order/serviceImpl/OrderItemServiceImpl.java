package com.yoke.poseidon.order.serviceImpl;

import com.yoke.poseidon.order.entity.OrderItem;
import com.yoke.poseidon.order.mapper.OrderItemMapper;
import com.yoke.poseidon.order.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品关联表 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2019-02-03
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}

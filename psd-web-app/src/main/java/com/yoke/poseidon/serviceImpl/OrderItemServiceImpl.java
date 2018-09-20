package com.yoke.poseidon.serviceImpl;

import com.yoke.poseidon.entity.OrderItem;
import com.yoke.poseidon.mapper.OrderItemMapper;
import com.yoke.poseidon.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品关联表 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}

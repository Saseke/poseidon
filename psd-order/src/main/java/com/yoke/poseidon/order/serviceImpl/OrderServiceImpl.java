package com.yoke.poseidon.order.serviceImpl;

import com.yoke.poseidon.order.entity.Order;
import com.yoke.poseidon.order.mapper.OrderMapper;
import com.yoke.poseidon.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yoke
 * @since 2019-02-03
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}

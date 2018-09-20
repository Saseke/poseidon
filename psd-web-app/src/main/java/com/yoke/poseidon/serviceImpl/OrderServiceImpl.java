package com.yoke.poseidon.serviceImpl;

import com.yoke.poseidon.entity.Order;
import com.yoke.poseidon.mapper.OrderMapper;
import com.yoke.poseidon.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}

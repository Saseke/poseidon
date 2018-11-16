package com.yoke.poseidon.web.serviceImpl;

import com.yoke.poseidon.web.entity.Order;
import com.yoke.poseidon.web.mapper.OrderMapper;
import com.yoke.poseidon.web.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
		implements OrderService {

}

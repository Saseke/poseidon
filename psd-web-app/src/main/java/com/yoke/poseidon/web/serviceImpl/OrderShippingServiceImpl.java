package com.yoke.poseidon.web.serviceImpl;

import com.yoke.poseidon.web.entity.OrderShipping;
import com.yoke.poseidon.web.mapper.OrderShippingMapper;
import com.yoke.poseidon.web.service.OrderShippingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单运送表 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class OrderShippingServiceImpl extends
		ServiceImpl<OrderShippingMapper, OrderShipping> implements OrderShippingService {

}

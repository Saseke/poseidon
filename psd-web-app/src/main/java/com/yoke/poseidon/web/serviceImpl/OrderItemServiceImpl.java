package com.yoke.poseidon.web.serviceImpl;

import com.yoke.poseidon.web.entity.OrderItem;
import com.yoke.poseidon.web.mapper.OrderItemMapper;
import com.yoke.poseidon.web.service.OrderItemService;
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

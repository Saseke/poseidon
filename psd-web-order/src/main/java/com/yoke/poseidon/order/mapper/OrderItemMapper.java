package com.yoke.poseidon.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.order.cache.RedisCache;
import com.yoke.poseidon.order.entity.OrderItem;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 订单商品关联表 Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2019-02-10
 */
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)

public interface OrderItemMapper extends BaseMapper<OrderItem> {

	List<OrderItem> selectByOrderId(@NotNull @Param("order_id") String orderId);

}

package com.yoke.poseidon.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.order.cache.RedisCache;
import com.yoke.poseidon.order.entity.Order;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2019-02-03
 */
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)

public interface OrderMapper extends BaseMapper<Order> {

	/**
	 * 根据买家id 查询所有订单
	 */
	List<Order> selectByBuyerId(@NotNull @Param("buyer_id") Long buyerId);

}

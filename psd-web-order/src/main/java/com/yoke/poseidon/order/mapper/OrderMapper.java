package com.yoke.poseidon.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yoke.poseidon.order.dto.OrderDto;
import com.yoke.poseidon.order.entity.Order;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2019-02-03
 */
// @CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)

public interface OrderMapper extends BaseMapper<Order> {

	/**
	 * 根据买家id 查询所有订单
	 */
	List<Order> selectByBuyerId(@NotNull @Param("buyer_id") Long buyerId);

	IPage<OrderDto> selectPageByBuyerId(Page page, @Param("buyer_id") Long buyerId,
			@Param("status") Integer status);

	List<String> selectIdsByBuyerIdAndStatus(@NotNull @Param("buyer_id") Long buyerId,
			@NotNull @Param("status") Integer status);

	List<Map<Integer, Integer>> groupByStatus(@Param("buyer_id") Long buyer_id);

}

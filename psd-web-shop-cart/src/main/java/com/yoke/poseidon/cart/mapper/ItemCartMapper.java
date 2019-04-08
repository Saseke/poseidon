package com.yoke.poseidon.cart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.cart.cache.RedisCache;
import com.yoke.poseidon.cart.entity.ItemCart;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2019-01-11
 */
//@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface ItemCartMapper extends BaseMapper<ItemCart> {

}

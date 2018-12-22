package com.yoke.poseidon.shopcart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.shopcart.entity.ShopCartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
public interface ShopCartItemMapper extends BaseMapper<ShopCartItem> {

	List<ShopCartItem> selectByShopCartId(
			@NonNull @Param("shop_cart_id") Long shopCartId);

}

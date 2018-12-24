package com.yoke.poseidon.shopcart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.shopcart.dto.ItemDto;
import com.yoke.poseidon.shopcart.entity.ShopCartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

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

	Integer selectCountByShopCartIdAndItemId(
			@NonNull @Param("shop_cart_id") Long shopCartId,
			@NonNull @Param("itemId") String itemId);

	void addItemsToShop(@NonNull @Param("shop_cart_id") Long shop_cart_id,
			@NonNull @Param("map") Map<String, Integer> map);

	void deleteItemsFromShop(@Param("shop_cart_id") Long shop_cart_id,
			@Param("itemIds") List<String> itemIds);

	void updateItemsFromShop(@Param("shop_cart_id") Long shop_cart_id,
			@Param("item_id") String itemId, @Param("count") Integer count);

}

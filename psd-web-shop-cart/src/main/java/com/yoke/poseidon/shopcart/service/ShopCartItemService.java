package com.yoke.poseidon.shopcart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.shopcart.entity.ShopCartItem;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
public interface ShopCartItemService extends IService<ShopCartItem> {

	/**
	 * 给指定的购物车中添加商品
	 * @param shopCartId 购物车id
	 * @param map 商品id,和商品数目组成的map集合
	 */
	void addItemsToShopCart(@NonNull Long shopCartId, @NonNull Map<String, Integer> map);

	/**
	 * 根据商品ids删除商品
	 * @param shopCartId 购物车的id
	 * @param itemIds 商品的ids
	 */
	void deleteItemsFromShopCart(@NonNull Long shopCartId, @NonNull List<String> itemIds);

	/**
	 * 更新购物车的商品的数量
	 * @param shopCartId 购物车的id
	 * @param itemId 商品的id
	 * @param count 选取的商品的数量
	 * @return 返回更新之后的商品的数量
	 */
	Integer updateItemsFromShopCart(@NonNull Long shopCartId, @NonNull String itemId,
			@NonNull Integer count);

}

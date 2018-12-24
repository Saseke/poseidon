package com.yoke.poseidon.shopcart.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.shopcart.entity.ShopCartItem;
import com.yoke.poseidon.shopcart.mapper.ShopCartItemMapper;
import com.yoke.poseidon.shopcart.service.ShopCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
@Service
public class ShopCartItemServiceImpl extends ServiceImpl<ShopCartItemMapper, ShopCartItem>
		implements ShopCartItemService {

	@Autowired
	private ShopCartItemMapper shopCartItemMapper;

	@Override
	public void addItemsToShopCart(@NonNull Long shopCartId,
			@NonNull Map<String, Integer> map) {
		shopCartItemMapper.addItemsToShop(shopCartId, map);
	}

	@Override
	public void deleteItemsFromShopCart(@NonNull Long shopCartId,
			@NonNull List<String> itemIds) {
		shopCartItemMapper.deleteItemsFromShop(shopCartId, itemIds);
	}

	@Override
	public Integer updateItemsFromShopCart(@NonNull Long shopCartId,
			@NonNull String itemId, @NonNull Integer count) {
		shopCartItemMapper.updateItemsFromShop(shopCartId, itemId, count);
		return shopCartItemMapper.selectCountByShopCartIdAndItemId(shopCartId, itemId);
	}

}

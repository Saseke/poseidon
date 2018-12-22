package com.yoke.poseidon.shopcart.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.shopcart.dto.ItemDto;
import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.entity.ShopCart;
import com.yoke.poseidon.shopcart.entity.ShopCartItem;
import com.yoke.poseidon.shopcart.feign.ItemFeign;
import com.yoke.poseidon.shopcart.mapper.ShopCartItemMapper;
import com.yoke.poseidon.shopcart.mapper.ShopCartMapper;
import com.yoke.poseidon.shopcart.service.ConvertService;
import com.yoke.poseidon.shopcart.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart>
		implements ShopCartService {

	@Autowired
	private ShopCartMapper shopCartMapper;

	@Autowired
	private ItemFeign itemFeign;

	@Autowired
	private ShopCartItemMapper shopCartItemMapper;

	@Autowired
	private ConvertService convertService;

	@Override
	public ShopCartDto getByMemberId(@NonNull Long mId) {
		ShopCart shopCart = shopCartMapper.selectByMemberId(mId);
		ShopCartDto shopCartDto = convertService.convertShopCart(shopCart);
		List<ShopCartItem> shopCartItemList = shopCartItemMapper
				.selectByShopCartId(shopCart.getShopCartId());
		List<String> itemIds = shopCartItemList.stream().map(ShopCartItem::getItemId)
				.collect(Collectors.toList());
		List<ItemDto> itemDtoList = itemFeign.items(itemIds);
		itemDtoList.forEach(itemDto -> addCount(itemDto, shopCartItemList));
		shopCartDto.setItemDtoList(itemDtoList);
		return shopCartDto;
	}

	private void addCount(ItemDto itemDto, List<ShopCartItem> shopCartItemList) {
		String itemId = itemDto.getItemId();
		Integer count = shopCartItemList.stream()
				.filter(shopCartItem -> shopCartItem.getItemId().equals(itemId))
				.collect(Collectors.toList()).get(0).getItemCount();
		itemDto.setCount(count);
	}

}

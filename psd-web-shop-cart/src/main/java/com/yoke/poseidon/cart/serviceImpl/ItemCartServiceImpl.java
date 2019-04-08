package com.yoke.poseidon.cart.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.cart.dto.ItemCartDto;
import com.yoke.poseidon.cart.entity.ItemCart;
import com.yoke.poseidon.cart.mapper.ItemCartMapper;
import com.yoke.poseidon.cart.service.ConvertService;
import com.yoke.poseidon.cart.service.ItemCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2019-01-11
 */
@Service
public class ItemCartServiceImpl extends ServiceImpl<ItemCartMapper, ItemCart>
		implements ItemCartService {

	private final ConvertService convertService;

	private final ItemCartMapper itemCartMapper;

	@Autowired
	public ItemCartServiceImpl(ConvertService convertService,
			ItemCartMapper itemCartMapper) {
		this.convertService = convertService;
		this.itemCartMapper = itemCartMapper;
	}

	@Override
	public boolean add(@NonNull ItemCartDto itemCartDto) {
		ItemCart itemCart = convertService.convertToBean(itemCartDto);
		// ItemCart exist = getById(itemCartDto.getItemCartId());
		ItemCart exist = getOne(new QueryWrapper<ItemCart>()
				.eq("item_id", itemCart.getItemId()).eq("item_cart_status", 0));
		if (exist == null) {
			itemCart.setCreateDate(new Date());
			itemCart.setItemCartStatus(0);
			return save(itemCart);
		}
		else {
			itemCart.setItemCartId(exist.getItemCartId());
			itemCart.setModifyDate(new Date());
			itemCart.setQuantity(exist.getQuantity() + itemCartDto.getQuantity());
			return updateById(itemCart);
		}
	}

	@Override
	public List<ItemCartDto> list(@NonNull String nickName) {
		List<ItemCart> itemCartList = list(new QueryWrapper<ItemCart>()
				.eq("member_nickname", nickName).eq("item_cart_status", 0));
		return convertService.convert(itemCartList);
	}

	@Override
	public boolean updateQuantity(@NonNull String nickName, @NonNull String itemId,
			@NonNull Integer quantity) {
		ItemCart itemCart = getOne(new QueryWrapper<ItemCart>()
				.eq("member_nickname", nickName).eq("item_id", itemId));
		if (!quantity.equals(itemCart.getQuantity())) {
			itemCart.setQuantity(quantity);
			return updateById(itemCart);
		}
		return true;
	}

	@Override
	public boolean submitOrder(@NotNull Long itemCartId) {
		ItemCart itemCart = getById(itemCartId);
		if (itemCart != null) {
			itemCart.setItemCartStatus(1);
			updateById(itemCart);
		}
		return true;
	}

	@Override
	public boolean submitOrder(@NotNull List<Long> itemCartIds) {
		try {
			List<ItemCart> itemCartList = itemCartMapper.selectBatchIds(itemCartIds);
			itemCartList.forEach(itemCart -> itemCart.setItemCartStatus(1));
			updateBatchById(itemCartList);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean clear(@NonNull String nickName) {
		try {
			List<ItemCart> itemCartList = list(new QueryWrapper<ItemCart>()
					.eq("member_nickname", nickName).eq("status", 0));
			itemCartList.forEach(itemCart -> itemCart.setItemCartStatus(1));
			updateBatchById(itemCartList);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(@NonNull String nickName, @NonNull String itemId) {
		try {
			ItemCart itemCart = getOne(new QueryWrapper<ItemCart>()
					.eq("member_nickname", nickName).eq("item_cart_id", itemId));
			itemCart.setItemCartStatus(1);
			updateById(itemCart);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

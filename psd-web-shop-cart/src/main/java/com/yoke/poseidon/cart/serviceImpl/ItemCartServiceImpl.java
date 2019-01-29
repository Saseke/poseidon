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

	@Autowired
	private ConvertService convertService;

	@Override
	public boolean add(@NonNull ItemCartDto itemCartDto) {
		ItemCart itemCart = convertService.convertToBean(itemCartDto);
		ItemCart exist = getById(itemCartDto.getItemCartId());
		if (exist == null) {
			itemCart.setCreateDate(new Date());
			itemCart.setItemCartStatus(1);
			return save(itemCart);
		}
		else {
			itemCart.setModifyDate(new Date());
			itemCart.setQuantity(exist.getQuantity() + itemCartDto.getQuantity());
			return updateById(itemCart);
		}
	}

	@Override
	public List<ItemCartDto> list(@NonNull String name) {
		List<ItemCart> itemCartList = list(
				new QueryWrapper<ItemCart>().eq("member_nickname", name));
		return convertService.convert(itemCartList);
	}

	@Override
	public boolean updateQuantity(@NonNull Long memberId, @NonNull String itemId,
			@NonNull Integer quantity) {
		ItemCart itemCart = getOne(new QueryWrapper<ItemCart>().eq("member_id", memberId)
				.eq("item_id", itemId));
		itemCart.setQuantity(quantity);
		return updateById(itemCart);
	}

	@Override
	public boolean clear(@NonNull Long memberId) {
		return remove(new QueryWrapper<ItemCart>().eq("member_id", memberId));
	}

	@Override
	public boolean delete(@NonNull Long memberId, @NonNull String itemId) {
		return remove(new QueryWrapper<ItemCart>().eq("member_id", memberId).eq("item_id",
				itemId));
	}

}

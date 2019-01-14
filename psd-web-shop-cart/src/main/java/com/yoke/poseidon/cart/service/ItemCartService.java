package com.yoke.poseidon.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.cart.dto.ItemCartDto;
import com.yoke.poseidon.cart.entity.ItemCart;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author yoke
 * @since 2019-01-11
 */
public interface ItemCartService extends IService<ItemCart> {

	/**
	 * 查询购物中是否包含该商品，包含增加数量，无则添加
	 */
	@Transactional
	boolean add(@NonNull ItemCartDto itemCartDto);

	/**
	 * 根据用户编号获取购物车信息
	 */
	List<ItemCartDto> list(@NonNull Long memberId);

	/**
	 * 更新购物车中某个商品的数量
	 */
	boolean updateQuantity(@NonNull Long memberId, @NonNull String itemId,
			@NonNull Integer quantity);

	/**
	 * 清空购物车
	 */
	boolean clear(@NonNull Long memberId);

	/**
	 * 清空购物车中的某一种商品
	 */
	boolean delete(@NonNull Long memberId, @NonNull String itemId);

}

package com.yoke.poseidon.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.cart.dto.ItemCartDto;
import com.yoke.poseidon.cart.entity.ItemCart;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
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
	 * 根据用户名称获取购物车信息
	 */
	List<ItemCartDto> list(@NonNull String nickName);

	/**
	 * 更新购物车中某个商品的数量
	 */
	boolean updateQuantity(@NonNull String nickName, @NonNull String itemId,
			@NonNull Integer quantity);

	/**
	 * 更新购物车项的信息为已购买状态
	 */
	boolean submitOrder(@NotNull Long itemCartId);

	/**
	 * 更新多个购物车条目为已购买状态
	 */
	boolean submitOrder(@NotNull List<Long> itemCartIds);

	/**
	 * 清空购物车
	 */
	boolean clear(@NonNull String nickName);

	/**
	 * 清空购物车中的某一种商品
	 */
	boolean delete(@NonNull String nickName, @NonNull String itemId);

}

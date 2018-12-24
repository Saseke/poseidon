package com.yoke.poseidon.shopcart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.entity.ShopCart;
import org.springframework.lang.NonNull;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
public interface ShopCartService extends IService<ShopCart> {

	/**
	 * 根据用户id查询他的购物车信息，包含购物车中的商品
	 * @param mId 用户id
	 * @return 查询得到的购物车信息
	 */
	ShopCartDto getByMemberId(@NonNull Long mId);

}

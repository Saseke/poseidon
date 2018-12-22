package com.yoke.poseidon.shopcart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.entity.ShopCart;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
public interface ShopCartService extends IService<ShopCart> {

	ShopCartDto getByMemberId(@NonNull Long mId);

}

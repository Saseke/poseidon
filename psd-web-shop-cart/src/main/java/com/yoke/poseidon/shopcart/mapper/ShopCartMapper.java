package com.yoke.poseidon.shopcart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.shopcart.entity.ShopCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
public interface ShopCartMapper extends BaseMapper<ShopCart> {

	ShopCart selectByMemberId(@NonNull @Param("mId") Long mId);

}

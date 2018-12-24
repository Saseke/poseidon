package com.yoke.poseidon.shopcart.web;

import com.yoke.poseidon.shopcart.dto.Message;
import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.service.ShopCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yoke.poseidon.shopcart.dto.Message.failed;
import static com.yoke.poseidon.shopcart.dto.Message.success;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
@RestController
@RequestMapping("/shopCart")
@Api(value = "购物车", description = "处理购物车的逻辑")
public class ShopCartController {

	@Autowired
	private ShopCartService shopCartService;

	@ApiOperation(value = "根据用户id获取对应的购物车信息", response = ShopCartDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "mId", value = "用户id") })
	@GetMapping("/{mId}")
	public Message shopCart(@PathVariable("mId") Long mId) {
		try {
			ShopCartDto data = shopCartService.getByMemberId(mId);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

}

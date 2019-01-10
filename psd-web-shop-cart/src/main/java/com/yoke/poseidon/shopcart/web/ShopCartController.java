package com.yoke.poseidon.shopcart.web;

import com.yoke.poseidon.shopcart.dto.Message;
import com.yoke.poseidon.shopcart.dto.ShopCartDto;
import com.yoke.poseidon.shopcart.service.ShopCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping(path = "/{mId}", consumes = MediaType.APPLICATION_JSON_VALUE)
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

	@GetMapping("/test")
	public void handle(@RequestHeader("Accept-Encoding") String encode) {
		System.out.println(encode);
	}

}

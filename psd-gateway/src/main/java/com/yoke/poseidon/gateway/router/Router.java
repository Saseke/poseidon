package com.yoke.poseidon.gateway.router;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author Yoke
 * @Date 2018/12/24 上午10:58
 */
public class Router {

	@Value("/view/**")
	private String web_view_service;

	@Value("/cart/**")
	private String web_shop_cart_service;

	public String getWeb_view_service() {
		return web_view_service;
	}

	public String getWeb_shop_cart_service() {
		return web_shop_cart_service;
	}

}

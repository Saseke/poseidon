package com.yoke.poseidon.gateway.web;

import org.springframework.http.HttpEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Yoke
 * @Date 2019/01/11 下午8:01
 */
@RestController
@RequestMapping("/")
public class GateWayController {

	public String curUser(HttpEntity entity) {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		return (String) token.getPrincipal();
	}

}

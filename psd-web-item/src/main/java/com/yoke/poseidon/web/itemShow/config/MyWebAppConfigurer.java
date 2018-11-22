package com.yoke.poseidon.web.itemShow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Yoke
 * @Date 2018/10/18 下午2:36
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/pic/**")
				.addResourceLocations("file:/home/yoke/Desktop/image/");
	}

}

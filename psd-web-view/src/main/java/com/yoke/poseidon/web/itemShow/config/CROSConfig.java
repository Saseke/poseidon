package com.yoke.poseidon.web.itemShow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @Author Yoke
 * @Date 2018/12/18 上午9:12
 */
@Configuration
public class CROSConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedHeaders("*").allowedMethods("*")
				.allowedOrigins("*");
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUrlPathHelper(urlPathHelper());
	}

	@Bean
	public UrlPathHelper urlPathHelper() {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		return urlPathHelper;
	}

}

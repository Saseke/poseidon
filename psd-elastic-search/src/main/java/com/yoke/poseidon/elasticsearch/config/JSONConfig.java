package com.yoke.poseidon.elasticsearch.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Yoke
 * @Date 2019/01/29 下午2:55
 */
@Configuration
public class JSONConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}

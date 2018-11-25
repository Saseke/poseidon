package com.yoke.poseidon.auth;

import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author Yoke
 * @Date 2018/11/24 下午9:01
 */
@MapperScan(basePackages = "com.yoke.poseidon.auth.mapper")
@SpringBootApplication
public class AuthApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}

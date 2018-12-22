package com.yoke.poseidon.shopcart;

import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @Author Yoke
 * @Date 2018/12/21 上午11:30
 */
@EnableFeignClients
@SpringBootApplication
@MapperScan(basePackages = "com.yoke.poseidon.shopcart.mapper")
public class ShopCartApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ShopCartApplication.class, args);
	}

}

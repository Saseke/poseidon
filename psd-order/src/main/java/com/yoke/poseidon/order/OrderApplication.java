package com.yoke.poseidon.order;

import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author Yoke
 * @Date 2019/01/24 下午1:44
 */
@MapperScan(basePackages = "com.yoke.poseidon.order.mapper")
@SpringBootApplication
public class OrderApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}

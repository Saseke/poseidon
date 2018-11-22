package com.yoke.poseidon.web.itemShow;

import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author ethereal
 * @since 2018-09-23 20:20
 */
@MapperScan(basePackages = "com.yoke.poseidon.web.itemShow.mapper")
@SpringBootApplication
public class ItemShowServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ItemShowServiceApplication.class, args);
	}

}
package com.yoke.poseidon.member;

import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author Yoke
 * @Date 2019/01/24 下午1:44
 */
@MapperScan(basePackages = "com.yoke.poseidon.member.mapper")
@SpringBootApplication
public class MemberApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

}

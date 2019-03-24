package com.yoke.poseidon.order.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author Yoke
 * @Date 2019/03/24 上午10:03
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.yoke.poseidon.order.mapper")
public class MybatisPlusConfig {

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

}

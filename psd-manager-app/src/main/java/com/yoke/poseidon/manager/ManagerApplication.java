package com.yoke.poseidon.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ethereal
 * @since 2018-09-23 20:02
 */
@MapperScan(basePackages = "com.yoke.poseidon.manager.mapper")
@SpringBootApplication
public class ManagerApplication {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}

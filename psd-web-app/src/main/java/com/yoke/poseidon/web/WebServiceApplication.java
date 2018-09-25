package com.yoke.poseidon.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ethereal
 * @since 2018-09-23 20:20
 */
@MapperScan(basePackages = "com.yoke.poseidon.web.mapper")
@SpringBootApplication
public class WebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }
}

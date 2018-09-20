package com.yoke.poseidon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author ethereal
 * @since 2018-09-20 20:40
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yoke.poseidon.mapper")
public class WebApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(WebApplication.class).web(true).run(args);
    }
}
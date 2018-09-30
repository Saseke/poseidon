package com.yoke.poseidon.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ethereal
 * @since 2018-09-23 20:02
 */
@MapperScan(basePackages = "com.yoke.poseidon.manager.mapper")
@EnableFeignClients
@SpringBootApplication
public class ManagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }


}

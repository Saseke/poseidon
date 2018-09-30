package com.yoke.poseidon.manager.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ethereal
 * @since 2018-09-26 14:37
 */
@FeignClient(value = "web-app", fallback = ItemServiceHystric.class)
public interface ItemServiceHi {
    @GetMapping("/item/hello")
    String hello();
}

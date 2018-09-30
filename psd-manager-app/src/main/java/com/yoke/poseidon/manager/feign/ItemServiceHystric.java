package com.yoke.poseidon.manager.feign;

import org.springframework.stereotype.Component;

/**
 * @author ethereal
 * @since 2018-09-26 15:12
 */
@Component
public class ItemServiceHystric implements ItemServiceHi {

    @Override
    public String hello() {
        return "sorry";
    }
}

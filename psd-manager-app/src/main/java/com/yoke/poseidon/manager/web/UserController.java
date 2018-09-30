package com.yoke.poseidon.manager.web;


import com.yoke.poseidon.manager.entity.User;
import com.yoke.poseidon.manager.feign.ItemServiceHi;
import com.yoke.poseidon.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${profile}")
    String name;

    @Autowired
    private UserService userService;
    @Autowired
    private ItemServiceHi itemServiceHi;

    @GetMapping("")
    public User list() {
        return userService.getById(1);
    }

    @GetMapping("/list")
    public String getAllItem() {
        return itemServiceHi.hello();
    }

    @GetMapping("/test")
    public String ho() {
        return name;
    }
}


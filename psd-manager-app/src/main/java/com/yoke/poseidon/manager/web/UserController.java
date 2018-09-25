package com.yoke.poseidon.manager.web;


import com.yoke.poseidon.manager.entity.User;
import com.yoke.poseidon.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @GetMapping("")
    public User list() {
        return userService.getById(1);
    }

    @GetMapping("/list")
    public String getAllItem() {
        return userService.hello();
    }
}


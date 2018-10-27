package com.yoke.poseidon.web.controller;

import com.yoke.poseidon.web.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Yoke
 * @Date 2018/10/15 下午8:22
 */
@Controller
public class IndexController {

    @Autowired
    private ItemCatService itemCatService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/catDtl")
    public String catDtl(Model model) {
        return "catDtl";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}

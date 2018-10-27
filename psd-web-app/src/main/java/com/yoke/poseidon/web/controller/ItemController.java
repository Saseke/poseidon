package com.yoke.poseidon.web.controller;


import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public List<Item> listAll(@RequestParam String prop,
                              @RequestParam String order,
                              @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer limit
    ) {
        return itemService.getAll(prop, order, page, limit);
    }

    @GetMapping("/{catId}")
    public String getItemByCatId(@PathVariable @NonNull Long catId, Model model) {
        List<ItemCatDto> itemCatDtos = itemService.getByCatId(catId);
        model.addAttribute("itemCatDtos", itemCatDtos);
        return "catDtl";
    }

    @GetMapping("/d/{itemId}")
    public String getItemByItemId(@PathVariable Long itemId, Model model) {
        return "itemDtl.html";
    }
}

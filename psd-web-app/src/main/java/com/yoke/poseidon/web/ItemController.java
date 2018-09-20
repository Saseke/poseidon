package com.yoke.poseidon.web;


import com.yoke.poseidon.entity.Item;
import com.yoke.poseidon.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public Item test(){
        Item item = itemService.getById("0833E101-A94B-32A4-4672-434A4097DC4D");
        System.out.println(item);
        return item;
    }
}


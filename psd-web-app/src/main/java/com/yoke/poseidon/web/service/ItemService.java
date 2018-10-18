package com.yoke.poseidon.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
public interface ItemService extends IService<Item> {

    Item findByItemTitle(String title);

    List<Item> getAll(String prop, String order, Integer page, Integer limit);

    List<ItemDto> findItemCatWithItems(String itemCatName, Integer limit);
}

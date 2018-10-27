package com.yoke.poseidon.web.service;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.entity.ItemCat;

/**
 * @Author Yoke
 * @Date 2018/10/23 下午3:20
 */
public interface ConvertService {
    public ItemDto convert(Item item);

    public ItemCatDto convert(ItemCat itemCat);


}

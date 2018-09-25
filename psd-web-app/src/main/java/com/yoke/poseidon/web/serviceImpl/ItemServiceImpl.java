package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.mapper.ItemMapper;
import com.yoke.poseidon.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item findByItemTitle(String title) {
        return itemMapper.findByItemTitle(title);
    }

    @Override
    public List<Item> getAll(String prop, String order, Integer page, Integer limit) {
        return itemMapper.getAll(prop, order, limit, (page - 1) * limit);
    }

}

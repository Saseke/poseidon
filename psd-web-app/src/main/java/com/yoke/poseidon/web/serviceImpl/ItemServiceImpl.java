package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.entity.ItemCat;
import com.yoke.poseidon.web.mapper.ItemCatMapper;
import com.yoke.poseidon.web.mapper.ItemMapper;
import com.yoke.poseidon.web.service.ConvertService;
import com.yoke.poseidon.web.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Autowired
    private ConvertService convertService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Item findByItemTitle(String title) {
        return itemMapper.findByItemTitle(title);
    }

    @Override
    public List<Item> getAll(String prop, String order, Integer page, Integer limit) {
        return itemMapper.getAll(prop, order, limit, (page - 1) * limit);
    }

    @Override
    public List<ItemDto> findItemCatWithItems(String itemCatName, Integer limit) {
        return itemMapper.findItemCatWithItems(itemCatName, limit);
    }

    @Override
    public List<ItemCatDto> getByCatId(Long catId) {
        List<ItemCatDto> ret = new ArrayList<>();
        List<ItemCat> itemCats = itemCatMapper.selectList(
                new QueryWrapper<ItemCat>().eq("parent_id", catId)
        );
        if (itemCats.size() != 0) {
            for (ItemCat itemCat : itemCats) {
                ItemCatDto itemCatDto = modelMapper.map(itemCat, ItemCatDto.class);
                List<ItemDto> itemDtos = itemMapper.selectList(
                        new QueryWrapper<Item>()
                                .eq("c_id", itemCatDto.getItemCatId())
                                .orderByAsc("sort_order")
                                .last("limit 8")
                ).stream().map(item -> convertService.convert(item)).collect(Collectors.toList());
                itemCatDto.setItems(itemDtos);
                ret.add(itemCatDto);
            }
        }
        return ret;
    }

    @Override
    public List<ItemCatDto> getByCatRemark(String remark, Integer limit) {
        List<ItemCatDto> ret = new ArrayList<>();
        List<ItemCat> itemCats = itemCatMapper.selectList(
                new QueryWrapper<ItemCat>()
                        .eq("remark", remark)
                        .orderByAsc("sort_order")
        );
        for (ItemCat itemCat : itemCats) {
            ItemCatDto itemCatDto = modelMapper.map(itemCat, ItemCatDto.class);
            List<ItemDto> itemDtos = itemMapper.selectList(
                    new QueryWrapper<Item>()
                            .eq("c_id", itemCatDto.getItemCatId())
                            .orderByAsc("sort_order")
                            .last("limit " + limit)
            ).stream().map(item -> convertService.convert(item)).collect(Collectors.toList());
            itemCatDto.setItems(itemDtos);
            ret.add(itemCatDto);
        }
        return ret;
    }
}

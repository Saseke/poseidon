package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    public List<ItemCatDto> getByCatId(Long catId, Integer limit) {
        Optional<List<ItemCat>> itemCats = Optional.ofNullable(itemCatMapper.selectList(
                new QueryWrapper<ItemCat>().eq("parent_id", catId))
        );
        return itemCats.map(itemCatsList -> getItemsByCats(itemCatsList, limit))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<ItemCatDto> getByCatRemark(String remark, Integer limit) {

        Optional<List<ItemCat>> itemCats = Optional.ofNullable(itemCatMapper.selectList(
                new QueryWrapper<ItemCat>()
                        .eq("remark", remark)
                        .orderByAsc("sort_order"))
        );
        return itemCats.map(itemCatsList -> getItemsByCats(itemCatsList, limit))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<ItemCatDto> getIndexCatWithItems() {
        Optional<List<ItemCat>> itemRootCats = Optional.ofNullable(itemCatMapper.selectList(
                new QueryWrapper<ItemCat>()
                        .eq("parent_id", 0).eq("remark", "index")
        ));
        return itemRootCats.map(this::getItemsByRootCat).orElse(Collections.emptyList());
    }

    @Override
    public List<ItemCatDto> getSiteRootCatWithItems(Integer limit) {
        Optional<List<ItemCat>> itemRootCats = Optional.ofNullable(itemCatMapper.selectList(
                new QueryWrapper<ItemCat>()
                        .eq("parent_id", 0)
        ));
        return itemRootCats.map(this::getItemsByRootCat).orElse(Collections.emptyList());
    }

    @Override
    public List<List<ItemCatDto>> getSiteRootCatWithItemsPart(Integer limit) {
        return Lists.partition(getSiteRootCatWithItems(limit), 2);
    }

    private List<ItemCatDto> getItemsByRootCat(List<ItemCat> itemRootCatList) {
        return itemRootCatList.stream().map(itemRootCat -> {
            ItemCatDto itemCatDto = modelMapper.map(itemRootCat, ItemCatDto.class);
            List<ItemCat> childCats = itemCatMapper.selectList(new QueryWrapper<ItemCat>().eq("parent_id", itemRootCat.getItemCatId()).orderByAsc("sort_order"));
            List<Long> ids = new ArrayList<>();
            ids.add(itemRootCat.getItemCatId());
            if (childCats.size() > 0) {
                ids.addAll(childCats.stream().map(ItemCat::getItemCatId).collect(Collectors.toList()));
            }
            List<ItemDto> itemDtos = itemMapper.selectItems(ids)
                    .stream().map(item -> modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
            itemCatDto.setItems(itemDtos);
            return itemCatDto;
        }).collect(Collectors.toList());
    }

    private List<ItemCatDto> getItemsByCats(List<ItemCat> itemCatsList, Integer limit) {
        return itemCatsList.stream().map(itemCat -> {
            ItemCatDto itemCatDto = modelMapper.map(itemCat, ItemCatDto.class);
            List<ItemDto> itemDtos = itemMapper.selectList(
                    new QueryWrapper<Item>()
                            .eq("c_id", itemCatDto.getItemCatId())
                            .orderByAsc("sort_order")
                            .last("limit " + limit)
            ).stream().map(item -> convertService.convert(item)).collect(Collectors.toList());
            itemCatDto.setItems(itemDtos);
            return itemCatDto;
        }).collect(Collectors.toList());
    }
}

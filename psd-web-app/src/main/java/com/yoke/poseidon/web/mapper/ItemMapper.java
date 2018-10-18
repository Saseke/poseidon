package com.yoke.poseidon.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
public interface ItemMapper extends BaseMapper<Item> {

    Item findByItemTitle(String title);

    List<Item> getAll(
            @Param("prop") String prop,
            @Param("order") String order,
            @Param("limit") Integer limit,
            @Param("offset") Integer offset);

    List<ItemDto> findItemCatWithItems(
            @Param("itemCatName") String itemCatName,
            @Param("limit") Integer limit);
}

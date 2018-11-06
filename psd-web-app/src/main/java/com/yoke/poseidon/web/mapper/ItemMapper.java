package com.yoke.poseidon.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.entity.ItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2018-10-30
 */
public interface ItemMapper extends BaseMapper<Item> {
    List<Item> selectItems(@Param("cIds") List<Long> cIds);
}

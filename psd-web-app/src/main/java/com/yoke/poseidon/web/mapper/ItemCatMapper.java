package com.yoke.poseidon.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.entity.ItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
public interface ItemCatMapper extends BaseMapper<ItemCat> {

    List<ItemCat> listRootCat();

    List<ItemCatDto> listCatBySortOrder(@Param("limit") int limit);
}

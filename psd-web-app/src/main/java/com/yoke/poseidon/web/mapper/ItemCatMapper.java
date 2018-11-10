package com.yoke.poseidon.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.entity.ItemCat;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

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

    /**
     * 根据分类id查找子分类
     *
     * @param pId 父分类id
     * @return 查询得到的子分类
     */
    List<ItemCat> selectByParentId(@NonNull @Param("pId") Long pId);

    /**
     * 根据父分类查找子分类的所有id
     */
    List<Long> selectChildIdsByParentId(@NonNull @Param("pId") Long pId);

    /**
     * 根据分类ids查询子分类
     *
     * @param ids 父类ids
     * @return 查询得到的子分类
     */
    List<ItemCat> selectByParentIds(@NonNull @Param("ids") List<Long> ids);

    /**
     * 查询根分类
     *
     * @return 查询得到的根分类
     */
    List<ItemCat> selectRootCat();

    /**
     * 根据分类
     *
     * @param remark 查询的remark
     * @param limit  查询的条数
     * @return 查询得到的分类
     */
    List<ItemCat> selectByRemark(@NonNull @Param("remark") String remark, @Param("limit") Integer limit);

    /**
     * 根据分类的Root的ids查询商品
     * @param ids
     * @return
     */
    List<ItemCatDto> selectByRootCatIds(@NonNull @Param("ids") List<Long> ids);
}

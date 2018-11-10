package com.yoke.poseidon.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.entity.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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

    /**
     * 根据商品id得到Item的部分信息信息,不包括BLOB
     */
    Item selectById(@NonNull @Param("id") String itemId);

    /**
     * 根据商品id得到Item的所有信息
     */
    Item selectByIdWithBLOB(@NonNull @Param("id") String itemId);

    /**
     * 根据一群ids查询得到相对应的商品
     */
    List<Item> selectIdIn(@NonNull @Param("ids") List<String> itemIds);


    /**
     * 根据一群ids查询得到相对应的商品的所有信息,
     */
    List<Item> selectIdInWithBLOG(@NonNull @Param("ids") List<String> itemIds);


    /**
     * 根据商品id得到Item的部分信息,不包括BLOB
     *
     * @param cId   商品 id
     * @param limit 显示的条数
     * @param sort  条件
     * @return 查询得到的商品列表
     */
    List<Item> selectByCId(@NonNull @Param("cId") Long cId,
                           @Nullable @Param("limit") Integer limit,
                           @Nullable @Param("sort") String sort);

    /**
     * 根据商品id得到Item的全部信息
     *
     * @param cId   商品 id
     * @param limit 显示的条数
     * @param sort  条件
     * @return 查询得到的商品列表
     */
    List<Item> selectByCIdWithBLOG(@NonNull @Param("cId") Long cId,
                                   @Nullable @Param("limit") Integer limit,
                                   @Nullable @Param("sort") String sort);


    /**
     * 根据分类ids查询出对应的Items部分信息
     *
     * @param cIds 分类id集合
     * @return 查询得出的商品集合
     */
    List<Item> selectByCIds(@NonNull @Param("cIds") List<Long> cIds, @Param("limit") Integer limit);


    /**
     * 根据分类ids查询对应的Items包含商品全部信息
     *
     * @param cIds 分类id的集合
     * @return 查询得出商品集合
     */
    List<Item> selectByCIdsWithBLOB(@NonNull @Param("cIds") List<Long> cIds);


}

package com.yoke.poseidon.web.itemShow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.itemShow.cache.RedisCache;
import com.yoke.poseidon.web.itemShow.entity.Item;
import org.apache.ibatis.annotations.CacheNamespace;
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
//@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface ItemMapper extends BaseMapper<Item> {

	Item select(@Param("itemId") String itemId, @Param("blob") boolean blob);

	/**
	 * 根据一群ids查询得到相对应的商品
	 * @param itemIds 商品ids
	 * @param sort 排序方式,默认根据sort_order升序排列
	 * @param blob 是否包含大字段信息
	 * @return 查询得到的商品列表
	 */
	List<Item> selectIdIn(@NonNull @Param("ids") List<String> itemIds,
			@Param("sort") String sort, @NonNull @Param("blob") boolean blob);

	/**
	 * 根据商品id得到Item的部分信息,不包括BLOB
	 * @param cId 商品 id
	 * @param limit 显示的条数
	 * @param sort 排序方式,默认根据sort_order排序
	 * @param blob 是否包含大字段信息
	 * @return 查询得到的商品列表
	 */
	List<Item> selectByCId(@NonNull @Param("cId") Long cId, @Param("limit") Integer limit,
			@Nullable @Param("sort") String sort, @Param("blob") boolean blob);

	/**
	 * 根据分类ids查询出对应的Items部分信息
	 * @param cIds 分类id集合
	 * @param limit 显示的条数
	 * @param sort 排序方式,默认根据sort_order排序
	 * @param blob 是否包含大字段信息
	 * @return 查询得出的商品集合
	 */
	List<Item> selectByCIds(@NonNull @Param("cIds") List<Long> cIds,
			@Param("limit") Integer limit, @Param("sort") String sort,
			@NonNull @Param("blob") boolean blob);

}

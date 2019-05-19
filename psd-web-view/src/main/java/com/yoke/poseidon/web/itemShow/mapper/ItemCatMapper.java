package com.yoke.poseidon.web.itemShow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.itemShow.entity.ItemCat;
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
// @CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface ItemCatMapper extends BaseMapper<ItemCat> {

	// ItemCat selectById(@NonNull Long id);

	/**
	 * 根据分类id查找子分类
	 * @param pId 父分类id
	 * @return 查询得到的子分类
	 */
	List<ItemCat> selectByParentId(@NonNull @Param("pId") Long pId,
			@Param("sort") String sort, @Param("limit") Integer limit);

	/**
	 * 根据父分类查找子分类的所有id
	 */
	List<Long> selectIdsByParentId(@NonNull @Param("pId") Long pId,
			@Param("sort") String sort, @Param("limit") Integer limit);

	/**
	 * 查询得到根分类
	 * @param sort 排序方式
	 * @param limit 限制查询的条数
	 * @return 查询得到的数据
	 */
	List<ItemCat> selectRootCat(@Param("sort") String sort,
			@Param("limit") Integer limit);

	/**
	 * 根据remark类型得到分类
	 * @param remark 标记
	 * @param sort 排序方式
	 * @param limit 限制查询的条数
	 * @return 查询得到的数据
	 */
	List<ItemCat> selectByRemark(@NonNull @Param("remark") String remark,
			@Param("sort") String sort, @Param("limit") Integer limit);

	int update(@Param("itemCat") ItemCat itemCat);

	List<Long> selectChildIdsById(@NonNull @Param("parent_id") Long itemCatId);

}

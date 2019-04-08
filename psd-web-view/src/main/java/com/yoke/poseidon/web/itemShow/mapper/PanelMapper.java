package com.yoke.poseidon.web.itemShow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.itemShow.cache.RedisCache;
import com.yoke.poseidon.web.itemShow.entity.Panel;
import org.apache.ibatis.annotations.CacheNamespace;
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
//@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface PanelMapper extends BaseMapper<Panel> {

	/**
	 * 根据标签查询对应的版块信息
	 * @param remark 标签名称
	 * @param limit 限制的条数
	 * @param sort 排序方式
	 * @return 查询得到的版块信息
	 */
	List<Panel> selectByRemark(@NonNull @Param("remark") String remark,
			@Param("sort") String sort, @Param("limit") Integer limit);

	/**
	 * 根据商品分类id查找版块信息
	 * @param itemCatId 商品分类的id
	 * @return 查询得到的版块信息
	 */
	List<Panel> selectByCatId(@NonNull @Param("item_cat_id") Long itemCatId);

	/**
	 * 根据版块的id查找对应的板块信息
	 */
	Panel selectById(@NonNull @Param("panelId") Integer panelId);

}

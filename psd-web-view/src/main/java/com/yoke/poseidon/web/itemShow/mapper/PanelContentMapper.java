package com.yoke.poseidon.web.itemShow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoke.poseidon.web.itemShow.cache.RedisCache;
import com.yoke.poseidon.web.itemShow.entity.PanelContent;
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
public interface PanelContentMapper extends BaseMapper<PanelContent> {

	/**
	 * 根据版块id查询版块的内容信息
	 * @param panelId 版块的id
	 * @param sort 按照什么排序排序
	 * @param limit 限制查询的条数
	 * @return 查询得到的版块内容
	 */
	List<PanelContent> selectByPanelId(@NonNull @Param("panelId") String panelId,
			@Param("sort") String sort, @Param("limit") Integer limit);

	/**
	 * 根据版块id查询商品的id
	 * @param panelId 版块的id
	 * @param itemLimit 限制查询的条数
	 * @return 查询得到的商品ids
	 */
	List<String> selectItemIdsByPanelId(@Param("panelId") Integer panelId,
			@Param("limit") Integer itemLimit);

}

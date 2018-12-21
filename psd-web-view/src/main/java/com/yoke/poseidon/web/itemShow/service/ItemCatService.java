package com.yoke.poseidon.web.itemShow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.entity.ItemCat;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
public interface ItemCatService extends IService<ItemCat> {

	/**
	 * 根据分类id查找子分类
	 * @param pId 父分类id
	 * @return 查询得到的子分类
	 */
	List<ItemCatDto> getByParentId(@NonNull Long pId, Integer limit);

	/**
	 * 根据父分类查找子分类的所有id
	 */
	List<Long> getIdsByParentId(@NonNull Long pId, Integer limit);

	/**
	 * 查询得到根分类
	 * @param limit 限制查询的条数
	 * @return 查询得到的数据
	 */
	List<List<ItemCatDto>> getRootCat(Integer limit);

	/**
	 * 根据remark类型得到分类
	 * @param remark remark的分类
	 * @param limit 限制分类查询的条数
	 * @return 查询得到的itemCat
	 */
	List<ItemCatDto> getByRemark(@NonNull String remark, Integer limit);

}

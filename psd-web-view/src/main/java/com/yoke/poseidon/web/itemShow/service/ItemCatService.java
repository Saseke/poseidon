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
	List<ItemCatDto> getByParentId(@NonNull Long pId, String sort, Integer limit);

	/**
	 * 根据父分类查找子分类的所有id
	 */
	List<Long> getIdsByParentId(@NonNull Long pId, String sort, Integer limit);

	/**
	 * 查询得到根分类
	 * @param sort 排序方式
	 * @param limit 限制查询的条数
	 * @return 查询得到的数据
	 */
	List<ItemCatDto> getRootCat(String sort, Integer limit);

	/**
	 * 根据remark类型得到分类
	 * @param remark 标记
	 * @param catSort 分类排序方式
	 * @param itemSort 商品分类方式
	 * @param catLimit 限制查询分类的条数
	 * @param itemLimit 限制查询每个分类商品的条数
	 * @param itemBlob 查询的商品是否包含大字段信息
	 * @return 查询得到的数据
	 */
	List<ItemCatDto> getByRemark(@NonNull String remark, String catSort, String itemSort,
			Integer catLimit, Integer itemLimit, @NonNull int itemBlob);

}

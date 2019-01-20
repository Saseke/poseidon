package com.yoke.poseidon.web.itemShow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.entity.Item;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
public interface ItemService extends IService<Item> {

	ItemDto getById(@NonNull String itemId, int intBlob);

	List<ItemDto> getIdIn(@NonNull List<String> itemIds, int intBlob);

	List<ItemDto> getByCId(@NonNull Long cId, @NonNull Integer limit, int intBlob);

	List<ItemDto> getByCIds(@NonNull List<Long> cIds, @NonNull Integer limit,
			int intBlob);

	List<ItemDto> getByCatIds(@NonNull List<Long> itemCatIds, @NonNull Integer limit);

	/**
	 * 得到所有的商品信息,目的是第一次elasticsearch同步
	 */
	List<ItemDto> get();

}

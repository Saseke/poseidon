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

	List<ItemDto> getIdIn(@NonNull List<String> itemIds, String sort, int intBlob);

	List<ItemDto> getByCId(@NonNull Long cId, Integer limit, String sort, int intBlob);

	List<ItemDto> getByCIds(@NonNull List<Long> cIds, Integer limit, String sort,
                            int intBlob);

}

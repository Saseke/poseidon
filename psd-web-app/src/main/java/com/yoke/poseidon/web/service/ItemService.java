package com.yoke.poseidon.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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

	List<ItemCatDto> getIndexCatWithItems();

	List<ItemCatDto> getRootCatsWithItems(Integer limit);

	List<List<ItemCatDto>> getRootCatsWithItemsParted(Integer limit);

}

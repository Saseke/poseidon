package com.yoke.poseidon.web.itemShow.service;

import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.dto.PanelDto;
import com.yoke.poseidon.web.itemShow.entity.Item;
import com.yoke.poseidon.web.itemShow.entity.ItemCat;
import com.yoke.poseidon.web.itemShow.entity.Panel;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/23 下午3:20
 */
public interface ConvertService {

	ItemDto convertItem(@NonNull Item item);

	List<ItemDto> convertItem(@NonNull List<Item> items);

	ItemCatDto convertItemCat(@NonNull ItemCat itemCat);

	List<ItemCatDto> convertItemCat(@NonNull List<ItemCat> itemCats);

	PanelDto convertPanel(@NonNull Panel panel);

	List<PanelDto> convertPanel(@NonNull List<Panel> panels);

}

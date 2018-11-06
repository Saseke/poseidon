package com.yoke.poseidon.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.entity.Item;

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

    List<ItemCatDto> getByCatId(Long catId, Integer limit);

    List<ItemCatDto> getByCatRemark(String remark, Integer limit);

    List<ItemCatDto> getIndexCatWithItems();

    List<ItemCatDto> getSiteRootCatWithItems(Integer limit);
    List<List<ItemCatDto>> getSiteRootCatWithItemsPart(Integer limit);

}

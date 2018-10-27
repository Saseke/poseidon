package com.yoke.poseidon.web.service;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.entity.ItemCat;
import com.baomidou.mybatisplus.extension.service.IService;

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
    List<ItemCat> listRootCat();

    List<ItemCat> getChildCat(Long catId);

    List<ItemCat> listCatBySortOrder(int limit);

}

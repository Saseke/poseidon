package com.yoke.poseidon.web.itemShow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.itemShow.entity.ItemAttribute;
import com.yoke.poseidon.web.itemShow.entity.ItemSku;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yoke
 * @since 2019-06-02
 */
public interface ItemSkuService extends IService<ItemSku> {

	/**
	 * 根据商品id获取用户各种参数信息
	 */
	List<ItemAttribute> getItemInfo(String itemId);

}

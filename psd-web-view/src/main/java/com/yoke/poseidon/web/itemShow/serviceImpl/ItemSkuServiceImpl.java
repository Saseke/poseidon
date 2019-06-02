package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yoke.poseidon.web.itemShow.entity.ItemAttribute;
import com.yoke.poseidon.web.itemShow.entity.ItemSku;
import com.yoke.poseidon.web.itemShow.mapper.ItemSkuMapper;
import com.yoke.poseidon.web.itemShow.service.ItemSkuService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2019-06-02
 */
@Service
public class ItemSkuServiceImpl extends ServiceImpl<ItemSkuMapper, ItemSku>
		implements ItemSkuService {

	@Override
	public List<ItemAttribute> getItemInfo(String itemId) {
		// ItemSku itemSku = itemSkuMapper.selectById(itemId);
		List<ItemSku> itemSkuList = list(
				new QueryWrapper<ItemSku>().eq("item_id", itemId));
		return itemSkuList.stream().map(itemSku -> {
			ItemAttribute itemAttribute = new ItemAttribute();
			String attributesStr = itemSku.getAttributes();
			List<String> attributesList = Lists.newArrayList(attributesStr.split(";"));
			List<Map<Long, Long>> list = attributesList.stream().map(attribute -> {
				Map<Long, Long> map = new HashMap<>();
				String[] properties = attribute.split(":");
				map.put(Long.valueOf(properties[0]), Long.valueOf(properties[1]));
				return map;
			}).collect(Collectors.toList());
			itemAttribute.setAttributes(list);
			itemAttribute.setPrice(itemSku.getPrice());
			return itemAttribute;
		}).collect(Collectors.toList());
	}

}

package com.yoke.poseidon.elasticsearch.fallback;

import com.yoke.poseidon.elasticsearch.entity.Item;
import com.yoke.poseidon.elasticsearch.feign.ItemFeign;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2019/01/28 下午8:32
 */
@Component
public class ItemFallback implements ItemFeign {

	@Override
	public List<Item> fetch() {
		return Collections.emptyList();
	}

}

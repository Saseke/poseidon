package com.yoke.poseidon.elasticsearch.feign;

import com.yoke.poseidon.elasticsearch.entity.EsItem;
import com.yoke.poseidon.elasticsearch.fallback.ItemFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2019/01/16 下午9:02
 */
@FeignClient(value = "web-view-service:8080", fallback = ItemFallback.class)
public interface ItemFeign {

	@GetMapping("/item")
	// 默认就是post,即使写的是get请求
	List<EsItem> fetch();

}

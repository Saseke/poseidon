package com.yoke.poseidon.shopcart.feign;

import com.yoke.poseidon.shopcart.dto.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/22 上午9:03
 */
@FeignClient(value = "web-view-service")
public interface ItemFeign {

	@RequestMapping(value = "/item/0", method = RequestMethod.POST)
	List<ItemDto> items(List<String> ids);

}

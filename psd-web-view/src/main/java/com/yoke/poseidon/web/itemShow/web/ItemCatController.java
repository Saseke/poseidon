package com.yoke.poseidon.web.itemShow.web;

import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.service.ItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/itemCat")
@Api(value = "itemCatController", description = "handle itemCat")

public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@ApiOperation(value = "get Root ItemCat", response = ItemCatDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制查询的条数"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "sort", value = "默认按照 :order by sort_order排序,这个字段一般不用写") })
	@GetMapping({ "/ro", "/ro/{limit}" })
	public Flux<List<ItemCatDto>> itemCatDto(
			@PathVariable(value = "limit", required = false) Integer limit) {
		return Flux.fromIterable(itemCatService.getRootCat(limit));
	}

}

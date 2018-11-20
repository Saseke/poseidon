package com.yoke.poseidon.web.controller;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.service.ItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@ApiOperation(value = "get Root ItemCat", response = List.class)
	@GetMapping("/root/{sort}/{limit}")
	public List<ItemCatDto> itemCatDto(@PathVariable("sort") String sort,
			@PathVariable("limit") Integer limit) {
		return itemCatService.getRootCat(sort, limit);
	}

	@ApiOperation(value = "get itemCatDto according to remark ")
	@GetMapping("/remark/{remark}/{catSort}/{itemSort}/{catLimit}/{itemLimit}/{itemBlob}")
	public List<ItemCatDto> itemCatDto(@PathVariable("remark") String remark,
			@PathVariable("catSort") String catSort,
			@PathVariable("itemSort") String itemSort,
			@PathVariable("catLimit") Integer catLimit,
			@PathVariable("itemLimit") Integer itemLimit,
			@PathVariable("itemBlob") Integer itemBlob) {
		return itemCatService.getByRemark(remark, catSort, itemSort, catLimit, itemLimit,
				itemBlob);
	}

}

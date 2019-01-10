package com.yoke.poseidon.web.itemShow.web;

import com.yoke.poseidon.web.itemShow.dto.ItemCatDto;
import com.yoke.poseidon.web.itemShow.dto.Message;
import com.yoke.poseidon.web.itemShow.service.ItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yoke.poseidon.web.itemShow.dto.Message.failed;
import static com.yoke.poseidon.web.itemShow.dto.Message.success;

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
@Api(value = "商品分类", description = "handle itemCat")

public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@ApiOperation(value = "get Root ItemCat", response = ItemCatDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制查询的条数"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "sort", value = "默认按照 :order by sort_order排序,这个字段一般不用写") })
	@GetMapping(path = { "/ro",
			"/ro/{limit}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message itemCatDto(
			@PathVariable(value = "limit", required = false) Integer limit) {
		try {
			List<List<ItemCatDto>> data = itemCatService.getRootCat(limit);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

}

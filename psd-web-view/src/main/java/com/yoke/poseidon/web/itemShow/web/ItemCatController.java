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
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制查询的条数"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "sort", value = "默认按照 :order by sort_order排序,这个字段一般不用写") })
	@GetMapping({ "/ro", "/ro/{limit}" })
	public List<ItemCatDto> itemCatDto(
			@PathVariable(value = "limit", required = false) Integer limit) {
		return itemCatService.getRootCat(limit);
	}

	@ApiOperation(value = "get itemCatDto according to remark ")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "remark", value = "查询的标签,目前有的标签有:index,nav"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemBlob", value = "查询商品信息是否带大字段信息,0:不带;1:带"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "catLimit", value = "分类查询限制的条数"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemLimit", value = "商品查询限制的条数")

	})

	@GetMapping({ "/re/{remark}/{itemBlob}", "/re/{remark}/{itemBlob}/{catLimit}",
			"re/{remark}/{itemBlob}/{catLimit}/{itemLimit}" })
	public List<ItemCatDto> itemCatDto(@PathVariable("remark") String remark,
			@PathVariable("itemBlob") Integer itemBlob,
			@PathVariable(value = "catLimit", required = false) Integer catLimit,
			@PathVariable(value = "itemLimit", required = false) Integer itemLimit) {
		return itemCatService.getByRemark(remark, catLimit, itemLimit, itemBlob);
	}

}

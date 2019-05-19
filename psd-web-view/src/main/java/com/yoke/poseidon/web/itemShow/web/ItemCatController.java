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
@Api(value = "商品分类")

public class ItemCatController {

	private final ItemCatService itemCatService;

	@Autowired
	public ItemCatController(ItemCatService itemCatService) {
		this.itemCatService = itemCatService;
	}

	@ApiOperation(value = "得到首页左侧展示的根商品分类和相关的商品信息", response = ItemCatDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Integer",
					name = "catLimit", value = "商品分类的数量,推荐是20"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer",
					name = "itemLimit", value = "商品的数量,推荐是12") })

	@GetMapping(path = "/ro/{catLimit}/{itemLimit}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message rootCatWithItems(@PathVariable Integer catLimit,
			@PathVariable Integer itemLimit) {

		try {
			List<List<ItemCatDto>> data = itemCatService.getRootCat(catLimit, itemLimit);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

	@ApiOperation(value = "得到导航栏的展示信息", response = ItemCatDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Integer",
					name = "catLimit", value = "商品分类的数量,推荐是10"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer",
					name = "itemLimit", value = "商品的数量,推荐是5") })
	@GetMapping(path = "/nav/{catLimit}/{itemLimit}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message navCatWithItems(@PathVariable Integer catLimit,
			@PathVariable Integer itemLimit) {
		return Message
				.success(itemCatService.getItemCatWithItems("nav", catLimit, itemLimit));
	}

}

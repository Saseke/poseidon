package com.yoke.poseidon.web.itemShow.web;

import com.google.common.collect.Lists;
import com.yoke.poseidon.web.itemShow.dto.Message;
import com.yoke.poseidon.web.itemShow.dto.PanelDto;
import com.yoke.poseidon.web.itemShow.service.PanelService;
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
@RequestMapping("/panel")
@Api(value = "panelController", description = "handle panel")
public class PanelController {

	private final PanelService panelService;

	@Autowired
	public PanelController(PanelService panelService) {
		this.panelService = panelService;
	}

	@ApiOperation(value = "得到版块信息和对应版块的商品的信息", response = PanelDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "remark", value = "版块remark,目前有index版块"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "panelLimit", value = "版块的查询限制条数"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemLimit", value = "商品的查询限制条数"), })

	@GetMapping(path = { "/re/{remark}", "/re/{remark}/{panelLimit}",
			"/re/{remark}/{panelLimit}/{itemLimit}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message panel(@PathVariable("remark") String remark,
			@PathVariable(value = "panelLimit", required = false) Integer panelLimit,
			@PathVariable(value = "itemLimit", required = false) Integer itemLimit) {
		try {
			List<PanelDto> data = panelService.getPanelByRemark(remark, panelLimit,
					itemLimit);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

	@ApiOperation(value = "点击商品分类,查看商品分类下的版块(包含商品)", response = PanelDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "cId", value = "商品分类id"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制显示的商品数量")

	})
	@GetMapping(path = { "/cat/{cId}",
			"/cat/{cId}/{limit}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message panelWithItems(@PathVariable("cId") Long itemCatId,
			@PathVariable(value = "limit", required = false) Integer limit) {
		try {
			List<PanelDto> data = panelService.getPanelWithItemsByItemCatId(itemCatId,
					limit);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

	@ApiOperation(value = "获取指定分类下面的模块信息,可以指定两个分类的id", response = PanelDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "cId1", value = "第一个分类的id"),
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "cId2", value = "第二个分类的id"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemLimit", value = "每一个版块下商品的数量"), })

	@GetMapping(path = "/cat/{cId1}/{cId2}/{itemLimit}")
	public Message panelWithCatsAndItems(@PathVariable Integer itemLimit,
			@PathVariable Long cId1, @PathVariable Long cId2) {
		List<Long> catIds = Lists.newArrayList(cId1, cId2);
		return Message
				.success(panelService.getPanelWithItemsByItemCatId(catIds, itemLimit));
	}

	@ApiOperation(value = "根据版块的id查找对应的版块信息，包含对应的商品信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "panelId", value = "版块的id") })
	@GetMapping(path = "/{panelId}")
	public Message panel(@PathVariable Integer panelId) {
		PanelDto panelDto = panelService.getPanelById(panelId);
		return Message.success(panelDto);
	}

}

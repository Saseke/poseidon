package com.yoke.poseidon.web.itemShow.web;

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

	@Autowired
	private PanelService panelService;

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
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "itemCatId", value = "商品分类id"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制显示的商品数量")

	})
	@GetMapping(path = { "/pi/{itemCatId}",
			"/pi/{itemCatId}/{limit}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Message panelWithItems(@PathVariable("itemCatId") Long itemCatId,
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

}

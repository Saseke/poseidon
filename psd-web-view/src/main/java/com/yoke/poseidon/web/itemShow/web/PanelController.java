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
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

	@ApiOperation(value = "获取指定分类下面的模块信息,可以指定两个分类的id", response = PanelDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemLimit", value = "每一个版块下商品的数量"),
			@ApiImplicitParam(paramType = "query", dataType = "Long[]", name = "catId", value = "分类的id集合,集合是特殊的集合，是矩阵变量") })

	@GetMapping(path = "/pi/{itemLimit}")
	public Message panelWithCatsAndItems(@PathVariable Integer itemLimit,
			@MatrixVariable MultiValueMap<String, Long> matrixVars) {
		List<Long> catIds = matrixVars.get("catId");
		return Message
				.success(panelService.getPanelWithItemsByItemCatId(catIds, itemLimit));
	}

}

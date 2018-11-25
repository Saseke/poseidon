package com.yoke.poseidon.web.itemShow.web;

import com.yoke.poseidon.web.itemShow.dto.PanelDto;
import com.yoke.poseidon.web.itemShow.service.PanelService;
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
@RequestMapping("/panel")
@Api(value = "panelController", description = "handle panel")
public class PanelController {

	@Autowired
	private PanelService panelService;

	@ApiOperation(value = "get panelDto ", response = List.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "remark", value = "版块remark,目前有index版块"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "panelSort", value = "版块的排序"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "panelLimit", value = "版块的查询限制条数"),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "itemSort", value = "商品的排序"),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemLimit", value = "商品的查询限制条数"),

	})
	@GetMapping({ "/re/{remark}", "/re/{remark}/{panelLimit}",
			"/re/{remark}/{panelSort}/{panelLimit}",
			"/re/{remark}/{panelSort}/{panelLimit}/{itemSort}/{itemLimit}", })
	public List<PanelDto> panel(@PathVariable("remark") String remark,
                                @PathVariable(value = "panelSort", required = false) String panelSort,
                                @PathVariable(value = "panelLimit", required = false) Integer panelLimit,
                                @PathVariable(value = "itemSort", required = false) String itemSort,
                                @PathVariable(value = "itemLimit", required = false) Integer itemLimit) {

		return panelService.getPanelByRemark(remark, panelSort, panelLimit, itemSort,
				itemLimit);
	}

}

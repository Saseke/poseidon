package com.yoke.poseidon.web.itemShow.web;

import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.dto.Message;
import com.yoke.poseidon.web.itemShow.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

import static com.yoke.poseidon.web.itemShow.dto.Message.failed;
import static com.yoke.poseidon.web.itemShow.dto.Message.success;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/item")
@Api(value = "itemController", description = "handle item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "get item by id", response = ItemDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "id", value = "商品id", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob", value = "0代表不包含大字段信息,1表示包含大字段信息", required = true) })

	@GetMapping("/{id}/{blob}")
	public Message item(@PathVariable("id") String id, @PathVariable("blob") int blob) {
		try {
			ItemDto data = itemService.getById(id, blob);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

	@ApiOperation(value = "根据商品的ids查询商品信息返回", notes = "这个用于服务之间调用", response = ItemDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "blob", value = "是否包含大字段信息", required = true) })
	@ApiImplicitParam(paramType = "post body", dataType = "List<String>", name = "ids", value = "商品的ids", required = true)
	@PostMapping("/{blob}")
	public List<ItemDto> items(@PathVariable("blob") int blob,
			@NonNull @RequestBody List<String> ids) {
		return itemService.getIdIn(ids, blob);

	}

	@ApiOperation(value = "get list of items by cId", response = Flux.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "cId", value = "商品分类的id", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob", value = "0代表不包含大字段信息,1表示包含大字段信息", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制查询的条数") })
	@GetMapping({ "/c/{cId}/{blob}", "/c/{cId}/{blob}/{limit}" })
	public Message items(@PathVariable("cId") Long cId, @PathVariable("blob") int blob,
			@PathVariable(value = "limit", required = false) Integer limit) {
		try {
			List<ItemDto> data = itemService.getByCId(cId, limit, blob);
			return success(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return failed();
	}

}

package com.yoke.poseidon.web.itemShow.web;

import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.dto.Message;
import com.yoke.poseidon.web.itemShow.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@Api(value = "itemController")
public class ItemController {

	private final ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@ApiOperation(value = "get item by id", response = ItemDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "id",
					value = "商品id", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob",
					value = "0代表不包含大字段信息,1表示包含大字段信息", required = true) })

	@GetMapping(path = "/{id}/{blob}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

	@ApiOperation(value = "根据商品的ids查询商品信息返回", notes = "这个用于服务之间调用",
			response = ItemDto.class)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String",
			name = "blob", value = "是否包含大字段信息", required = true) })
	@ApiImplicitParam(paramType = "post body", dataType = "List<String>", name = "ids",
			value = "商品的ids", required = true)
	@PostMapping(path = "/{blob}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemDto> items(@PathVariable("blob") int blob,
			@NonNull @RequestBody List<String> ids) {
		return itemService.getIdIn(ids, blob);

	}

	@ApiOperation(value = "get list of items by cId", response = Flux.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "cId",
					value = "商品分类的id", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "int", name = "blob",
					value = "0代表不包含大字段信息,1表示包含大字段信息", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit",
					value = "限制查询的条数") })
	@GetMapping(path = { "/c/{cId}/{blob}", "/c/{cId}/{blob}/{limit}" },
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

	// 与es进行同步数据使用
	@GetMapping(path = "")
	public List<ItemDto> items() {
		return itemService.get();
	}

	@GetMapping("/test")
	public void message() {
		itemService.test();
	}

}

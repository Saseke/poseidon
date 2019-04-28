package com.yoke.poseidon.member.web;

import com.yoke.poseidon.member.dto.Message;
import com.yoke.poseidon.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yoke
 * @since 2019-01-24
 */
@RestController
@RequestMapping("/member")
@Api(value = "用户操作")
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping(path = "/{name}")
	@ApiOperation(value = "根据用户名查询用户的基本信息")
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "name",
			value = "用户的当前名称")
	Message get(@PathVariable String name) {
		return Message.success(memberService.getByName(name));
	}

	@PatchMapping("/pay/{memberId}/{payment}")
	@ApiOperation(value = "扣除指定用户相关金额")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "Long", name = "memberId"),
			@ApiImplicitParam(paramType = "update", dataType = "BigDecimal",
					name = "payment") })
	Message pay(@PathVariable Long memberId, @PathVariable BigDecimal payment) {
		if (memberService.pay(memberId, payment)) {
			return Message.success(memberService.getById(memberId));
		}
		else {
			return Message.failed("您的钱不足");
		}
	}

	@GetMapping("/memberId")
	@ApiOperation("根据用户id获取用户信息")
	Message getById(@NotNull @PathVariable Long memberId) {
		return Message.success(memberService.getById(memberId));
	}

}

package com.yoke.poseidon.member.web;

import com.yoke.poseidon.member.dto.Message;
import com.yoke.poseidon.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(value = "用户操作", description = "member operation")
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping(path = "/{name}")
	@ApiOperation(value = "根据用户名查询用户的基本信息")
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "用户的当前名称")
	Message get(@PathVariable String name) {
		return Message.success(memberService.getByName(name));
	}
}

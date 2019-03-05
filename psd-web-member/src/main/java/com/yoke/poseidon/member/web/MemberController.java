package com.yoke.poseidon.member.web;

import com.yoke.poseidon.member.dto.Message;
import com.yoke.poseidon.member.service.MemberService;
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
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/{name}")
	Message get(@PathVariable String name) {
		return Message.success(memberService.getByName(name));
	}

}

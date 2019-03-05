package com.yoke.poseidon.member.service;

import com.yoke.poseidon.member.dto.MemberDto;
import com.yoke.poseidon.member.entity.Member;

/**
 * @Author Yoke
 * @Date 2019/01/24 下午2:16
 */
public interface ConvertService {

	MemberDto convert(Member member);

}

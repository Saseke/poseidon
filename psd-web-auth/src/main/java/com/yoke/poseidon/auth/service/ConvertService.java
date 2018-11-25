package com.yoke.poseidon.auth.service;

import com.yoke.poseidon.auth.dto.MemberDto;
import com.yoke.poseidon.auth.entity.Member;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/23 下午3:20
 */
public interface ConvertService {

	MemberDto convertMember(@NonNull Member member);

	List<MemberDto> convertMember(@NonNull List<Member> members);

}

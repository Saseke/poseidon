package com.yoke.poseidon.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.member.dto.MemberDto;
import com.yoke.poseidon.member.entity.Member;
import org.springframework.lang.NonNull;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yoke
 * @since 2019-01-24
 */
public interface MemberService extends IService<Member> {

	MemberDto getByName(@NonNull String name);

}

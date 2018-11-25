package com.yoke.poseidon.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.auth.dto.MemberDto;
import com.yoke.poseidon.auth.entity.Member;
import org.springframework.lang.NonNull;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yoke
 * @since 2018-11-25
 */
public interface MemberService extends IService<Member> {

	MemberDto getByUsername(@NonNull String username);

}

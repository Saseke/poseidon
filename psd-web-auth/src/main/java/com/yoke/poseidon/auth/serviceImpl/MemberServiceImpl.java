package com.yoke.poseidon.auth.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.auth.dto.MemberDto;
import com.yoke.poseidon.auth.entity.Member;
import com.yoke.poseidon.auth.mapper.MemberMapper;
import com.yoke.poseidon.auth.service.ConvertService;
import com.yoke.poseidon.auth.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2018-11-25
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
		implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private ConvertService convertService;

	@Override
	public MemberDto getByUsername(@NonNull String username) {
		Member member = memberMapper.selectByUsername(username);
		return convertService.convertMember(member);
	}

}

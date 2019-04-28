package com.yoke.poseidon.member.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.member.dto.MemberDto;
import com.yoke.poseidon.member.entity.Member;
import com.yoke.poseidon.member.mapper.MemberMapper;
import com.yoke.poseidon.member.service.ConvertService;
import com.yoke.poseidon.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yoke
 * @since 2019-01-24
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
		implements MemberService {

	private final ConvertService convertService;

	private final MemberMapper memberMapper;

	@Autowired
	public MemberServiceImpl(ConvertService convertService, MemberMapper memberMapper) {
		this.convertService = convertService;
		this.memberMapper = memberMapper;
	}

	@Override
	public MemberDto getByName(@NonNull String name) {
		Member member = memberMapper.selectByName(name);
		return convertService.convert(member);
	}

	@Override
	public boolean pay(@NotNull Long memberId, @NotNull BigDecimal payment) {
		Member member = memberMapper.selectById(memberId);
		BigDecimal balance = member.getBalance();
		if (member.getBalance().compareTo(payment) > 0) {
			member.setBalance(balance.subtract(payment));
			memberMapper.updateById(member);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public MemberDto getById(@NotNull Long memberId) {
		Member member = memberMapper.selectById(memberId);
		return convertService.convert(member);
	}

}

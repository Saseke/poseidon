package com.yoke.poseidon.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.member.dto.MemberDto;
import com.yoke.poseidon.member.entity.Member;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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

	/**
	 * 支付,扣除用户指定的金额
	 * @param memberId 用户的id
	 * @param pay 扣除的金额
	 * @return 扣除金额是否成功
	 */

	boolean pay(@NotNull Long memberId, @NotNull BigDecimal payment);

	/**
	 * 根据用户的id获取用户的个人信息
	 * @param memberId 用户的id
	 * @return 用户的个人信息
	 */
	MemberDto getById(@NotNull Long memberId);
}

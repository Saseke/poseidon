package com.yoke.poseidon.member.mapper;

import com.yoke.poseidon.member.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.NonNull;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yoke
 * @since 2019-01-24
 */
public interface MemberMapper extends BaseMapper<Member> {

    Member selectByName(@NonNull @Param("username") String username);

}

package com.yoke.poseidon.serviceImpl;

import com.yoke.poseidon.entity.Member;
import com.yoke.poseidon.mapper.MemberMapper;
import com.yoke.poseidon.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}

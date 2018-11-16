package com.yoke.poseidon.web.serviceImpl;

import com.yoke.poseidon.web.entity.Member;
import com.yoke.poseidon.web.mapper.MemberMapper;
import com.yoke.poseidon.web.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
		implements MemberService {

}

package com.yoke.poseidon.serviceImpl;

import com.yoke.poseidon.entity.User;
import com.yoke.poseidon.mapper.UserMapper;
import com.yoke.poseidon.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

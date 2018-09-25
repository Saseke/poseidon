package com.yoke.poseidon.manager.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.manager.entity.User;
import com.yoke.poseidon.manager.mapper.UserMapper;
import com.yoke.poseidon.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String hello() {
        return restTemplate.getForObject("http://WEB-APP/item/hello", String.class);
    }
}

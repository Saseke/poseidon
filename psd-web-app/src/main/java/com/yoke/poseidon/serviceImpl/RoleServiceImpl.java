package com.yoke.poseidon.serviceImpl;

import com.yoke.poseidon.entity.Role;
import com.yoke.poseidon.mapper.RoleMapper;
import com.yoke.poseidon.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

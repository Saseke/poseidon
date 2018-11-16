package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.entity.Role;
import com.yoke.poseidon.web.mapper.RoleMapper;
import com.yoke.poseidon.web.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
		implements RoleService {

}

package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.entity.RolePerm;
import com.yoke.poseidon.web.mapper.RolePermMapper;
import com.yoke.poseidon.web.service.RolePermService;
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
public class RolePermServiceImpl extends ServiceImpl<RolePermMapper, RolePerm>
		implements RolePermService {

}

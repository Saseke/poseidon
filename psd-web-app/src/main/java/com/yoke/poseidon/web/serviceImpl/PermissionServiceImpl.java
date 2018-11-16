package com.yoke.poseidon.web.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.entity.Permission;
import com.yoke.poseidon.web.mapper.PermissionMapper;
import com.yoke.poseidon.web.service.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
		implements PermissionService {

}

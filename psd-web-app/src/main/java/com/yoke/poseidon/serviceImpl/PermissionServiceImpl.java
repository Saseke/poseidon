package com.yoke.poseidon.serviceImpl;

import com.yoke.poseidon.entity.Permission;
import com.yoke.poseidon.mapper.PermissionMapper;
import com.yoke.poseidon.service.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}

package com.yoke.poseidon.manager.serviceImpl;

import com.yoke.poseidon.manager.entity.Log;
import com.yoke.poseidon.manager.mapper.LogMapper;
import com.yoke.poseidon.manager.service.LogService;
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
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}

package com.yoke.poseidon.serviceImpl;

import com.yoke.poseidon.entity.Log;
import com.yoke.poseidon.mapper.LogMapper;
import com.yoke.poseidon.service.LogService;
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

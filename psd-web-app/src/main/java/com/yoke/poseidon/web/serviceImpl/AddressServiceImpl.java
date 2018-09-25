package com.yoke.poseidon.web.serviceImpl;

import com.yoke.poseidon.web.entity.Address;
import com.yoke.poseidon.web.mapper.AddressMapper;
import com.yoke.poseidon.web.service.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}

package com.yoke.poseidon.order.serviceImpl;

import com.yoke.poseidon.order.entity.Address;
import com.yoke.poseidon.order.mapper.AddressMapper;
import com.yoke.poseidon.order.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yoke
 * @since 2019-03-31
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}

package com.yoke.poseidon.member.serviceImpl;

import com.yoke.poseidon.member.dto.MemberDto;
import com.yoke.poseidon.member.entity.Member;
import com.yoke.poseidon.member.service.ConvertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Yoke
 * @Date 2019/01/24 下午2:16
 */
@Service
public class ConvertServiceImpl implements ConvertService {

	private final ModelMapper modelMapper;

	@Autowired
	public ConvertServiceImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public MemberDto convert(Member member) {
		return modelMapper.map(member, MemberDto.class);
	}

}

package com.yoke.poseidon.auth.serviceImpl;

import com.yoke.poseidon.auth.dto.MemberDto;
import com.yoke.poseidon.auth.entity.Member;
import com.yoke.poseidon.auth.service.ConvertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Yoke
 * @Date 2018/11/25 下午2:21
 */
@Service
public class ConvertServiceImpl implements ConvertService {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MemberDto convertMember(@NonNull Member member) {
		return modelMapper.map(member, MemberDto.class);
	}

	@Override
	public List<MemberDto> convertMember(@NonNull List<Member> members) {
		return members.stream().map(member -> modelMapper.map(member, MemberDto.class))
				.collect(Collectors.toList());
	}

}

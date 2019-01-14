package com.yoke.poseidon.auth.serviceImpl;

import com.yoke.poseidon.auth.entity.Member;
import com.yoke.poseidon.auth.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author Yoke
 * @Date 2018/11/25 下午5:18
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Member member = memberMapper.selectByUsername(username);
		if (member == null) {
			throw new UsernameNotFoundException("user not found");
		}
		PasswordEncoder encoder = PasswordEncoderFactories
				.createDelegatingPasswordEncoder();
		String password = encoder.encode(member.getPassword());
		return User.withUsername(username).password(password).roles("").build();
	}

}

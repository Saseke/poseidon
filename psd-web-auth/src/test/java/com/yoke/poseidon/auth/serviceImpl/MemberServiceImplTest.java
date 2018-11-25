package com.yoke.poseidon.auth.serviceImpl;

import com.yoke.poseidon.auth.service.MemberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Yoke
 * @Date 2018/11/25 下午2:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceImplTest {

	@Autowired
	private MemberService memberService;

	@Test
	public void getByUsername() {
		Assert.assertNotNull(memberService.getByUsername("yoke"));
	}

}
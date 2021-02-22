package com.tesfai.familyapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.SelectPackages;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tesfai.familyapp.exception.MemberAlreadyExistsException;
import com.tesfai.familyapp.model.Member;
import com.tesfai.familyapp.repository.MemberRepository;
import com.tesfai.familyapp.service.MemberService;

@SelectPackages("com.tesfai.familyapp")
@ExtendWith(value = {SpringExtension.class,MockitoExtension.class})  // included in @WebFluxTest
//@WebFluxTest(controllers = MemberService.class)
@ExtendWith(MockitoExtension.class)
//@Import(MemberConfiguration.class)

public class MemberServiceTest {
	@Autowired
	private MemberService memberService;

	@MockBean
	private MemberRepository memberRepository;

	@Test
	public void testGetAllMembers() {
		when(memberRepository.findAll()).thenReturn(Collections.emptyList());

		// assertThat(memberService.getAllMembers()).isEmpty();
		assertEquals(0, memberService.getAllMembers().size());
	}

	@Test
	public void testGetMember() {
		Integer id = 1;

		when(memberRepository.findById(id)).thenReturn(Optional.of(new Member()));

		assertEquals(new Member(), memberService.getMember(id));
	}

	@Test
	public void testAddMember() throws MemberAlreadyExistsException {
		Member p = new Member();
		p.setFirstName("Aman");

		when(memberRepository.save(p)).thenReturn(p);

		assertEquals(p, memberService.addMember(p));
	}
}

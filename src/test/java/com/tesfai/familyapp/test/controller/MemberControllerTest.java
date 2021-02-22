package com.tesfai.familyapp.test.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tesfai.familyapp.controller.MemberController;
import com.tesfai.familyapp.service.MemberService;



//@RunWith(SpringRunner.class) //Junit 4
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class) //disable full auto-configuration and instead apply only configuration relevant to MVC tests
//@AutoConfigureMockMvc  //enables and autoconfigure MockMvc
class MemberControllerTest {
	Logger logger = Logger.getLogger(MemberControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MemberService memberService;
	
	@Test
	public void testGetAllMembers() throws Exception {
		when(memberService.getAllMembers())
				.thenReturn(Collections.emptyList());
		
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/api/v1/members/get")
				.accept(MediaType.APPLICATION_JSON)
			).andReturn();

		
		logger.info(mvcResult.getResponse().getContentAsString());
		
//		Throwable thrown = catchThrowable(this::testGetAllMembers);
//		assertThat(thrown)
//			.hasRootCauseInstanceOf(Exception.class)
//			.hasMessage("Exception thrown");
		
		verify(memberService).getAllMembers();
	}

}

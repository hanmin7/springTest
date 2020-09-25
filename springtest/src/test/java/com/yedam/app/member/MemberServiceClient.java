package com.yedam.app.member;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(location = "classpath:applicationContext.xml")
@ContextConfiguration(locations = {"classpath:applicationContext.xml", 
									"classpath:config/datasource-context.xml"})


public class MemberServiceClient {
	
	@Autowired MemberService service;
	
	@Test
	//@Ignore
	public void selectTest() {
		MemberVo memberVo = MemberVo.builder().id("ccc").build();
		memberVo = service.selectOne(memberVo); 
		assertEquals("1111", memberVo.getPw());    
	}
	
}

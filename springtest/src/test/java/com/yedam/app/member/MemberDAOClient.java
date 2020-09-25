package com.yedam.app.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.member.mapper.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(location = "classpath:applicationContext.xml")
@ContextConfiguration(locations = {"classpath:applicationContext.xml", 
									"classpath:config/datasource-context.xml"})
public class MemberDAOClient {

		//@Autowired MemberDAO dao;
		@Autowired MemberDAO memberDAO;
		
		@Test
		@Ignore
		public void selectTest() {
			MemberVo memberVo = MemberVo.builder().id("ccc").build();
			memberVo = memberDAO.selectOne(memberVo); //<-joinpoint   /  aop:aspect 2개만든거가 공통로직.
			assertEquals("1111", memberVo.getPw());    
		}
		
		@Test
		//@Ignore //테스트 제외
		public void insertTest() {
			MemberVo memberVo = MemberVo.builder()
								.id("ccdd")
								.pw("222")
								.hobby("ski")
								.reason("rrrspringtemp").build();
			memberDAO.insert(memberVo);
			//memberVo = dao.selectOne(memberVo);
			//assertNotNull(memberVo);
		}
		
		@Test
		@Ignore
		public void delete() {
			MemberVo memberVo = MemberVo.builder().id("hhhh").build();
			memberDAO.delete(memberVo);
		}
		
		@Test
		@Ignore
		public void selectOne() {
			MemberVo memberVo = MemberVo.builder().id("ccc").build();
			memberDAO.selectOne(memberVo);
		}
		
		@Test
		@Ignore
		public void selectAll() {
			memberDAO.selectAll(null);
		}
		
		
		
}

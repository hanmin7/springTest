package com.yedam.app.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yedam.app.member.MemberVo;

public interface MemberDAO {

	//전체조회
	List<MemberVo> selectAll(); //selectAll

	//단건조회
	MemberVo selectOne(MemberVo memberVo); //selectOne

	int delete(MemberVo memberVo); //삭제
	
	int update(MemberVo memberVo); //업뎃
	
	int insert(MemberVo memberVo); //인서트
	
	
	//메일수신회원수 : select count(id) from member where mailyn=''
	int getMailynCnt();

	//성별인원수 : select gender, count(id) cnt from member group by gender
	//조인이나 이런거.. map이 편함.
	List<HashMap<String, Object>> getGenderCnt();

	//직업별회원수 : select job, count(id) cnt from member group by job
	List<HashMap<String, Object>> getJobCnt();


}
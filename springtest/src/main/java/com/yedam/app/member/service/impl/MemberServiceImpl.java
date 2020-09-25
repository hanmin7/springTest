package com.yedam.app.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.member.MemberVo;
import com.yedam.app.member.mapper.MemberDAO;
import com.yedam.app.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberDAO memberDAO;
	
	
	@Override
	public List<MemberVo> selectAll() {
		return memberDAO.selectAll();
	}

	@Override
	public MemberVo selectOne(MemberVo memberVo) {
		return memberDAO.selectOne(memberVo);
	}

	
	@Override
	public int delete(MemberVo memberVo) {
		return memberDAO.delete(memberVo);
	}

	@Override
	public int update(MemberVo memberVo) {
		return memberDAO.update(memberVo);
	}

	@Override
	public int insert(MemberVo memberVo) {
		return memberDAO.insert(memberVo);
	}
	
	
	
	@Override
	public int getMailynCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap<String, Object>> getJobCnt() {
		// TODO Auto-generated method stub
		return null;
	}


}

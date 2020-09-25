package com.yedam.app.member.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.member.MemberVo;

//@Repository // MemberSpringDAO component 지우고 마이바티스로 해볼꺼임
public class MemberMybatisDAO implements MemberDAO{
	
	@Autowired SqlSessionTemplate sqlsession;

	@Override
	public List<MemberVo> selectAll() {
		System.out.println("mybatis selectAll");
		return sqlsession.selectList("memberDAO.selectAll");
									//member_mapper.xml파일에서 mapper이름.셀렉트이름
	}

	@Override
	public MemberVo selectOne(MemberVo memberVo) {
		System.out.println("mybatis selectOne");
		return sqlsession.selectOne("memberDAO.selectOne", memberVo);

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

	@Override
	public int delete(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//전체조회
	
	
	
}

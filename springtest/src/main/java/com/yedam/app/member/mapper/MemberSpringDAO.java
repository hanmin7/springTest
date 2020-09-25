package com.yedam.app.member.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yedam.app.member.MemberVo;

//@Component
public class MemberSpringDAO implements MemberDAO{

	@Autowired JdbcTemplate template;
	
	final static String INSERT_MEMBER = "insert into member(id, pw, job, reason, gender, mailyn, hobby, regdate)"
		 								+ "values (?,?,?,?,?,?,?, sysdate)";
	
	final static String DELETE_MEMBER = "DELETE MEMBER WHERE ID=?";
	
	final static String SELECT_MEMBER = "SELECT ID, PW, GENDER, JOB, REASON, MAILYN, HOBBY, REGDATE"
										+ " FROM MEMBER "
										+ "WHERE ID=?"; 
	final static String SELECT_ALL_MEMBER = "SELECT ID, PW, GENDER, JOB, REASON, MAILYN, HOBBY, REGDATE"
											+ " FROM MEMBER "
											+ " ORDER BY ID";
	
	
	@Override
	public ArrayList<MemberVo> selectAll() {
		return (ArrayList<com.yedam.app.member.MemberVo>) template.query(SELECT_ALL_MEMBER, new MemberRowMapper());
	}

	@Override
	public MemberVo selectOne(MemberVo memberVo) {
		Object[] args = {memberVo.getId()};
		return template.queryForObject(SELECT_MEMBER, args, new MemberRowMapper());
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
		return template.update(DELETE_MEMBER, memberVo.getId());
	}

	@Override
	public int update(MemberVo memberVo) {
		return 0;
	}

	@Override
	public int insert(MemberVo memberVo) {
		Object[] args = {memberVo.getId(), memberVo.getPw(), memberVo.getJob(), memberVo.getReason(), memberVo.getGender(), memberVo.getMailyn(), memberVo.getHobby()};
		//template.update(INSERT_MEMBER, args);
		return template.update(INSERT_MEMBER, args);
	}
		
	
	class MemberRowMapper implements RowMapper<MemberVo> {
		@Override
		public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			//MemberVo resultVo = MemberVo.builder().build();
			MemberVo resultVo = new MemberVo();
			//resultVo = MemberVo.builder().build();
			resultVo.setId((rs.getString("id")));
			resultVo.setPw(rs.getString("pw"));
			resultVo.setGender(rs.getString("gender"));
			resultVo.setJob(rs.getString("job"));
			resultVo.setReason(rs.getString("reason"));
			resultVo.setMailyn(rs.getString("mailyn"));
			resultVo.setHobby(rs.getString("hobby"));
			resultVo.setRegdate(rs.getString("regdate"));
			return resultVo;
		}
	}
	
	
}

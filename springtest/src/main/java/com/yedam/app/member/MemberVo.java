package com.yedam.app.member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
//@NoArgsConstructor
public class MemberVo {
	private String id;
	private String pw;
	private String gender;
	private String job;
	private String reason;
	private String mailyn;
	private String hobby;
	private String regdate;
	
	
	
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", gender=" + gender + ", job=" + job + ", reason=" + reason
				+ ", mailyn=" + mailyn + ", hobby=" + hobby + ", regdate=" + regdate + "]" + "\n";
	}
	
	
	
}

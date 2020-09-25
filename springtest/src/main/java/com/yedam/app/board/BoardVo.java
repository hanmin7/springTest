package com.yedam.app.board;

import java.util.List;

import com.yedam.app.member.MemberVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
	private Integer boardNo;
	private String poster;
	private String subject;
	private String contents;
	private String lastpost;
	private String views;
	private String filename;
	private String sortCol; //정렬순서
	private List<String> nos; //board_mapper.xml에서 delete
	
	private int first; //페이징 
	private int last;  //페이징

	
	
}

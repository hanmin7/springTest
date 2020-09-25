package com.yedam.app.board;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/*-context.xml"})

public class BoardDAOClient {
	
	@Autowired BoardDAO boardDAO;
	
	@Test
	//@Ignore
	// 기존 셀렉트에서 페이징처리 더한거
	public void selectAllTest() {
		//BoardVo vo = BoardVo.builder().sortCol("no,poster").build();
		BoardVo vo = BoardVo.builder()
							.first(1)
							.last(3)
							.build();
		List<BoardVo> list = boardDAO.selectAll(vo);
		for(BoardVo board : list) {
			System.out.println(board.getBoardNo() + " : " + 
								board.getPoster() + " : " +
								board.getSubject() + " : " +
								board.getLastpost());
		}
	}
	/*
	 * public void selectAllTest() { //BoardVo vo =
	 * BoardVo.builder().sortCol("no,poster").build(); BoardVo vo =
	 * BoardVo.builder() //.poster("posttt")
	 * //.subject("mybatis select key test logerr") .build(); List<BoardVo> list =
	 * boardDAO.selectAll(vo); for(BoardVo board : list) {
	 * System.out.println(board.getBoardNo() + " : " + board.getPoster() + " : " +
	 * board.getSubject() + " : " + board.getLastpost());
	 * 
	 * } }
	 */
	
	
	
	//@Test
	public void selectMapTest() {
		System.out.println(boardDAO.selectMap());
	}
	
	
	//@Test
	public void cntTest() {
		System.out.println(boardDAO.selectCnt());
	}
	
	
	
	
	//@Test
	public void deleteAllTest() {
		List<String> list = Arrays.asList(new String[] {"1","3","7"});
		BoardVo vo = BoardVo.builder()
				.nos(list)
				.build();
		boardDAO.deleteAll(vo);
	}
	
	
	
	//@Test
	public void insertTest() {
		BoardVo vo = BoardVo.builder()
							.subject("mybatis select key test logerr")
							.contents("test2 logger test")
							.poster("posttt2")
							.filename("fileeee2")
							.build();
		boardDAO.insert(vo);
		System.out.println("글번호: " + vo.getNo());
	}
}

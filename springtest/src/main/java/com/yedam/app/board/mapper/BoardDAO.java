package com.yedam.app.board.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.board.BoardVo;

public interface BoardDAO {
	public List<BoardVo> selectAll(BoardVo boardVo);
	
	public void insert(BoardVo boardVo);

	public void deleteAll(BoardVo boardVo);
	
	public List<Map<String, Object>> selectMap();
	
	public int selectCnt();

}

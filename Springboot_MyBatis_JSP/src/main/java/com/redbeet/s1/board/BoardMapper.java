package com.redbeet.s1.board;

import java.util.List;

import com.redbeet.s1.util.Pager;

public interface BoardMapper {
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public Long getTotalCount(Pager pager) throws Exception;
	
	public BoardVO getSelect(BoardVO boardVO) throws Exception;
	
	public int setInsert(BoardVO boardVO) throws Exception;
	
	public int setFileInsert(BoardFileVO boardFileVO) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setHitUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;

}

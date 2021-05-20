package com.redbeet.s1.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.redbeet.s1.util.Pager;

public interface BoardService {
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public BoardVO getSelect(BoardVO boardVO) throws Exception;
	
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setHitUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;	

}

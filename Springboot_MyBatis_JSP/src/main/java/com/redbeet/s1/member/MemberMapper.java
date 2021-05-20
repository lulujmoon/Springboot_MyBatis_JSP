package com.redbeet.s1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setFileInsert(MemberFileVO memberFileVO) throws Exception;

	public MemberVO getSelect(MemberVO memberVO) throws Exception;
	
}

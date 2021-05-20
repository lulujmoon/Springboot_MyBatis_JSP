package com.redbeet.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.redbeet.s1.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	@Transactional(rollbackFor = Exception.class)
	public int setInsert(MemberVO memberVO, MultipartFile multipartFile) throws Exception {
		int result = memberMapper.setInsert(memberVO);
		if(result<1) {
			throw new Exception();
		}
		
		String fileName = fileManager.save(multipartFile, "upload/member");
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setUsername(memberVO.getUsername());
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriginName(multipartFile.getOriginalFilename());
		memberMapper.setFileInsert(memberFileVO);
		
		return result;
	}
	
	public MemberVO getSelect(MemberVO memberVO) throws Exception {
		return memberMapper.getSelect(memberVO);
	}
}

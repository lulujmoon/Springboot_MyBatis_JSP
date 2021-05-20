package com.redbeet.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//Custom View 생성
//1. Abstract View 상속
//2. renderMergedOutputModel overriding하기
//3. annotation으로 FileDown 참조변수명 = new FileDown();한 것과 같음 => 참조변수명 = 클래스의 첫글자를 소문자로 변경한 것 = fileDown
//@Component("custom")

@Component
public class FileDown extends AbstractView {

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception { 
		System.out.println("hi");
		String fileName = (String)model.get("fileName");
		String filePath = (String)model.get("filePath");
		String originName = (String)model.get("originName");

		String path = "classpath:/static/";
		
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		
		file = new File(file, fileName);
		
		//한글 처리
		response.setCharacterEncoding("UTF-8");
		//총 파일의 크기
		response.setContentLengthLong(file.length());
		//다운로드 시 파일 이름 인코딩 처리
		fileName = URLEncoder.encode(originName, "UTF-8");
		//header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"" );
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//HDD에서 파일을 읽고
		FileInputStream fi = new FileInputStream(file);
		//Client로 전송 준비
		OutputStream os = response.getOutputStream();
		
		//전송
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
		
	}
}

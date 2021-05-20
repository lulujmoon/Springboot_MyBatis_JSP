package com.redbeet.s1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ResourceLoader resourceLoader;
	//resources까지 경로를 위해서

	/**
	 * ResourceLoader
	 * classpath의 경로를 받아오기 위해서 사용
	 * resourceLoader.getResource(path)에서 path의 경로에 없는 폴더가 있으면 오류가 난다.
	 */

	public String save(MultipartFile multipartFile, String filePath) throws Exception {
		//filePath : /resources/static/ 제외한 하위경로
		
		/*
		 * 저장할 폴더가 시스템에 고정일 경우
		 * String path = "c:/files"
		 * File file = new File(path, filePath); 
		 */
		
		/*
		 * 저장할 폴더가 고정이 아닌 경우 경로를 설정하는 방법
		 * 1. ResourceLoader 이용
		 * String path = "classpath:/static";
		 * 
		 * File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		 */
		
		/*
		 * 2. ClassPathResource
		 * classpath 경로를 받아오기 위해 사용
		 * ResourceLoader와 같지만 시작 경로에서 classpath:를 제외한다 
		 */
		
		String path = "static";
		ClassPathResource classPathResource = new ClassPathResource(path);
		File file = new File(classPathResource.getFile(), filePath);
		
		System.out.println(file.getAbsolutePath());
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString()+multipartFile.getOriginalFilename();
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}
}

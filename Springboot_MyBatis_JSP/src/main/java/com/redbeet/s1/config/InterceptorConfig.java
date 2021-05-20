package com.redbeet.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.redbeet.s1.interceptor.TestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//적용할 Interceptor bean을 등록
		registry.addInterceptor(testInterceptor)
		.addPathPatterns("/notice/**")
		.addPathPatterns("/qna/**")
		.excludePathPatterns("/notice/select");
		//어떤 URL 설정 (마지막 거에만 ; 붙임)
		//add -> Interceptor 적용할 url 등록
		//exclude -> Interceptor에서 배제할 url 등록
		
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
}

package com.redbeet.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.redbeet.s1.interceptor.FirstInterceptor;

@Configuration
public class FirstInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private FirstInterceptor firstInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(firstInterceptor)
		.addPathPatterns("/notice/**");
	}
}

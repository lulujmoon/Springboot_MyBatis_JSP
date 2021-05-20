package com.redbeet.s1.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.redbeet.s1.member.MemberVO;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	//controller 진입 전 admin 판별
	//admin이면 진행, 아니면 1. 로그인 폼으로 리다이렉트 2. 권한이 없음 alert, index로 이동
	
	//AdminInterceptorConfig에 등록
	// /notice/insert, update, delete
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean result = false;
		
		System.out.println("prehandle 시작");
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(member!=null && member.getUsername().equals("admin")) { 
			result = true;
		}else {
			//1. redirect login
			response.sendRedirect("/member/login");
			//2. forward
//			request.setAttribute("msg", "권한이 없습니다.");
//			request.setAttribute("path", "../member/login");
//			
//			RequestDispatcher view = request.getRequestDispatcher("../common/result.html");
//			view.forward(request, response);
		}
		System.out.println("prehandle 종료");
		
		return result;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		
	}
}

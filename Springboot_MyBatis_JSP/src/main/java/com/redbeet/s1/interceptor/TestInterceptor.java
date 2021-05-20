package com.redbeet.s1.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.redbeet.s1.member.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		 HttpSession session= request.getSession();
//		 Object obj = session.getAttribute("member");
//		 MemberVO memberVO=null;
		 boolean result= false;
//		 
//		 if(obj != null) {
//			 memberVO = (MemberVO)obj;
//			 if(memberVO.getUsername().equals("admin")) {
//				 result = true;
//			 }
//		 }
//		 
//		 if(!result) {
//			 
//			 response.sendRedirect("/member/login");
//		 }
		 
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Controller 종료 후 실행하는 부분
//		System.out.println("Controller 종료 후");
//		Map<String, Object> map = modelAndView.getModel();
//		Iterator<String> it = map.keySet().iterator();
//		
//		while(it.hasNext()) {
//			String key = it.next();
//			System.out.println(key);
//			System.out.println(map.get(key));
//		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//Client로 최종 전송 전
		System.out.println("Client 전송 전");
	}
	
}

package com.redbeet.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.redbeet.s1.board.BoardVO;
import com.redbeet.s1.member.MemberVO;

@Component
public class WriterInterceptor implements HandlerInterceptor {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//0. Method 형식
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			this.check(modelAndView, request);
		}
	}
	
	
	private void check(ModelAndView modelAndView, HttpServletRequest request) {
		BoardVO boardVO = (BoardVO)modelAndView.getModel().get("vo");
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		if(memberVO!=null && !(boardVO.getWriter().equals(memberVO.getName()))) {
			modelAndView.addObject("msg", "작성자가 일치하지 않습니다.");
			modelAndView.addObject("path", "../member/login");
			modelAndView.setViewName("common/result");
		}else if(memberVO==null) {
			modelAndView.addObject("msg", "로그인이 필요합니다.");
			modelAndView.addObject("path", "../member/login");
			modelAndView.setViewName("common/result");
		}
	}
	
	
}

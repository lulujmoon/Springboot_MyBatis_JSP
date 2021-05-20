package com.redbeet.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join(Model model) throws Exception{
		//form 검증을 위해서
		model.addAttribute("memberVO", new MemberVO());
		
	}
	
	@PostMapping("join")
	public String join(MemberVO memberVO, MultipartFile multipartFile, BindingResult bindingResult) throws Exception {
		
		if(bindingResult.hasErrors()) {
			return "member/join";
		}
		
		int result = memberService.setInsert(memberVO, multipartFile);
		return "redirect:/";
	}
	
	
	@GetMapping("login")
	public void login() throws Exception {}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = memberService.getSelect(memberVO);
		
		String result = "";
		if(memberVO==null) {
			result = "redirect:./login";
		}else {
			session.setAttribute("member", memberVO);
			result = "redirect:/";
		}
		
		return result;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("page")
	public void page() throws Exception {}
}

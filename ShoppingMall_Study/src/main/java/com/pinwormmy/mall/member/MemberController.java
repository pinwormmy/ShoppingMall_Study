package com.pinwormmy.mall.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		
		return "signUp";
	}
	
	@RequestMapping(value = "/submitSignUp", method = RequestMethod.POST)
	public String submitSignUp(MemberDTO memberDTO, HttpSession httpSession) throws Exception {
		
		memberService.submitSignUp(memberDTO);		
		
		// 회원가입 완료시 로그인도 같이
		memberDTO = memberService.checkLoginData(memberDTO);		
		httpSession.setAttribute("member", memberDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession httpSession, MemberDTO memberDTO) throws Exception {
		
		MemberDTO loginData;
	 	loginData = memberService.checkLoginData(memberDTO);
		
		httpSession.setAttribute("member", loginData);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) throws Exception {
				
		httpSession.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage() {
		
		return "myPage";
	}
	
	@RequestMapping(value = "/modifyMember", method = RequestMethod.GET)
	public String modifyMember() {
		
		return "modifyMember";
	}
	
	@RequestMapping(value = "/submitModifyMember", method = RequestMethod.POST)
	public String submitModifyMember(MemberDTO memberDTO, HttpSession httpSession) throws Exception {
		memberService.submitModifyMember(memberDTO);		
		return "redirect:/";
	}
}
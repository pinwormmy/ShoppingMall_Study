package com.pinwormmy.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pinwormmy.mall.dto.MemberDTO;
import com.pinwormmy.mall.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
		
		return "signUp";
	}
	
	@RequestMapping(value = "/submitSignUp", method = RequestMethod.POST)
	public String submitSignUp(MemberDTO memberDTO) throws Exception {
		
		memberService.submitSignUp(memberDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession httpSession, MemberDTO memberDTO) throws Exception {
		
		MemberDTO loginData;
	 	loginData = memberService.checkLoginData(memberDTO);
		
		httpSession.setAttribute("loginData", loginData);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) throws Exception {
				
		httpSession.invalidate();
		
		return "redirect:/";
	}
	
}
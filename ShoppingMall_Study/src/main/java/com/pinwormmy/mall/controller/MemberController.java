package com.pinwormmy.mall.controller;

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
	
}
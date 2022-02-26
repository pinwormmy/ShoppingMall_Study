package com.pinwormmy.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.dto.MemberDTO;
import com.pinwormmy.mall.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public void submitSignUp(MemberDTO memberDTO) throws Exception {
		
		memberMapper.submitSignUp(memberDTO);
		
	}

	@Override
	public MemberDTO checkLoginData(MemberDTO memberDTO) throws Exception{
		
		return memberMapper.checkLoginData(memberDTO);
		
	}

}

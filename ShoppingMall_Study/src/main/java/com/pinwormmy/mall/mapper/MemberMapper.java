package com.pinwormmy.mall.mapper;

import com.pinwormmy.mall.member.MemberDTO;

public interface MemberMapper {
	
	public void submitSignUp(MemberDTO memberDTO) throws Exception;

	public MemberDTO checkLoginData(MemberDTO memberDTO) throws Exception;

}

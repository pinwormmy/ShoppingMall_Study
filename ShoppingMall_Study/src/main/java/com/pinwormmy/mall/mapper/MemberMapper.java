package com.pinwormmy.mall.mapper;

import com.pinwormmy.mall.dto.MemberDTO;

public interface MemberMapper {
	
	public void submitSignUp(MemberDTO memberDTO);

	public MemberDTO checkLoginData(MemberDTO memberDTO);

}

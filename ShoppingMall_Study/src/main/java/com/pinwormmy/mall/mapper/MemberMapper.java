package com.pinwormmy.mall.mapper;

import com.pinwormmy.mall.dto.MemberDTO;

public interface MemberMapper {
	
	public void submitSignUp(MemberDTO memberDTO) throws Exception;

	public MemberDTO checkLoginData(MemberDTO memberDTO) throws Exception;

}

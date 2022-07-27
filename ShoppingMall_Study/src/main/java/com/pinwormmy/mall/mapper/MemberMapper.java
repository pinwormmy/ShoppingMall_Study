package com.pinwormmy.mall.mapper;

import com.pinwormmy.mall.member.MemberDTO;

public interface MemberMapper {
	
	public void submitSignUp(MemberDTO memberDTO) throws Exception;

	public MemberDTO checkLoginData(MemberDTO memberDTO) throws Exception;

	public void submitModifyMember(MemberDTO memberDTO) throws Exception;

	public int isUniqueId(String id) throws Exception;

	public int isUniqueNickname(String nickName) throws Exception;

}

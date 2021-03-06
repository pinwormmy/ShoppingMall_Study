package com.pinwormmy.mall.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public void submitModifyMember(MemberDTO memberDTO) throws Exception {
		memberMapper.submitModifyMember(memberDTO);		
	}

	@Override
	public int isUniqueId(String id) throws Exception {
		
		return memberMapper.isUniqueId(id);
	}

	@Override
	public int isUniqueNickname(String nickName) throws Exception {
		return memberMapper.isUniqueNickname(nickName);
	}

}

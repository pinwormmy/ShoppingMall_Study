package com.pinwormmy.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.dto.MemberDTO;
import com.pinwormmy.mall.dao.MemberDAO;
import com.pinwormmy.mall.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void submitSignUp(MemberDTO memberDTO) throws Exception{
		
		memberDAO.submitSignUp(memberDTO);
	}

}

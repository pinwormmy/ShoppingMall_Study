package com.pinwormmy.mall.dao;

import com.pinwormmy.mall.dto.MemberDTO;

public interface MemberDAO {
	
	public void submitSignUp(MemberDTO memberDTO) throws Exception;

}

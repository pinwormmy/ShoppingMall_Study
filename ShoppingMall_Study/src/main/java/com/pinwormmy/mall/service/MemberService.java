
package com.pinwormmy.mall.service;

import com.pinwormmy.mall.dto.MemberDTO;

public interface MemberService {
	
	public void submitSignUp(MemberDTO memberDTO) throws Exception;

	public MemberDTO checkLoginData(MemberDTO memberDTO) throws Exception;

}

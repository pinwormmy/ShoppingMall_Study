
package com.pinwormmy.mall.member;

public interface MemberService {
	
	public void submitSignUp(MemberDTO memberDTO) throws Exception;

	public MemberDTO checkLoginData(MemberDTO memberDTO) throws Exception;

	public void submitModifyMember(MemberDTO memberDTO) throws Exception;

}

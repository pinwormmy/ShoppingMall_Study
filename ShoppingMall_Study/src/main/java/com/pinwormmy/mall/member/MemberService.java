
package com.pinwormmy.mall.member;

public interface MemberService {
	
	public void submitSignUp(MemberDTO memberDTO) throws Exception;

	public MemberDTO checkLoginData(MemberDTO memberDTO) throws Exception;

	public void submitModifyMember(MemberDTO memberDTO) throws Exception;

	public int isUniqueId(String id) throws Exception;

	public int isUniqueNickname(String nickName) throws Exception;

}

package com.pinwormmy.mall.member;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String userId;
	private String userPassword;
	private String userEmail;
	private String nickName;
	private String address;

}

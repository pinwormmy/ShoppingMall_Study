package com.pinwormmy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pinwormmy.mall.dto.MemberDTO;
import com.pinwormmy.mall.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;			//MemberMapper.java 인터페이스 의존성 주입
	
	//회원가입 쿼리 테스트 메서드
	@Test
	public void submitSignUp() throws Exception{
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setUserId("test");			//회원 id
		memberDTO.setUserPassword("test");			//회원 비밀번호
		memberDTO.setUserEmail("test");		//회원 이름
		
		
		memberMapper.submitSignUp(memberDTO);			//쿼리 메서드 실행
		
	}
	
	
	
}
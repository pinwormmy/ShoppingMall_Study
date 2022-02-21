package com.pinwormmy.mall.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pinwormmy.mall.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private String Namespace = "com.pinwormmy.mapper.MemberMapper";
	
	@Override
	public void submitSignUp(MemberDTO memberDTO) throws Exception{
		
		sqlSession.insert(Namespace + ".submitSignUp", memberDTO);
	}

}
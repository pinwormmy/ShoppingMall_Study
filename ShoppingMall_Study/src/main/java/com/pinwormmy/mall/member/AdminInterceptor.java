package com.pinwormmy.mall.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	  
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        MemberDTO member = (MemberDTO)session.getAttribute("member");
        if ( !member.getUserId().equals("administrator") ){ // db에 운영자 권한관련 컬럼 따로 없어서 아이디로 구분     
        	System.out.println("인터셉트: 운영자 로그인 아님 : " + member.getUserId());
            response.sendRedirect("/");
            return false; 
        }       
        return true;
    } 
}

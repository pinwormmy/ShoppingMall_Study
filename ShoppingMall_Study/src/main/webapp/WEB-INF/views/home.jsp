<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>쇼핑몰 만들며 공부하긔</title>
	<style>
		*{
			font-family: 'Noto Sans KR', sans-serif;
			font-size:20px;
			font-weight:100;
			margin: 0;
	    	padding : 0;
		}
		
		h1{
		font-size: 42px;
		}
		
		body{
			font-size: 24px;
			font-weight: 400;
		}
		
		
		.topMenu { 
		    height: 50px; 
		    width: 100%;
		    background-color: #2d2d2d;	
		    padding: 10px;
	    }
	    .topMenu ul li {                       
		    list-style: none;           
		    color: white;               
		    float: left;                
		    line-height: 20px;          
		    vertical-align: middle;     
		    text-align: center;
		}
		.sellerLoginButton{
			font-size:12px;
			align-self:flex-end;
		}
		</style>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700;900&display=swap" rel="stylesheet">
</head>
<body>

<nav class="topMenu">
	<c:choose>
		<c:when test="${loginData.userId == 'administrator'}">
			<ul>
				<li>
					관리자 모드 : 상품 등록 및 페이지 설정 가능
					<button type="button" onclick="location.href='/logout'">로그아웃</button>
				</li>
			</ul>
		</c:when>
		<c:when test="${loginData != null}">
			<ul>
				<li>
					${loginData.userId} 님 환영합니다~! 
					<button type="button" onclick="location.href='/logout'">로그아웃</button>
				</li>
			</ul>
		</c:when>
		<c:otherwise>
			<form action="/login" method="post">
				<ul>
					<li>아이디 : <input type="text" name="userId"> </li>
					<li>비밀번호 : <input type="password" name="userPassword">
						<button>로그인</button> 
						<button type="button" onclick="location.href='/signUp'">회원가입</button>
					</li>				
				</ul>
			</form>
		</c:otherwise>
	</c:choose>
</nav>
	
<h1 style="font-size:42px; font-weight:700;">
	초기 세팅 완료!
</h1>

<p> 이제부터  진짜 시작이다!!</p>
<div>로그인 기본 틀만 구현 완료</div>
<p>장바구니 회원 상세정보 판매자/구매자 계정 접속 구분</p>
<p>administrator 계정을 판매자 계정으로 제작</p>
<p>회원정보 구체적으로 제작. 보유캐시. 주문상품 등등도 구현</p>
<p style="color:red;">창돼지는 내 방에서 깽판을 치고 있따</p>

<c:if test="${loginData.userId == 'administrator'}">
	<button type="button" onclick="location.href='/addProduct'">상품 등록</button>
</c:if>

</body>
</html>

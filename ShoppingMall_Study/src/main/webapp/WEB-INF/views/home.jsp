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
			font-weight: 300;
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
					<li>
						비밀번호 : <input type="password" name="userPassword">
						<button>로그인</button> 
						<button type="button" onclick="location.href='/signUp'">회원가입</button>
					</li>				
				</ul>
			</form>
		</c:otherwise>
	</c:choose>
</nav>
	
<h1 style="font-size:42px; font-weight:700;">
	쇼핑몰 만들면서 공부하기~!
</h1>

<div>로그인 기본 틀만 구현 완료</div>
<p>상품(글) 수정 및 삭제 구현하고, 글 편집기(CKEditor 사용) 구현하기-를 하려면 읽기부터 구현해야함</p>
<p>상품 대표이미지로 쓸 썸네일 시스템</p>
<p>장바구니, 상품재고 시스템 구현하기</p>
<p>회원정보 구체적으로 제작. 보유캐시. 주문상품 등등도 구현</p>

<br>
<hr>
<br>

<c:forEach items="${productList}" var="product">

	OOOOO썸네일이미지 필요OOOOO <br>
	${product.productName} <br>
	${product.productPrice} 원 <br>
	
	<c:if test="${loginData.userId == 'administrator'}">
		<button onclick="location.href='/modifyProduct?productNum=${product.productNum}'">수정</button>
		<button onclick="location.href='/deleteProduct?productNum=${product.productNum}'">삭제</button><br>
	</c:if>
	
	<br>
	
</c:forEach>

<c:if test="${loginData.userId == 'administrator'}">
	<button type="button" onclick="location.href='/addProduct'">상품 등록</button>
</c:if>

</body>
</html>

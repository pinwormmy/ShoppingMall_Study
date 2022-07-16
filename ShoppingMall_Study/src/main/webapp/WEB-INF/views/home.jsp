<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		a{
			text-decoration-line:none;
		}
		a:link{
			color:black;
		}
		a:visited{
			color:black;
		}
		a:active{
			color:black;
		}
		a:hover{
			color:black;
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
		ul, li{
			list-style: none;
		}
		.productList .item{
			width: 20%;
			display: inline-block;
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
					${loginData.nickName} 님 환영합니다~! 
					<button type="button" onclick="location.href='/logout'">로그아웃</button>
					<button type="button" class="btn_pull_right">장바구니</button>
					<button type="button" class="btn_pull_right">마이페이지</button>
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

<!-- 
 학습 목표
• 웹 에플리케이션과 HTTP API 개발에 익숙한 분
• 단위/통합 테스트코드 작성이 가능하신 분
• 다음 기술에 익숙하신 분
 - JAVA (JDK 8 이상), Spring Framework, JPA
 - RDBMS, Redis
 - AWS (S3, SQS, SNS, RDS, Elasticache, Lambda 등)
 - Git
 - Jenkins
 -->

<p>먼저 해봤던 내용들 빨리 구현해보기</p>
<p>장바구니, 상품재고 시스템 구현하기</p>
<p>회원정보 구체적으로 제작. 보유캐시</p>
<p>아오 CSS도 나중에 리액트할때 같이 공부하자</p>
<br>
<hr>
<br>
	<div class="productList">
		<ul>
			<c:forEach items="${productList}" var="product">
				<li class="item">
					<a href="/productDetails?productNum=${product.productNum}">
					<img src="${product.thumbnailPath}" /><br>
					${product.productName} </a> <br> 
					<fmt:formatNumber value="${product.productPrice}" pattern="###,###,###" />원 <br>		
					<br>
				</li>
			</c:forEach>
		</ul>
	</div>
<c:if test="${loginData.userId == 'administrator'}">
	<button type="button" onclick="location.href='/addProduct'">상품 등록</button>
</c:if>
<br>
<br>

</body>
</html>

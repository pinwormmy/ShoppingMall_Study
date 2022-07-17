<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>쇼핑몰 만들면서 공부를 한다</title>
</head>
<body>

<%@ include file="./include/header.jspf" %>

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
<p>주문(결제)하기, 상품재고, 게시판(공지,리뷰) 구현하기</p>
<p>회원정보 구체적으로 제작. 보유캐시</p>
<p>디자인(CSS)은 나중에 리액트할때 같이</p>
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
<c:if test="${member.userId == 'administrator'}">
	<button type="button" onclick="location.href='/addProduct'">상품 등록</button>
</c:if>
<br>
<br>

</body>
</html>

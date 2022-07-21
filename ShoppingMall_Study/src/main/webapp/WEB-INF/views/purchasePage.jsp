<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>구매하기 - 쇼핑몰 만들면서 공부를 한다</title>
</head>
<body>

<%@ include file="./include/header.jspf" %>

<h1 style="font-size:42px; font-weight:700;">
	구매하기 - 쇼핑몰 만들면서 공부하기~!
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
 
 장바구니 리스트 더 간단버전으로~<br>
 <hr>
<c:set var="totalPrice" value="0" />
	<c:forEach var="cart" items="${cartList}">	
		${cart.productDTO.productName} : ${cart.quantity} 개. 
		총가격 : <fmt:formatNumber value="${cart.productDTO.productPrice * cart.quantity}" pattern="###,###,###" /> 원<br>
		<c:set var="totalPrice" value="${totalPrice +  cart.productDTO.productPrice * cart.quantity}"/>
	</c:forEach>

<form action="/order" method="post">

수령할 주소 : <br>
<input type="hidden" name="userId" value="${member.userId}">
<input type="hidden" name="price" value="${totalPrice}">
<input type="hidden" name="status" value="상품준비중">
<textarea name="address" cols="70" rows="2">${member.address}</textarea><br>

결제수단 : <input type="radio" name="paymentType" value="creditCard" checked>신용카드
			<input type="radio" name="paymentType" value="deposit">무통장입금
			<input type="radio" name="paymentType" value="mobile">휴대폰결제
			<br>
번호 입력 : <input type="text" name="creditNum" required><br>

<h4>결제금액 : <fmt:formatNumber value="${totalPrice}" pattern="###,###,###" /> 원</h4> <br>
<hr>
<br>
<button>결제</button>
</form>
<button type="button" onclick="location.href='/showCart?userId=${member.userId}'">이전화면</button>
<button type="button" onclick="location.href='/'">메인화면</button>

</body>
</html>

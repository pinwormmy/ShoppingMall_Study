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
 
수령할 주소 : <br>
<textarea name="address" cols="70" rows="2">${member.address}</textarea><br>

결제수단 : <input type="radio" value="신용카드" checked>신용카드
			<input type="radio" value="무통장 입금">무통장입금
			<input type="radio" value="휴대폰 결제">휴대폰결제
			<br>
번호 입력 : <input type="text"><br>

	<c:set var="totalPrice" value="0" />
	<c:forEach var="cart" items="${cartList}">	
		<c:set var="totalPrice" value="${totalPrice +  cart.productDTO.productPrice * cart.quantity}"/>
	</c:forEach>
			
결제금액 : <fmt:formatNumber value="${totalPrice}" pattern="###,###,###" /> 원 <br>

	
	
<button type="button">결제</button>

</body>
</html>

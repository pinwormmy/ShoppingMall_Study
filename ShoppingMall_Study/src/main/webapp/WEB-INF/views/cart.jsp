<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>장바구기 보기</title>
</head>
<body>
<%@ include file="./include/header.jspf" %>
<br>
	<h4>나중에 테이블로 깔끔하게 정렬</h4>
	<hr>
<br>
	<c:if test="${empty cartList}">장바구니가 비었습니다. 맘에 드는 상품을 골라보세요~!</c:if>
	<c:forEach var="cart" items="${cartList}">	
		<img src="${cart.productDTO.thumbnailPath}" height="80">
		${cart.productDTO.productName} : ${cart.quantity} 개. 총가격 : ${cart.productDTO.productPrice * cart.quantity} 원
		<button type="button" onclick="location.href='/deleteCart?userId=${cart.userId}&cartNum=${cart.cartNum}'">삭제</button><br>
	</c:forEach>
<br>
<br>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br>
</body>
</html>

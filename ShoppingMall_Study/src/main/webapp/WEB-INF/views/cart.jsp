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
	<c:set var="totalPrice" value="0" />
	<c:if test="${empty cartList}">장바구니가 비었습니다. 맘에 드는 상품을 골라보세요~!</c:if>
	<c:forEach var="cart" items="${cartList}">	
		<img src="${cart.productDTO.thumbnailPath}" height="80">
		${cart.productDTO.productName} : ${cart.quantity} 개. 
		총가격 : <fmt:formatNumber value="${cart.productDTO.productPrice * cart.quantity}" pattern="###,###,###" /> 원
		<c:set var="totalPrice" value="${totalPrice +  cart.productDTO.productPrice * cart.quantity}"/>
		<button type="button" onclick="location.href='/deleteCart?userId=${cart.userId}&cartNum=${cart.cartNum}'">삭제</button><br>
	</c:forEach>
	<br>
	<hr>
	전체 구매 시 총 <fmt:formatNumber value="${totalPrice}" pattern="###,###,###" /> 원 <br>
<br>
<button type="button" onclick="location.href='/purchasePage?userId=${member.userId}'"> 구매하기 </button> <br><br>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br>
</body>
</html>

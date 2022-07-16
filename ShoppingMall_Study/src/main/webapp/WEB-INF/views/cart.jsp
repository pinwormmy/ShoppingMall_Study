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
	<h4>원래는 상품명, 썸네일작게, 수량</h4>
<br>
	<c:if test="${empty cartList}">장바구니가 비었습니다. 맘에 드는 상품을 골라보세요~!</c:if>
	<c:forEach var="cart" items="${cartList}">	
		${cart.productNum} : ${cart.quantity} 개 <br>
	</c:forEach>
<br>
<br>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>주문 목록 보기</title>
</head>
<body>
<%@ include file="./include/header.jspf" %>
<br>
	<h4>나중에 테이블로 깔끔하게 정렬</h4>
	<hr>
<br>
	
	<c:if test="${empty orderList}">주문 목록이 비었습니다. 맘에 드는 상품을 구매해보세요~!</c:if>
	<c:forEach var="order" items="${orderList}">			
		주문번호: ${order.orderNum} / 발송주소: ${order.address} / 
		결제금액: ${order.price} / 처리현황: ${order.status} / 주문일: ${order.regDate} <br>
	</c:forEach>
	<br>
	<hr>	
	<br>

<button type="button" onclick="location.href='/'"> 쇼핑 계속하기 </button> <br>
</body>
</html>

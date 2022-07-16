<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>상품 조회 - 쇼핑몰 만들며 공부하긔</title>
</head>
<body>

<%@ include file="./include/header.jspf" %>

<h1 style="font-size:42px; font-weight:700;">
	상품 조회하기 : ${product.productName} 
</h1>

상품명 : ${product.productName} <br>
상품가격 : <fmt:formatNumber value="${product.productPrice}" pattern="###,###,###" />원 <br>	
등록시간 : <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${product.regDate}"/> <br>

<hr>
<c:if test="${member != null}">
	<form action="/addCart" method="post">
		넣을 갯수 : <input type="text" name="quantity" id="quantity">
		<input type="hidden" name="productNum" value="${product.productNum}">
		<input type="hidden" name="userId" value="${member.userId}">
		<button type="button">장바구니 넣기</button>
	</form>
</c:if>
${product.productDescription} <br>
	<c:if test="${member.userId == 'administrator'}">
		<button type="button" onclick="location.href='/modifyProduct?productNum=${product.productNum}'">수정</button>
		<button type="button" onclick="location.href='/deleteProduct?productNum=${product.productNum}'">삭제</button>
	</c:if>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br>

	<script>
		let quantity = document.getElementById("quantity");
		function checkQuantityPositiveNumber(){

		}
	</script>

</body>
</html>

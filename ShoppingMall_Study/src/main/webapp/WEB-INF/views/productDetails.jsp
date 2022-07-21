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
<c:if test="${member != null and member.userId != 'administrator'}">
	<form action="/addCart" id="addCartForm">
		넣을 갯수 : <input type="text" name="quantity" id="quantity" size=1>
		<input type="hidden" name="productNum" value="${product.productNum}">
		<input type="hidden" name="userId" value="${member.userId}">
		<button type="button" onclick="checkQuantityPositiveNumber();">장바구니 넣기</button>
	</form>
</c:if>
${product.productDescription} <br>
	<c:if test="${member.userId == 'administrator'}">
		<button type="button" onclick="location.href='/modifyProduct?productNum=${product.productNum}'">수정</button>
		<button type="button" onclick="location.href='/deleteProduct?productNum=${product.productNum}'">삭제</button>
	</c:if>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br>

	<script>
		let addCartForm = document.getElementById("addCartForm");
		
		function checkQuantityPositiveNumber(){
			if(addCartForm.quantity.value > 0){
				alert("상품을 장바구니에 담았습니다~!");
				addCartForm.submit();
			}else{
				alert("수량을 하나 이상 넣어주세요~!!")
			}
		}
	</script>

</body>
</html>

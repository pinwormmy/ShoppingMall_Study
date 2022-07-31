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
컴퓨터공학 전공 혹은 그에 준하는 전공 및 지식을 보유하신 분
Kotlin/Java/Python/Ruby 등 하나 이상의 프로그래밍 언어 전문성을 보유하신 분
RDBMS 및 다양한 NoSQL 데이터베이스에 대한 지식을 보유하신 분
 -->

<p>게시물 댓글, 상품 리뷰 기능 만들기</p>
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

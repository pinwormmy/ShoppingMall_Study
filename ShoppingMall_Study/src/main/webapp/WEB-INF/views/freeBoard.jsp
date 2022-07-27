<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>자유게시판 - 쇼핑몰 만들면서 공부하기</title>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
</head>
<body>
<%@ include file="./include/header.jspf" %>

<h2>테이블로 이쁘게 바꿔야함. 리액트하면서</h2>
<hr>
<br>
글번호 | 글제목  |  작성자 |   작성일    | 조회수  | <br>
<hr>
	<c:if test="${empty postList}">작성된 글이 없습니다. 글쓰기 버튼을 누르면 작성할 수 있습니다~!</c:if>
	<c:forEach var="post" items="${postList}">	
		${post.postNum} | <a href="/readPost?postNum=${post.postNum}">${post.title}</a> | ${post.writer} | 
		<fmt:formatDate pattern="yyyy-MM-dd" value="${post.regDate}"/> | ${post.views} | <br>
	</c:forEach>
<hr>
<br>
<button type="button" onclick="location.href='/writePost'">글쓰기</button> <br>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br>
</body>
</html>

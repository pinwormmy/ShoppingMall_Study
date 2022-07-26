<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>글보기 - 자유게시판: 쇼핑몰 만들면서 공부하기</title>
	
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<%@ include file="./include/header.jspf" %>
<br>
	글번호 : ${post.postNum}<br>
	제목 : ${post.title} <br>
	작성자 : ${post.writer} <br>
	올린 시간 : ${post.regDate}<br>		
	조회수 : ${post.views}<br>
	${post.content} <br>
	
<c:if test="${member.userId == post.writer or member.userId == 'administrator'}">
	<button type="button" onclick="location.href='/modifyPost?postNum=${post.postNum}'">수정</button>	
	<button type="button" onclick="location.href='/deletePost?postNum=${post.postNum}'">삭제</button>	
</c:if>	
	<button type="button" onclick="location.href='/freeBoard'">목록</button>
	<br><br>
</body>
</html>

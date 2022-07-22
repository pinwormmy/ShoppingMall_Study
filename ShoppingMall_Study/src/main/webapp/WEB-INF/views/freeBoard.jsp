<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>자유게시판 - 쇼핑몰 만들면서 공부하기</title>
</head>
<body>

<%@ include file="./include/header.jspf" %>

<h2>갑자기 밑도끝도없이 접속안되는거 어이없다...파일다시만들려다 날려먹음 ㅡㅡ;</h2>
<hr>
<br>
글번호 | 글제목  |  작성자 |   작성일    | 조회수  | <br>
<hr>
	<c:if test="${empty postList}">작성된 글이 없습니다. 글쓰기 버튼을 누르면 작성할 수 있습니다~!</c:if>
	<c:forEach var="post" items="${postList}">	
		${post.postNum} | ${post.title} | ${post.writer} | ${post.regDate} | ${post.views} | <br>
	</c:forEach>
<hr>
<br>
<button type="button" onclick="location.href='/writePost'">글쓰기</button> <br>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br>
</body>
</html>

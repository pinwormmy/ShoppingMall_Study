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
	<c:forEach var="post" items="${postList}" begin="${page.postBeginPoint}" end="${page.postEndPoint}">	
		${post.postNum} | <a href="/readPost?postNum=${post.postNum}">${post.title}</a> | ${post.writer} | 
		<fmt:formatDate pattern="yyyy-MM-dd" value="${post.regDate}"/> | ${post.views} | <br>
	</c:forEach>
<br>
<hr>
<c:if test="${page.prevPageSetPoint >= 1}">
<a href="/freeBoardPage?recentPage=${page.prevPageSetPoint}">이전</a>
</c:if>
	<c:forEach var="countPage" begin="${page.pageBeginPoint}" end="${page.pageEndPoint}">
		<a href="/freeBoardPage?recentPage=${countPage}">${countPage}</a>
	</c:forEach>
<c:if test="${page.nextPageSetPoint <= page.totalPage}">
<a href="/freeBoardPage?recentPage=${page.nextPageSetPoint}">다음</a>
</c:if>
<br>
<button type="button" onclick="location.href='/writePost'">글쓰기</button> <br>
<button type="button" onclick="location.href='/'"> 메인화면으로 </button> <br><br>

<form action="/searchPost">
	<select name="keywordType">
		<option value="titleAndContent">제목+내용</option>
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="writer">작성자</option>
	</select>
	<input name="keyword">
	<button>검색</button>
</form>
</body>
</html>

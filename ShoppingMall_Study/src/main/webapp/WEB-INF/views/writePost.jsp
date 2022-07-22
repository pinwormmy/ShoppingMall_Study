<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>글쓰기 - 자유게시판: 쇼핑몰 만들면서 공부하기</title>
	
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<%@ include file="./include/header.jspf" %>
<br>
	<form action="/submitPost" method="post" enctype="multipart/form-data">
		제목 <input type="text" name="title" size="70" required> <br>		
		<textarea name="content" id="content"></textarea><br>
		<script type="text/javascript">
			// 글쓰기 editor 및 사진 업로드 기능
			CKEDITOR.replace('content', {
				filebrowserUploadUrl : '/ckUpload/imageUpload.do',
				width : '70%',
				height : 500
			});
		</script>		
		<button>게시하기</button>
		<button type="button" onclick="location.href='/freeboard'">취소</button>
	</form>
<br>
</body>
</html>

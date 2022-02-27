<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>쇼핑몰 만들며 공부하긔</title>
	<style>
		*{
			font-family: 'Noto Sans KR', sans-serif;
			font-size:20px;
			font-weight:100;
			margin: 0;
	    	padding : 0;
		}
			
	</style>
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700;900&display=swap" rel="stylesheet">
	
	<script type="text/javascript">
	function checkSignUp(){
		
		let userId = document.getElementById("userId").value
		let userPassword = document.getElementById("userPassword").value
		let userEmail = document.getElementById("userEmail").value
		
		if(userId == "" || userPassword == "" || userEmail == ""){
			alert("입력 똑바로 하시오!")
		}
		else{
			setTimeout(function(){
				alert("가입 완료. 환영합니다^^")
			},0);
		} 
		
	}
</script>
</head>
<body>
	<div>
		<form action="/submitSignUp" method="post">
			아이디 : <input type="text" name="userId" id="userId" required><br>
			비밀번호: <input type="password" name="userPassword" id="userPassword" required><br>
			이메일 : <input type="text" name="userEmail" id="userEmail" required><br>
			<button onclick="checkSignUp()">회원가입</button>
			<button type="button" onclick="location.href='/'">취소</button>
		</form>
	</div>
</body>
</html>
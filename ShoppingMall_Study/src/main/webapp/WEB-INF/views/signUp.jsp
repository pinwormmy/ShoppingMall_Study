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
		
		let submitSignUpForm = document.getElementById("submitSignUpForm");
		let userId = document.getElementById("userId").value;
		let userPassword = document.getElementById("userPassword").value;
		let userEmail = document.getElementById("userEmail").value;
		
		// 아이디랑 이메일 정규표현식이랑 , 중복확인도 구현해야함
		let idForm = /^[a-z]+[a-z0-9]{5,19}$/g;
		// 주소란에 카카오 주소 적용해보기
		
		
		if(userId == "" || userPassword == "" || userEmail == ""){
			alert("입력 똑바로 하시오!")
		}else if(!idForm.test(userId)){
			alert("ID는 영문자로 시작하는 6~20자 영어 혹은 숫자이어야 합니다;")
		}else{
			setTimeout(function(){
				alert("가입 완료. 환영합니다^^")
			},0);
			submitSignUpForm.submit();
		} 
		
	}
</script>
</head>
<body>
	<div>
		<form action="/submitSignUp" id="submitSignUpForm" method="post">
			아이디 : <input type="text" name="userId" id="userId" required><br>
			닉네임 : <input type="text" name="nickName" id="nickName" required><br>
			비밀번호: <input type="password" name="userPassword" id="userPassword" required><br>
			이메일 : <input type="text" name="userEmail" id="userEmail" required><br>
			<button type="button" onclick="checkSignUp()">회원가입</button>
			<button type="button" onclick="location.href='/'">취소</button>
		</form>
	</div>
</body>
</html>
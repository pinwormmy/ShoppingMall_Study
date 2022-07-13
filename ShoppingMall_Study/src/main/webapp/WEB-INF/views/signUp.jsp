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
</head>
<body>
	<div>
		<form action="/submitSignUp" id="submitSignUpForm" method="post">
			아이디 : <input type="text" name="userId" id="userId" required><br>
			닉네임 : <input type="text" name="nickName" id="nickName" required><br>
			비밀번호: <input type="password" name="userPassword" id="userPassword" required><br>
			비밀번호 확인 : <input type="password" name="userPassword2" id="userPassword2" required><br>
			이메일 : <input type="email" name="userEmail" id="userEmail" required><br>
			주소 : <textarea name="address" cols="70" rows="2"></textarea><br>
			<button type="button" onclick="checkSignupForm()">회원가입</button>
			<button type="button" onclick="location.href='/'">취소</button>
		</form>
	</div>
	
	
<script type="text/javascript">
	
	let submitSignUpForm = document.getElementById("submitSignUpForm");
	// 아디 중복확인 ajax포함해서 적용해보기
	// 이메일 인증해보기
	// 주소란에 카카오 주소 적용해보기
		
	function checkSignupForm() {
			
		let isId = /^[a-z]+[a-z0-9]{5,19}$/g;
		let isPassword = /\S{4,}/;
		let isEmail = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
			
		if (submitSignUpForm.userId.value == "") {
			alert("ID를 입력하세요!!");
			submitSignUpForm.userId.focus();
			return false;
		}
		if(!isId.test(submitSignUpForm.userId.value)){
			alert("ID는 영문자로 시작하는, 6~20자 영어 혹은 숫자이어야 합니다;");
			submitSignUpForm.userId.focus();
			return false;
		}
		if (submitSignUpForm.userPassword.value == "") {
			alert("비밀번호를 입력하세요!!");
			submitSignUpForm.pw.focus();
			return false;
		}
		if(!isPassword.test(submitSignUpForm.userPassword.value)){
			alert("비밀번호는 4자리 이상이어야 합니다;");
			submitSignUpForm.userPassword.focus();
			return false;
		}
		if (submitSignUpForm.userPassword2.value == "") {
			alert("비밀번호 확인도 입력하세요!!");
			submitSignUpForm.pw2.focus();
			return false;
		}
		if (submitSignUpForm.userPassword.value != userPassword2.value) {
			alert("비밀번호 재입력까지 일치해야합니다.");
			submitSignUpForm.pw.focus();
			return false;
		}
		if (submitSignUpForm.nickName.value == "") {
			alert("닉네임을 입력하세요!!");
			submitSignUpForm.mName.focus();
			return false;
		}
		if (submitSignUpForm.userEmail.value == "") {
			alert("이메일을 입력하세요!!");
			submitSignUpForm.userEmail.focus();
			return false;
		}
		if(!isEmail.test(submitSignUpForm.userEmail.value)){
			alert("이메일 양식을 확인해주세요!!");
			submitSignUpForm.userEmail.focus();
			return false;
		}		
		alert("가입 완료. 환영~!~!")
		submitSignUpForm.submit();
	}
</script>

</body>
</html>

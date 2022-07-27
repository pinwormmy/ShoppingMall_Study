<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입 - 쇼핑몰 만들며 공부하긔</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

<h2>회원가입: 중복확인도 구현해라</h2>

	<div>
		<form action="/submitSignUp" id="submitSignUpForm" method="post">
			아이디 : <input type="text" name="userId" id="userId" required>
			<span id="isUniqueId"></span><br>
			닉네임 : <input type="text" name="nickName" id="nickName" required>
			<span id="isUniqueNickname"></span><br>
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
	let checkUniqueId = false;
	let checkUniqueNickname = false;
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
		if(checkUniqueId == false){
			alert("중복되지 않은 ID를 입력하세요!!");
			submitSignUpForm.userId.focus();
			return false;
		}
		if (submitSignUpForm.nickName.value == "") {
			alert("닉네임을 입력하세요!!");
			submitSignUpForm.mName.focus();
			return false;
		}
		if(checkUniqueNickname == false){
			alert("중복되지 않은 별명를 입력하세요!!");
			submitSignUpForm.nickName.focus();
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
		alert("가입 완료. 환영~!~!", checkUniqueId);
		submitSignUpForm.submit();
	}
	
	$('#userId').focusout(function(){
		let userId = $('#userId').val();
		
		if(userId == ""){
			$("#isUniqueId").html('');
			isUniqueId= false;
			return false;		
		}	
		$.ajax({
			url : "/isUniqueId",
			type : "get",
			data : 'userId=' + $('#userId').val(),
			datatype : 'json',
			success : function(result){
				if(result == 0){
					$("#isUniqueId").html('사용할 수 있는 ID입니다.');
					checkUniqueId = true;
				}else{
					$("#isUniqueId").html('사용할 수 없는 ID입니다.');	
					checkUniqueId = false;
				}
			},
			error : function(a, b, c){
				alert("(아이디중복검사)서버 요청 실패...", a, b, c);
			}
		})
	});
	
	$('#nickName').focusout(function(){
		let nickName = $('#nickName').val();
		
		if(nickName == ""){
			$("#isUniqueNickname").html('');
			checkUniqueNickname= false;
			return false;		
		}
			
		$.ajax({
			url : "/isUniqueNickname",
			type : "get",
			data : 'nickName=' + $('#nickName').val(),
			datatype : 'json',
			success : function(result){
				if(result == 0){
					$("#isUniqueNickname").html('사용할 수 있는 별명입니다.');
					checkUniqueNickname= true;
				}else{
					$("#isUniqueNickname").html('사용할 수 없는 별명입니다.');	
					checkUniqueNickname= false;
				}
			},
			error : function(a, b, c){
				alert("(별명중복검사는 왜 만들어가지고;;)서버 요청 실패...", a, b, c);
			}
		})
	});
	
</script>

</body>
</html>

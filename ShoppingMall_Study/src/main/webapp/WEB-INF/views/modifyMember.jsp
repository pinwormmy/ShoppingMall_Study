<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원정보 수정 - 쇼핑몰 만들며 공부하긔</title>
</head>
<body>

<h2>회원정보 수정</h2>

	<div>
	
		<form action="/submitModifyMember" id="submitModifyMember" method="post">
		
			아이디 : <input type="text" name="userId" id="userId" class="userId" value="${member.userId}" disabled><br>
			<input type="hidden" name="userId" id="userId" value="${member.userId}">
			닉네임 : <input type="text" name="nickName" id="nickName" value="${member.nickName}" required><br>
			비밀번호: <input type="password" name="userPassword" id="userPassword" required><br>
			비밀번호 확인 : <input type="password" name="userPassword2" id="userPassword2" required><br>
			이메일 : <input type="email" name="userEmail" id="userEmail" value="${member.userEmail}" required><br>
			주소 : <textarea name="address" cols="70" rows="2">${member.address}</textarea><br>			
			<button type="button" onclick="checksubmitModifyMember();">회원정보 수정</button>
			<button type="button" onclick="location.href='/myPage'">이전 화면</button>
			
		</form>
	</div>
	
<script type="text/javascript">
	
	let submitModifyMember = document.getElementById("submitModifyMember");
			
	function checksubmitModifyMember() {
			
		let isPassword = /\S{4,}/;
		let isEmail = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
		
		if (submitModifyMember.userPassword.value == "") {
			alert("비밀번호를 입력하세요!!");
			submitModifyMember.pw.focus();
			return false;
		}
		if(!isPassword.test(submitModifyMember.userPassword.value)){
			alert("비밀번호는 4자리 이상이어야 합니다;");
			submitModifyMember.userPassword.focus();
			return false;
		}
		if (submitModifyMember.userPassword2.value == "") {
			alert("비밀번호 확인도 입력하세요!!");
			submitModifyMember.pw2.focus();
			return false;
		}
		if (submitModifyMember.userPassword.value != userPassword2.value) {
			alert("비밀번호 재입력까지 일치해야합니다.");
			submitModifyMember.pw.focus();
			return false;
		}
		if (submitModifyMember.nickName.value == "") {
			alert("닉네임을 입력하세요!!");
			submitModifyMember.mName.focus();
			return false;
		}
		if(!isEmail.test(submitModifyMember.userEmail.value) && submitModifyMember.userEmail.value != ""){
			alert("이메일 양식을 확인해주세요!!");
			submitModifyMember.userEmail.focus();
			return false;
		}		
		alert("회원 정보가 수정되었습니다~~")
		
		submitModifyMember.submit();
	}
</script>

</body>
</html>

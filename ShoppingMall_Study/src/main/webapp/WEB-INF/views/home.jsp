<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>쇼핑몰 만들며 공부하긔</title>
	<style>
		*{
			font-family: 'Noto Sans KR', sans-serif;
			font-size:20px;
			font-weight:100;
			margin: 0;
	    	padding : 0;
		}
		
		h1{
		font-size: 42px;
		}
		
		body{
			font-size: 32px;
			font-weight: 400;
		}
		
		
		.topMenu { 
		    height: 50px; 
		    width: 100%;
		    background-color: #2d2d2d;	
		    padding: 5px;
	    }
	    .topMenu ul li {                       
		    list-style: none;           
		    color: white;               
		    float: left;                
		    line-height: 30px;          
		    vertical-align: middle;     
		    text-align: center;
		}
		</style>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700;900&display=swap" rel="stylesheet">
</head>
<body>

<nav class="topMenu">
	<form action="/login" method="post">
		<ul>
			<li>아이디 : <input type="text" name="userId"> </li>
			<li>비밀번호 : <input type="password" name="userPassword">
				<button>로그인</button> 
				<button type="button" onclick="location.href='/signUp'">회원가입</button>
			</li>				
		</ul>
	</form>
</nav>
	
<h1 style="font-size:42px; font-weight:700;">
	드디어 초기 세팅 완료!!
</h1>

<P> 지금 시간은 서버기준 ${serverTime} 입니다. </P>
<p> 이전 코드 작성분 복사해서 다시 해보자!</p>
<p>명상하고 뻗어버림...집중좀하자</p>
</body>
</html>

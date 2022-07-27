<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>마이페이지 - 쇼핑몰 만들면서 공부를 한다</title>
</head>
<body>
<!-- 
 학습 목표
• 웹 에플리케이션과 HTTP API 개발에 익숙한 분
• 단위/통합 테스트코드 작성이 가능하신 분
• 다음 기술에 익숙하신 분
 - JAVA (JDK 8 이상), Spring Framework, JPA
 - RDBMS, Redis
 - AWS (S3, SQS, SNS, RDS, Elasticache, Lambda 등)
 - Git
 - Jenkins
 -->
<%@ include file="./include/header.jspf" %>

<h1 style="font-size:42px; font-weight:700;">
	마이페이지 - 쇼핑몰 만들면서 공부하기~!
</h1>
<hr>
${member.nickName}(${member.userId})님 환영합니다.<br><br>

이메일 : ${member.userEmail}<br><br>

주소 : ${member.address}<br><br>

<hr>
<br>
<button type="button" onclick="location.href='/modifyMember'">회원 정보 수정</button>
<button type="button" onclick="location.href='/showOrderList?userId=${member.userId}'">주문 목록</button>
<button type="button" onclick="location.href='/'">메인 화면</button>
<br>
</body>
</html>

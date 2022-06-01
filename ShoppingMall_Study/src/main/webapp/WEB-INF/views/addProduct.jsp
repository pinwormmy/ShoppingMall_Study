<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>상품 등록 - 쇼핑몰 만들며 공부하긔</title>
<style>
* {
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 20px;
	font-weight: 100;
	margin: 0;
	padding: 0;
}

h1 {
	font-size: 42px;
}

.topMenu {
	height: 50px;
	width: 100%;
	background-color: #2d2d2d;
	padding: 10px;
}

.topMenu ul li {
	list-style: none;
	color: white;
	float: left;
	line-height: 20px;
	vertical-align: middle;
	text-align: center;
}

.sellerLoginButton {
	font-size: 12px;
	align-self: flex-end;
}
</style>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700;900&display=swap"
	rel="stylesheet">
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
	<nav class="topMenu">
		<c:choose>
			<c:when test="${loginData.userId == 'administrator'}">
				<ul>
					<li><b>관리자 모드 : 상품 등록 및 페이지 설정 가능</b>
						<button type="button" onclick="location.href='/logout'">로그아웃</button>
					</li>
				</ul>
			</c:when>
			<c:when test="${loginData != null}">
				<ul>
					<li>${loginData.userId}님환영합니다~!
						<button type="button" onclick="location.href='/logout'">로그아웃</button>
					</li>
				</ul>
			</c:when>
			<c:otherwise>
				<form action="/login" method="post">
					<ul>
						<li>아이디 : <input type="text" name="userId">
						</li>
						<li>비밀번호 : <input type="password" name="userPassword">
							<button>로그인</button>
							<button type="button" onclick="location.href='/signUp'">회원가입</button>
						</li>
					</ul>
				</form>
			</c:otherwise>
		</c:choose>
	</nav>

	<h1 style="font-size: 42px; font-weight: 700;">판매 상품 등록하기. 상품명.
		상품사진. 가격. 수량체크 등등...</h1>

	<form action="/submitProduct">
		상품명 : <input type="text" name="productName" required> <br>
		상품가격 : <input type="text" name="productPrice" required> <br>
		<hr>
		<textarea name="productDescription" id="productDescription"></textarea>
		<br>
		<script type="text/javascript">
			// 글쓰기 editor 및 사진 업로드 기능
			CKEDITOR.replace('productDescription', {
				filebrowserUploadUrl : '/ckUpload/imageUpload.do',
				width : '70%',
				height : 500
			});
		</script>

		<div class="selectThumbnail">
			<label for="gdsImg">썸네일 이미지용</label><br> 
			<input type="file"
				id="thumbnailImage" name="thumbnailImage" />
			<div class="showThumbnailImage">
				<img src="" />
			</div>

			<script>
				$("#thumbnailImage").change(
						function() {
							if (this.files && this.files[0]) {
								var reader = new FileReader;
								reader.onload = function(data) {
									$(".showThumbnailImage img").attr("src",
											data.target.result).width(500);
								}
								reader.readAsDataURL(this.files[0]);
							}
						});
			</script>
			
		</div><br>
		
		<button>상품게시</button>
		<button type="button" onclick="location.href='/'">취소</button>
	</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>상품 등록 - 쇼핑몰 만들며 공부하긔</title>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<%@ include file="./include/header.jspf" %>
	
	<h1 style="font-size: 42px; font-weight: 700;">판매 상품 등록하기: 재고기능 미구현</h1>

	<form action="/submitProduct" method="post" enctype="multipart/form-data">
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
			<label for="thumbnailPath">썸네일 이미지용</label><br> 
			<input type="file" id="thumbnailPath" name="file" />
			<div class="showThumbnailImage">
				<img src="" />
			</div>			
		</div>		
		<button>상품게시</button>
		<button type="button" onclick="location.href='/'">취소</button>
	</form>
	<br>
	<script>
		$("#thumbnailPath").change(
				function() {
					if (this.files && this.files[0]) {
						var reader = new FileReader;
						reader.onload = function(data) {
							$(".showThumbnailImage img").attr("src",
									data.target.result).width(300);
						}
						reader.readAsDataURL(this.files[0]);
					}
				});
	</script>
</body>
</html>

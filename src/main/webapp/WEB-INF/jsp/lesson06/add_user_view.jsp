<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>

<!-- bootstrap CDN link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- 원본 제이쿼리 스크립트 가져온다(슬림 x) -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>


</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>

		<form method="post" action="/lesson06/ex01/add_user">
			<label for="name"><b>이름:</b><input type="text" id="name"
				name="name" class="form-control" placeholder="이름을 입력하세요"></label><br>
			<label for="yyyymmdd"><b>생년월일:</b><input type="text"
				id="yyyymmdd" name="yyyymmdd" class="form-control"
				placeholder="예) 19990101"></label><br> <br> <label
				for="email" class="w-25"><b>이메일 주소:</b><input type="text"
				id="email" name="email" class="form-control"
				placeholder="이메일 주소를 입력하세요"></label><br> <b>자기 소개:</b><br>
			<textarea name="introduce" rows="10" cols="5" class="form-control"></textarea>

			<%-- submit 버튼: 클릭시 폼태그 액션이 수행됨 --%>
			<p>
				<input type="button" id="addBtn" class="btn btn-success" value="추가">
			</p>
		</form>
	</div>

	<script>
		$(document).ready(function() {

			/* // (1) jquery의 submit 기능 이용하기
			 $("form").on("submit", function(e) {
				//e.preventDefault(); // submit 되는 것을 막는다.
				//alert("추가 버튼 클릭");
				
				// validation
				let name = $('#name').val().trim(); // 이름을 가져와서 공백 제거
				//alert(name);
				if (name == '') {
					alert("이름을 입력해주세요.");
					return false;
				}
				
				let yyyymmdd = $('#yyyymmdd').val().trim();
				if (yyyymmdd == '') {
					alert("생년월일을 입력해주세요.");
					return false;
				}
				
				// 여기까지 도달하면 submit
			});  */

			// (2) jquery 의 AJAX통신을 이용하기
			// AJAX를 사용할 떄는 절대로 submit 버튼 쓰지 말고 일반 버튼으로 type="button"
			$('#addBtn').on('click', function(e) {
				//alert("추가 버튼 클릭")

				let name = $('#name').val().trim(); // 이름을 가져와서 공백 제거
				//alert(name);
				if (name == '') {
					alert("이름을 입력해주세요.");
					return;
				}

				let yyyymmdd = $('#yyyymmdd').val().trim();
				if (yyyymmdd < 1) {
					alert("생년월일을 입력해주세요.");
					return;
				}
				
				if(isNaN(yyyymmdd)){ // 모드 숫자가 아닐 때 true
					alert("숫자만 입력해주세요");
					return;
				}
				
				let email = $('#email').val().trim();
				if(email == ''){
					alert("이메일을 입력해주세요");
					return;
				}
				
				let introduce = $('#introduce').val();
				
				
				// 여기까지 오면 서버에 전송 AJAX
				$.ajax({
					// request
					type:"post"	// Request method 메소드의 종류
					, url:"/lesson06/ex01/add_user" // url path
					, data: {"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
					
					//response
					, success: function(data){
						alert(data);
						location.href = "/lesson06/ex01/get_user_view";
					}
					, complete: function(data){
						alert("완료");
					}
					, error: function(e){
						alert("에러, "+ e)
					}
				});
			});
		});
	</script>
</body>
</html>
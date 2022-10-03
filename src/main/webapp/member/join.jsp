<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="../includes/pageURLs.jsp" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Eduport - LMS, Education and Course Theme</title>

	<!-- Meta Tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="author" content="Webestica.com">
	<meta name="description" content="Eduport- LMS, Education and Course Theme">

	<!-- Favicon -->
	<link rel="shortcut icon" href="../assets/images/favicon.ico">

	<!-- Google Font -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;700&family=Roboto:wght@400;500;700&display=swap">

	<!-- Plugins CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/vendor/font-awesome/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/vendor/bootstrap-icons/bootstrap-icons.css">
	<link rel="stylesheet" type="text/css" href="../assets/vendor/choices/css/choices.min.css">

	<!-- Theme CSS -->
	<link id="style-switch" rel="stylesheet" type="text/css" href="../assets/css/style.css">

</head>

<body>

<!-- Header START -->
<header class="navbar-light navbar-sticky">
	<!-- Logo Nav START -->
	<nav class="navbar navbar-expand-lg">
		<div class="container">
			<!-- Logo START -->
			<a class="navbar-brand me-0" href="${homePage }">
				아울러포인트
			</a>
			<!-- Logo END -->

		</div>
	</nav>
	<!-- Logo Nav END -->
</header>
<!-- Header END -->

<!-- **************** MAIN CONTENT START **************** -->
<main>

<!-- =======================
Main part START -->
<section>
	<div class="container">
		<div class="row g-5 justify-content-between">
			<!-- Admission form START -->
			<div class="col-md-8 mx-auto">
				<!-- Title -->
				<h2 class="mb-3">회원가입</h2>
				
				<!-- Form START -->
				<form class="row g-3" >
					<h5 class="mb-0"></h5>



					<!--  id -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">아이디<span class="text-danger">*</span></h6>
								
							</div>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="id" placeholder="아이디는 영어 대소문자, 숫자가 들어간 5자 이상 16자 이하 필수입니다. " name="id">
							</div>
						</div>
					</div>


					<!--  password -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">비밀번호<span class="text-danger">*</span></h6>
							</div>
							<div class="col-lg-8">
								<input type="password" class="form-control" id="pw" placeholder="비밀번호는 영어 대소문자, 숫자가 들어간 5자에서 16자 필수입니다. " name="pw">
							</div>
						</div>
					</div>

						<!--  passwordChk -->
						<div class="col-12">
							<div class="row g-xl-0 align-items-center">
								<div class="col-lg-4">
									<h6 class="mb-lg-0">비밀번호 확인<span class="text-danger">*</span></h6>
								</div>
								<div class="col-lg-8">
									<input type="password" class="form-control" id="pwChk" placeholder="비밀번호 확인" name="pwChk">
								</div>
							</div>
						</div>

					<!--  name -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">이름<span class="text-danger">*</span></h6>
							</div>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="name" placeholder="이름" name="name">
							</div>
						</div>
					</div>

					

					<!-- Gender -->
					
					
					
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">성별 <span class="text-danger">*</span></h6>
							</div>
							<div class="col-lg-8">
								<div class="d-flex">
									<select class="form-select" id="gender" name="gender" >
		                              <option value="남자" >남자</option>
		                              <option value="여자" >여자</option>
		                            </select> 
								</div>
							</div>
						</div>
					</div>

					<!-- Date of birth -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">생년월일 <span class="text-danger">*</span></h6>
							</div>
						
							<div class="col-lg-8">
								<input type="text" class="form-control" id="birthDay" placeholder="19950101   8자로 입력해주세요." name="birthDay">
							</div>
							
							
							
						</div>
					</div>

					<!-- Email -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">이메일 </h6>
							</div>
							<div class="col-lg-8">
								<input type="email" class="form-control" id="email" placeholder="이메일" name="email">
							</div>
						</div>
					</div>

					<!-- Phone number -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">휴대폰 번호</h6>
							</div>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="tel"  placeholder="휴대폰 번호는 010-0000-0000 형식으로 작성하세요." name="tel">
							</div>
						</div>
					</div>

					<!-- Home address -->
					<div class="col-12">
						<div class="row g-xl-0">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">주소 <span class="text-danger"></span></h6>
							</div>
							<div class="col-lg-8">
								<textarea class="form-control" rows="3" name="addr" id="addr" placeholder="주소"></textarea>
							</div>
						</div>
					</div>

					
					

					<!-- Button -->
					<div class="col-12 text-sm-end">
						<button type="submit" class="btn btn-primary mb-0" id="join-btn">회원가입 하기 </button>
					</div>
				</form>
				<!-- Form END -->
			</div>
			<!-- Admission form END -->	
		</div>
	</div>
</section>
<!-- =======================
Main part END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->

 <%@ include file="../includes/footer.jsp" %> 

<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="../assets/vendor/choices/js/choices.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>

<script src="../assets/js/jquery-3.6.0.min.js"></script>

<script>
$("#join-btn").on("click",function(e){
	e.preventDefault();
	
	let id = $("#id").val();
	let pw = $("#pw").val();
	let pwChk = $("#pwChk").val();
	let name = $("#name").val();
	let tel = $("#tel").val();
	let birthDay = $("#birthDay").val();
	let gender = $("#gender").val();
	let addr = $("#addr").val();
	let email = $("#email").val();
	
	
	$.ajax({
		url:"/survey/member/join",
		type:"POST",
		data:"id="+id+"&pw="+pw+"&pwChk="+pwChk+"&name="+name+"&tel="+tel+"&addr="+addr+"&email="+email+"&gender="+gender+"&birthDay="+birthDay,
		success: function(){
			location.href="http://localhost:8083/survey/member/index.jsp";
		},
		error: function(){
			alert("회원 정보에 문제점이 발생했습니다. 올바르게 입력해주세요. ")
		}
	});
	
});


</script>

</body>
</html>
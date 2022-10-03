<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<!-- Theme CSS -->
	<link id="style-switch" rel="stylesheet" type="text/css" href="../assets/css/style.css">

</head>

<body>

<!-- Header START -->
<header class="navbar-light navbar-sticky">
	
	 <div style="margin-top: 20px;">
	 
	 	 <%@ include file="../includes/navigation.jsp" %> 
	 </div>
	


</header>
<!-- Header END -->

<!-- **************** MAIN CONTENT START **************** -->
<main>
	
<!-- =======================
Page Banner START -->
<section class="pt-0">
	<!-- Main banner background image -->
	
	<div class="container mt-n4">
		<div class="row">
			<!-- Profile banner START -->
			<div class="col-12"  style="margin-top: 100px;">
			<div class="card bg-transparent card-body pb-0 px-0 mt-2 mt-sm-0">
					<div class="row d-sm-flex justify-sm-content-between mt-2 mt-md-0">
					
						<!-- Profile info -->
						<div class="col d-md-flex justify-content-between align-items-center mt-4">
							<div>
								<h1 class="my-1 fs-4">${memberInfo.name } 님 환영합니다~ </h1>
								
							</div>
							
						</div>
					</div>
				</div>
				<!-- Profile banner END -->

				<!-- Advanced filter responsive toggler START -->
				<!-- Divider -->
				<hr class="d-xl-none">
				<div class="col-12 col-xl-3 d-flex justify-content-between align-items-center">
					<a class="h6 mb-0 fw-bold d-xl-none" href="#">Menu</a>
					<button class="btn btn-primary d-xl-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
						<i class="fas fa-sliders-h"></i>
					</button>
				</div>
				<!-- Advanced filter responsive toggler END -->
			</div>
		</div>
	</div>
</section>
<!-- =======================
Page Banner END -->

<!-- =======================
Page content START -->
<section class="pt-0">
	<div class="container">
		<div class="row">

			<!-- Left sidebar START -->
			<div class="col-xl-3">
				<!-- Responsive offcanvas body START -->
				<nav class="navbar navbar-light navbar-expand-xl mx-0">
					<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
						<!-- Offcanvas header -->
						<div class="offcanvas-header bg-light">
							<h5 class="offcanvas-title" id="offcanvasNavbarLabel">My profile</h5>
							<button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
						</div>
						<!-- Offcanvas body -->
						<div class="offcanvas-body p-3 p-xl-0">
							<div class="bg-dark border rounded-3 pb-0 p-3 w-100">
								<!-- Dashboard menu -->
								<div class="list-group list-group-dark list-group-borderless">
									<a class="list-group-item " href="#"><i class="bi bi-basket fa-fw me-2"></i>My Courses</a>
									<a class="list-group-item" href="#"><i class="far fa-fw fa-file-alt me-2"></i>1:1 문의 </a>
									<a class="list-group-item active" href="#"><i class="bi bi-pencil-square fa-fw me-2"></i>회원 정보 수정</a>
									<a class="list-group-item" id="delete-btn"><i class="bi bi-trash fa-fw me-2"></i>회원 탈퇴</a>
								</div>
							</div>
						</div>
					</div>
				</nav>
				<!-- Responsive offcanvas body END -->
			</div>
			<!-- Left sidebar END -->

			<!-- Main content START -->
			<div class="col-xl-9">
				<!-- Edit profile START -->
				<div class="card bg-transparent border rounded-3">
					<!-- Card header -->
					<div class="card-header bg-transparent border-bottom">
						<h3 class="card-header-title mb-0">Edit Profile</h3>
					</div>
					<!-- Card body START -->
					<div class="card-body">
						<!-- Form -->
						<form class="row g-4">

							

							<!-- Full name -->
							<div class="col-12">
								<label class="form-label">이름</label>
								<div class="input-group">
									<input type="text" class="form-control" value="${memberInfo.name }" id="name">
								</div>
							</div>



							<!--  id -->
							<div class="col-md-6">
								<label class="form-label">아이디</label>
								<input class="form-control" type="text" value="${memberInfo.id }" disabled="disabled">
							</div>

							<!-- Phone number -->
							<div class="col-md-6">
								<label class="form-label">휴대폰 번호</label>
								<input type="text" class="form-control" value="${memberInfo.tel }" id="tel">
							</div>
							
							<!--email -->
							<div class="col-md-6">
								<label class="form-label">이메일</label>
								<input class="form-control" type="text" value="${memberInfo.email }" id="email">
							</div>

							<!-- Location -->
							<div class="col-md-6">
								<label class="form-label">주소</label>
								<input class="form-control" type="text" value="${memberInfo.addr }" id="addr">
							</div>
							
							<!-- Current password -->
								<div class="mb-3">
									<label class="form-label">현재 비밀번호</label>
									<input class="form-control" type="password"  id="oldPw">
								</div>
								
									<!-- Confirm password -->
								<div>
									<label class="form-label">새로운 비밀번호</label>
									<input class="form-control" type="password" id="newPw">
								</div>
								
									<!-- Confirm password -->
								<div>
									<label class="form-label">새로운 비밀번호 확인</label>
									<input class="form-control" type="password"  id="newPwChk">
								</div>

							

							<!-- Save button -->
							<div class="d-sm-flex justify-content-end">
								<button type="button" class="btn btn-primary mb-0" id="update-btn">정보 수정</button>
							</div>
						</form>
					</div>
					<!-- Card body END -->
				</div>
				<!-- Edit profile END -->
				
				<div class="row g-4 mt-3">
					
					

					

					
				</div>
			</div>
			<!-- Main content END -->
		</div><!-- Row END -->
	</div>
</section>
<!-- =======================
Page content END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- footer  -->
  <%@ include file="../includes/footer.jsp" %> 

<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>

<script src="../assets/js/validator.js"></script>
<script src="../assets/js/jquery-3.6.0.min.js"></script>
  <script>
  
	$("#login-btn").on("click", function(){
  		location.href="http://localhost/survey/member/login.jsp";
  	});
  	$("#join-btn").on("click",function(){
  		location.href="http://localhost/survey/member/join.jsp";
  	});
  	
	$("#logout-btn").on("click", function(){
  		location.href="http://localhost/survey/member/logout";
  	});
  	$("#my-page").on("click",function(){
  		location.href="http://localhost/survey/member/my-page.jsp";
  	});
  	
  	$("#delete-btn").on("click",function(){
  		
  		$.ajax({
  			url:"/survey/member/delete",
  			type:"POST",
  			success: function(){
  				alert("회원 탈퇴가 성공적으로 이뤄졌습니다.")
  				location.href="http://localhost/survey/member/index.jsp"
  			},
  			error: function(){
  				alert("회원 탈퇴에서 오류가 발생했습니다. ")
  			}
  		});
  	});
  	
  	$("#update-btn").on("click",function(){
  		
  		let oldPw = $("#oldPw").val();
  		let newPw = $("#newPw").val();
  		let newPwChk = $("#newPwChk").val();
  		let name = $("#name").val();
  		let tel = $("#tel").val();
  		let email = $("#email").val();
  		let addr = $("#addr").val();
  		
  		// 클라이언트 사용자에게도 validator 해야함 
  		if(oldPw != ""){
  			if(pwValidator(oldPw)){
  				alert("현재 비밀번호를 확인하세요.");
  				return false;
  			} else if(pwValidator(newPw)){
  				alert("새 비밀번호를 확인하세요.");
  				return false;
  			} else if(newPw != newPwChk){
  				alert("새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
  				return false;
  			}
  		}
  		
  		if(nameValidator(name)){
  			alert("이름을 확인하세요 ");
  			return false;
  		} else if(telValidator(tel)){
  			alert("번호를 확인하세요.");
  			return false;
  		} else if(addrValidator(addr)){
  			alert("주소를 확인하세요.");
  			return false;
  		} else if(emailValidator(email)){
  			alert("이메일을 확인하세요.");
  			return false;
  		}
  		
  		$.ajax({
  			url:"/survey/member/update",
  			type:"POST",
  			data:"oldPw="+oldPw+"&newPw="+newPw+"&newPwChk="+newPwChk+"&name="+name+"&tel="+tel+"&email="+email+"&addr="+addr,
  			success: function(){
  				alert("정보를 수정했습니다. ")
  				location.reload();
  			},
  			error: function(){
  				alert(" 현재 사용중인 번호 또는 이메일 입니다. ")
  			}
  			
  		});
  		
  		
  	});
  
  </script>


</body>
</html>
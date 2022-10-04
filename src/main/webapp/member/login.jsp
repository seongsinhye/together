<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<!-- **************** MAIN CONTENT START **************** -->
<main>
	<section class="p-0 d-flex align-items-center position-relative overflow-hidden">
	
		<div class="container-fluid">
			<div class="row">
				<!-- left -->
				<div class="col-12 col-lg-6 d-md-flex align-items-center justify-content-center bg-primary bg-opacity-10 vh-lg-100"  style="height: 100vh !important;">
					<div class="p-3 p-lg-5">
						<!-- Title -->
						<div class="text-center">
							<h2 class="fw-bold">Welcome to our largest community</h2>
							<p class="mb-0 h6 fw-light">Let's learn something new today!</p>
						</div>
						<!-- SVG Image -->
						<img src="../assets/images/element/02.svg" class="mt-5" alt="">
						
					</div>
				</div>

				<!-- Right -->
				<div class="col-12 col-lg-6 m-auto">
					<div class="row my-5">
						<div class="col-sm-10 col-xl-8 m-auto">
							<!-- Title -->
							<h1 class="fs-2">Login</h1>

							<!-- Form START -->
							<form>
								<!-- Email -->
								<div class="mb-4">
									<label for="exampleInputEmail1" class="form-label">아이디 *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-envelope-fill"></i></span>
										<input type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="id" id="id" name="id">
									</div>
								</div>
								<!-- Password -->
								<div class="mb-4">
									<label for="inputPassword5" class="form-label">비밀번호 *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="fas fa-lock"></i></span>
										<input type="password" class="form-control border-0 bg-light rounded-end ps-1" placeholder="password" id="pw" name="pw">
									</div>
									<div id="passwordHelpBlock" class="form-text">
										비밀번호는 영어 대소문자 숫자 포함해서 8자 이상 
									</div>
								</div>
							
								<!-- Button -->
								<div class="align-items-center mt-0">
									<div class="d-grid">
										<button class="btn btn-primary mb-0" type="submit" id="login-btn">로그인</button>
									</div>
								</div>
							</form>
							<!-- Form END -->

							<!-- Social buttons and divider -->
							<div class="row">
								<!-- Divider with text -->
								<div class="position-relative my-4">
									<hr>
									<p class="small position-absolute top-50 start-50 translate-middle bg-body px-5">Or</p>
								</div>

								<!-- Social btn -->
								
								
							
									
										<div>
								    
								
								</div>
									
								
								
							</div>

							<!-- Sign up link -->
							<div class="mt-4 text-center">
								<span>Don't have an account? <a href="join.jsp">회원가입</a></span>
							</div>
						</div>
					</div> <!-- Row END -->
				</div>
			</div> <!-- Row END -->
		</div>
	</section>
</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>
<script src="../assets/js/validator.js"></script>
<script src="../assets/js/jquery-3.6.0.min.js"></script>
<script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
 <script>
 	$("#login-btn").on("click",function(e){
 		
 		e.preventDefault();
 		
 		let id = $("#id").val();
 		let pw = $("#pw").val();
 		
 	 if(idValidator(id)){
 			alert("아이디를 확인하세요. ")
 			return false;
 		} else if(pwValidator(pw)){
 			alert("비밀번호를 확인하세요.")
 			return false;
 		} 
 		
 		
 		$.ajax({
 			url:"/survey/member/login",
 			type:"POST",
 			data:"id="+id+"&pw="+pw,
 			success: function(){
				location.href="http://localhost:8083/survey/member/index.jsp";
 			},
 			error: function(){
 				alert("아이디 또는 비밀번호를 확인하세요.")
 			}
 		});
 		
 	});
 
 
 </script>
 
 
 <script type='text/javascript'>
Kakao.init('5fd59ff369691897793e988071aa41f4');


$("#kakao-login-btn").on("click", function(){
    //1. 로그인 시도
    Kakao.Auth.login({
        success: function(authObj) {
         
          //2. 로그인 성공시, API 호출
          Kakao.API.request({
            url: '/v2/user/me',
            success: function(res) {
              console.log(res);
              var id = res.id;
			  scope : 'account_email';
              
              
              
			alert('로그인성공');
              location.href="http://localhost:8083/survey/member/join";
		

              
        }
          })
          console.log(authObj);
          var token = authObj.access_token;
        },
        fail: function(err) {
          alert(JSON.stringify(err));
        }
      });
        
}) //


</script>

<script>

var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "1B7EH5hyAOzkIkyxx1GB", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
			callbackUrl: "http://localhost/survey/member/index.jsp", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
			isPopup: false,
			callbackHandle: true
		}
	);	

naverLogin.init();

window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
    		
			console.log(naverLogin.user); 
    		
            if( email == undefined || email == null) {
				alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
				naverLogin.reprompt();
				return;
			}
		} else {
			console.log("callback 처리에 실패하였습니다.");
		}
	});
});


var testPopUp;
function openPopUp() {
    testPopUp= window.open("https://nid.naver.com/nidlogin.logout", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,width=1,height=1");
}
function closePopUp(){
    testPopUp.close();
}

function naverLogout() {
	openPopUp();
	setTimeout(function() {
		closePopUp();
		}, 1000);
	
	
}
</script>

</body>
</html>
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
	
	 <div>
	 
	 	 <%@ include file="../includes/navigation.jsp" %> 
	 </div>
	


</header>
<!-- **************** MAIN CONTENT START **************** -->
<main>
<!-- =======================
Page Banner START -->
<section class="bg-light py-5">
	<div class="container">
		<div class="row g-4 g-md-5 position-relative" style="margin-top: 30px;">
			<!-- SVG decoration -->
			<figure class="position-absolute top-0 start-0 d-none d-sm-block">	
				<svg width="22px" height="22px" viewBox="0 0 22 22">
					<polygon class="fill-purple" points="22,8.3 13.7,8.3 13.7,0 8.3,0 8.3,8.3 0,8.3 0,13.7 8.3,13.7 8.3,22 13.7,22 13.7,13.7 22,13.7 "></polygon>
				</svg>
			</figure>

			<!-- Title and Search -->
			<div class="col-lg-10 mx-auto text-center position-relative">
				<!-- SVG decoration -->
				<figure class="position-absolute top-50 end-0 translate-middle-y">
					<svg width="27px" height="27px">
						<path class="fill-orange" d="M13.122,5.946 L17.679,-0.001 L17.404,7.528 L24.661,5.946 L19.683,11.533 L26.244,15.056 L18.891,16.089 L21.686,23.068 L15.400,19.062 L13.122,26.232 L10.843,19.062 L4.557,23.068 L7.352,16.089 L-0.000,15.056 L6.561,11.533 L1.582,5.946 L8.839,7.528 L8.565,-0.001 L13.122,5.946 Z"></path>
					</svg>
				</figure>
				<!-- Title -->
				<h1 class="display-6">자주 묻는 질문 </h1>
				
			</div>

			
		</div>
	</div>
</section>
<!-- =======================
Page Banner END -->

<!-- =======================
Page content START -->
<section class="pt-5 pb-0 pb-lg-5">
	<div class="container">
	
		<div class="row g-4 g-md-5">
			<!-- Main content START -->
			<div class="col-lg-8" style="margin-left: 273px; margin-top:50px;" >
				<!-- Title -->

				<h4>기타 궁금한 사항은 1:1 문의에 남겨주세요 </h4>
				<!-- FAQ START -->
				<div class="accordion accordion-icon accordion-bg-light" id="accordionExample2">
					<!-- Item -->
					<c:forEach items="${faqInfoList }" var="faqInfo">
						
					<!-- Item -->
					<div class="accordion-item mb-3">
						<h6 class="accordion-header font-base" id="heading-2">
							<button class="accordion-button fw-bold rounded d-inline-block collapsed d-block pe-5" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-2" aria-expanded="false" aria-controls="collapse-2">
								${faqInfo.title }
							</button>
						</h6>
						<!-- Body -->
						<div id="collapse-2" class="accordion-collapse collapse" aria-labelledby="heading-2" data-bs-parent="#accordionExample2">
							<div class="accordion-body mt-3">
								${faqInfo.content }
							</div>
						</div>
					</div>
					</c:forEach>
				


				</div>
				<!-- FAQ END -->
			</div>
			<!-- Main content END -->

			
		</div><!-- Row END -->
	</div>
</section>
<!-- =======================
Page content END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- =======================
Footer START -->

<!-- footer  -->
  <%@ include file="../includes/footer.jsp" %> 
					
<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>


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
  
  </script>
</body>
</html>
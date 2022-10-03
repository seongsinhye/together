<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
     <%
     
     
     	int amount = (int) request.getAttribute("amount");
    	if(amount != 0){
    		int  end = (int) Math.ceil(amount / 8.0 );
    		
    		request.setAttribute("end", end);
    	}
     	
     	
     	
     	
     
     %>
     
     
     
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

 <!-- Navigation-->
         <%@ include file="../includes/navigation.jsp" %> 

<!-- **************** MAIN CONTENT START **************** -->
<main>

<%@ include file="../includes/survey-header.jsp" %>

<!-- =======================
Inner part START -->
<section class="pt-4">
	<div class="container">
		<!-- Search option START -->
		<span class="row mb-4 align-items-center" style="display: inline-block; position: absolute; top: 250px; left: 600px; font-size: 19px; margin-top: 15px;">
			<!-- Search bar -->
            <span><a href="#"> 전체 </a></span>
            <span><a href="#"> 진행중 </a></span>
            <span><a href="#"> 종료 </a></span>
        
		</span>
        <hr style="margin-bottom: 50px; margin-top: 50px;">
		<!-- Search option END -->

		<!-- Instructor list START -->
		<div class="row g-4 justify-content-center">

		

				<c:forEach items="${surveyInfoList }" var="surveyInfo"  >

						<!-- Card item START -->
						<div class="col-lg-10 col-xl-6">
							<div class="card shadow p-2">
								<div class="row g-0">
									<!-- Image -->
									<div class="col-md-4">
									<!-- 이미지의 여부에 따라서 사진이 있다면 설정한 이미지가 보이고 이미지가 null 이라면 no-image가 보임 -->
										<c:if test="${not empty surveyInfo.img }">
											<img src="http://localhost:8083/survey/images/survey/${surveyInfo.img }" class="rounded-3" >
										</c:if>
										<c:if test="${empty surveyInfo.img }">
												<img src="http://localhost:8083/survey/images/survey/no-images.webp" class="rounded-3" >
										</c:if>
									</div>
			
									<!-- Card body -->
									<div class="col-md-8">
										<div class="card-body">
											<!-- Title -->
											<div class="d-sm-flex justify-content-sm-between mb-2 mb-sm-3">
												<div>
													<h5 class="card-title mb-0"><a href="http://localhost:8083/survey/survey/detail?page=survey_detail&surveyIdx=${surveyInfo.surveyIdx }">${surveyInfo.surveyTitle } </a></h5>
													<br>
												</div>
												
											</div>
											<!-- Content -->
											<p class="text-truncate-2 mb-3">${surveyInfo.content }</p>
											<!-- Info -->
											<div class="d-sm-flex justify-content-sm-between align-items-center">
												<!-- Title -->
												 
											
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Card item END -->


				</c:forEach>

		</div>
		<!-- Instructor list END -->

		<!-- Pagination START -->
		<nav class="mt-4 d-flex justify-content-center" aria-label="navigation">
			<ul class="pagination pagination-primary-soft d-inline-block d-md-flex rounded mb-0">
			
			<c:forEach begin="1" end="${end }" var="number">
				<li class="page-item mb-0"><a class="page-link" href="http://localhost:8083/survey/survey/list?page=all_survey&pageNumber=${number }">${number }</a></li>
			
			</c:forEach>

			</ul>
		</nav>
		<!-- Pagination END -->

	</div>
</section>
<!-- =======================
Inner part END -->


</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- footer  -->
  <%@ include file="../includes/footer.jsp" %> 

<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="../assets/vendor/choices/js/choices.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>

<script src="../assets/js/functions.js"></script>

<script src="../assets/js/jquery-3.6.0.min.js"></script>
  <script>
	$("#login-btn").on("click", function(){
  		location.href="/survey/member/login.jsp";
  	});
  	$("#join-btn").on("click",function(){
  		location.href="/survey/member/join.jsp";
  	});
  	
	$("#logout-btn").on("click", function(){
  		location.href="/survey/member/logout";
  	});
  	$("#my-page").on("click",function(){
  		location.href="/survey/member/my-page.jsp";
  	});
  	
	$("#admin-page").on("click",function(){
  		location.href="/survey/operate/list";
  	});
  	
  	
 
  
  </script>

</body>
</html>
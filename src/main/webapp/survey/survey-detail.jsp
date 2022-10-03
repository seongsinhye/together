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
	<link rel="stylesheet" type="text/css" href="../assets/vendor/tiny-slider/tiny-slider.css">
	<link rel="stylesheet" type="text/css" href="../assets/vendor/aos/aos.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/stepper/css/bs-stepper.min.css">

	<!-- Theme CSS -->
	<link id="style-switch" rel="stylesheet" type="text/css" href="../assets/css/style.css">

</head>

<body>

<!-- Navigation-->
         <%@ include file="../includes/navigation.jsp" %> 

<!-- **************** MAIN CONTENT START **************** -->
<main>

<!-- =======================
Page content START -->
<section class="pt-5 pb-0">
	<div class="container">
		<div class="row g-0 g-lg-5" style="margin-top: 80px;">

			<!-- Left sidebar START -->
			<div class="col-lg-4">
				<div class="row">
					<div class="col-md-6 col-lg-12">
						<!-- Instructor image START -->
            <div class="card shadow p-2 mb-4 text-center">
              <div class="rounded-3">
                	<c:if test="${not empty surveyInfo.img }">
						<img src="http://localhost:8083/survey/images/survey/${surveyInfo.img }" class="rounded-3" >
					</c:if>
					<c:if test="${empty surveyInfo.img }">
							<img src="http://localhost:8083/survey/images/survey/no-images.webp" class="rounded-3" >
					</c:if>
              </div>
    
              <!-- Card body -->
              
            </div>
						<!-- Instructor image END -->
					</div>

					
				</div> <!-- Row End -->
			</div>
			<!-- Left sidebar END -->
				
			<!-- Main content START -->
			<div class="col-lg-8">
			
				<!-- Title -->
				<h2 class="mb-0">${surveyInfo.surveyTitle }</h2>
				<!-- Content -->
				<p class="mt-4">${surveyInfo.content }</p>
			
				<h4 class="text-orange mb-0">포인트 : ${surveyInfo.point }</h4>
				

				
      </div>
			<!-- Main content END -->

		</div><!-- Row END -->


	</div>
    <div class="col-xl-9" style="/* position: absolute; */ /* top: 300px; */ margin-top: 50px; margin-bottom: 100px; margin-left: 180px;">

        <!-- Course item START -->
        <div class="card border">


                <div class="card-body">
                    <!-- Step content START -->
                   <div class="card bg-transparent border rounded-3 mb-1">
                
		                <!--  질문 1번 시작  -->
		               		<div>
				                  <!-- Title -->
				                <h4 style="margin-left: 30px; margin-top: 15px;">${questionInfo.question1 }</h4>
		  
		                  <hr> <!-- Divider -->
		                 <div class="list-group mx-0">
					   		 <label class="list-group-item d-flex gap-2">
					      <input class="form-check-input flex-shrink-0" type="radio" name="answer1" id="answer1-1" value="0" checked="">
					      <span>
					        만족
					      </span>
					    </label>
					    <label class="list-group-item d-flex gap-2">
					      <input class="form-check-input flex-shrink-0" type="radio" name="answer1" id="answer1-2" value="1">
					      <span>
					       보통
					      </span>
					    </label>
					    <label class="list-group-item d-flex gap-2">
					      <input class="form-check-input flex-shrink-0" type="radio" name="answer1" id="answer1-3" value="2">
					      <span>
					       불만족
					      </span>
					    </label>
					  </div>		
		                  
		               
		                </div>
		                
		                <hr>
		                
		                  <!--  질문 2번 시작  -->
		               		<div>
				                  <!-- Title -->
				                <h4 style="margin-left: 30px; margin-top: 15px;">${questionInfo.question2 }</h4>
		  
		                  <hr> <!-- Divider -->
		                 <div class="list-group mx-0">
						    	<label class="list-group-item d-flex gap-2">
						      <input class="form-check-input flex-shrink-0" type="radio" name="answer2" id="answer2-1" value="0" checked="">
						      <span>
						        만족
						      </span>
						    </label>
						    <label class="list-group-item d-flex gap-2">
						      <input class="form-check-input flex-shrink-0" type="radio" name="answer2" id="answer2-2" value="1">
						      <span>
						       보통
						      </span>
						    </label>
						    <label class="list-group-item d-flex gap-2">
						      <input class="form-check-input flex-shrink-0" type="radio" name="answer2" id="answer2-3" value="2">
						      <span>
						       불만족
						      </span>
						    </label>
						  </div>		
		                  
		                  
		
		               
		                </div>
		                
		                
		                <hr>
		                
		                  <!--  질문 3번 시작  -->
		               		<div>
				                  <!-- Title -->
				                <h4 style="margin-left: 30px; margin-top: 15px;">${questionInfo.question3 }</h4>
		  
		                  <hr> <!-- Divider -->
		                 <div class="list-group mx-0">
						    <label class="list-group-item d-flex gap-2">
						      <input class="form-check-input flex-shrink-0" type="radio" name="answer3" id="answer3-1" value="0" checked="">
						      <span>
						        만족
						      </span>
						    </label>
						    <label class="list-group-item d-flex gap-2">
						      <input class="form-check-input flex-shrink-0" type="radio" name="answer3" id="answer3-2" value="1">
						      <span>
						        보통
						      </span>
						    </label>
						    <label class="list-group-item d-flex gap-2">
						      <input class="form-check-input flex-shrink-0" type="radio" name="answer3" id="answer3-3" value="2">
						      <span>
						        불만족
						      </span>
						    </label>
						  </div>
		
		                  <!-- Step 1 button -->
		                  <div class="d-flex justify-content-center mt-3" style="margin-bottom: 20px;">
		                    <button type="button" class="btn btn-primary next-btn mb-0" id="submit-btn">제출하기</button>
		                  </div>
		               
		                </div>
                
                
                
                
				      </div>		
				     </div>
            
		        </div>
		        <!-- Course item END -->
		
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

<!-- Vendors -->
<script src="../assets/vendor/purecounterjs/dist/purecounter_vanilla.js"></script>
<script src="../assets/vendor/tiny-slider/tiny-slider.js"></script>
<script src="../assets/vendor/aos/aos.js"></script>
<script src="../assets/vendor/stepper/js/bs-stepper.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>

<script src="../assets/js/jquery-3.6.0.min.js"></script>
  <script>
  
  $("#submit-btn").on("click", function(){
	  let surveyIdx = ${param.surveyIdx };
	 
	  let answer1 = $('input[name="answer1"]:checked').val();
	  let answer2 = $('input[name="answer2"]:checked').val();
	  let answer3 = $('input[name="answer3"]:checked').val();
	  
	  $.ajax({
		 url:"/survey/execute",
		 type:"POST",
		 data:"surveyIdx="+surveyIdx+"&answer1="+answer1+"&answer2="+answer2+"&answer3="+answer3,
		 success: function(){
			alert("설문조사 제출에 성공했습니다. ")
		 },
		 error: function(){
			 alert("설문조사 제출에 문제가 발생했습니다. ")
		 }
		  
	  });
	  
	  $.ajax({
			 url:"/survey/get/point",
			 type:"POST",
			 data:"surveyIdx="+surveyIdx,
			 success: function(){
				 
			 },
			 error: function(){
				 alert("포인트 지급에 문제가 발생했습니다.  ")
			 }
			  
		  });
	  
	  
  });
  
  
  
  
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
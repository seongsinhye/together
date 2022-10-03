<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Eduport- LMS, Education and Course Theme</title>

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
	<link rel="stylesheet" type="text/css" href="../assets/vendor/apexcharts/css/apexcharts.css">
	<link rel="stylesheet" type="text/css" href="../assets/vendor/overlay-scrollbar/css/OverlayScrollbars.min.css">

	<!-- Theme CSS -->
	<link id="style-switch" rel="stylesheet" type="text/css" href="../assets/css/style.css">

</head>

<body>


<!-- **************** MAIN CONTENT START **************** -->
<main>
	
<!-- Sidebar START -->
	  <%@ include file="../includes/sideba-nav.jsp" %> 
<!-- Sidebar END -->

<!-- Page content START -->
<div class="page-content">


	<!-- Page main content START -->
	<div class="page-content-wrapper border">

		<!-- Title -->
		<div class="row">
			<div class="col-12 mb-3">
				<h1 class="h3 mb-2 mb-sm-0">작성하기</h1>
			</div>
		</div>

		<form action="/survey/mng/survey/add" method="POST" enctype="multipart/form-data">
			<div>
				<!-- Title -->
				<h4>설문조사 정보 입력하기</h4>

				<hr> <!-- Divider -->

				<!-- Course title -->
				<div class="col-12">
					<label class="form-label">제목</label>
					<input class="form-control" type="text" placeholder="제목은 필수 사항 입니다." name="surveyTitle" >
				</div>


				<!-- Short description -->
				<div class="col-12" style="margin-top: 10px;">
					<label class="form-label">설명</label>
					<p>설문조사의 목적과 취지를 간단하게 작성 바랍니다. </p>
					<input class="form-control" type="text"  name="content" >
					
				</div>

				<!-- Course category -->
				
				<c:choose>
					<c:when test="${surveyInfo.category == '환경' }">
						<c:set var="selected1" value="selected='selected'" />
					</c:when>
					<c:when test="${surveyInfo.category == '경제' }">
						<c:set var="selected2" value="selected='selected'" />
					</c:when>
				</c:choose>
				
				
				<div class="col-md-6" style="margin-top: 20px; margin-bottom: 20px;">
					<label class="form-label">카테고리</label>
					<select class="form-select js-choice  z-index-9 bg-transparent" aria-label=".form-select-sm" data-search-enabled="true" name="category">
						<option selected>선택하세요 </option>
						<option value="환경" >환경</option>
						<option vlaue="경제" >경제</option>
						
					</select>
				</div>

			
			

					<!-- Course point -->
					<div class="col-md-6" style="margin-bottom: 20px;">
						<label class="form-label">포인트</label>
						<input type="text" class="form-control"  name="point" >
					</div>
	
					 <!-- 시작날짜  -->
					 <div class="col-md-6" style="margin-bottom: 20px;">
						<label class="form-label">시작 날짜 </label>
						<input type="text" class="form-control" placeholder="20220808 형식으로 작성해주세요 " name="startDate">
					</div>
	
					<!-- 종료 날짜  -->
					<div class="col-md-6" style="margin-bottom: 20px;" >
						<label class="form-label">종료 날짜</label>
						<input type="text" class="form-control" placeholder="20220808 형식으로 작성해주세요 "  name="endDate" >
					</div>

			</div>
	
			

				<hr>
				
					<c:if test="${not empty surveyInfo.img }">
						<c:set var="style" value="style= 'display: none;'"/>
						<c:set var="imgFileName" value="${surveyInfo.img }"/>
			
					</c:if>
					
					<c:if test="${empty surveyInfo.img }">
						<c:set var="filePathStyle" value="style= 'display: none;'"/>
					</c:if>

				<div class="col-12">
					<div class="text-center justify-content-center align-items-center p-4 p-sm-5 border border-2 border-dashed position-relative rounded-3">
					<!-- Image -->
					<img src="../assets/images/element/gallery.svg" class="h-50px" alt="">
					<div>
						<h6 class="my-2">Upload course image here, or<a href="#!" class="text-primary"> Browse</a></h6>
				
				        <div class="input-group" id="product_file_wrapper">
                           <label class="input-group-text" for="inputGroupFile01">설문조사 이미지 </label>
                            <input type="file" class="form-control" id="inputGroupFile01" name="img" >
                            <span class="product_file_path"  style="padding-top: 8px;"></span>
                            
                        </div>
					
					    <c:if test="${not empty surveyInfo.img }">
                            	<button type="button" class="btn btn-danger btn-lg px-4 me-md-2" id="img_delete_btn">이미지 삭제</button>
                          </c:if>
					</div>	
				</div>
				
		
					</div>
					
					<div class="d-flex justify-content-end mt-3">
						<button type="submit" class="btn btn-primary next-btn mb-0" id="register-btn">설문조사 등록하기 </button>
						<p style="margin-left: 30px; padding-top: 10px;">설문조사 등록 먼저 하고 질문 등록해주세요.</p>
					</div>
			
			
			
				</form>
			
			<hr>
			
			
			<form>
				<input type="hidden" name="surveyIdx" value="${param.surveyIdx }" id="surveyIdx">
				
			<!-- Title -->
				<h4>질문 등록하기 </h4>
				
				<p>질문은 3개로 고정되어 있으며, 답안은 불만족, 보통, 만족 으로 고정되어있습니다. </p> 
				<hr>
				
				
				<div class="col-md-6" style="margin-bottom: 20px;" >
					<label class="form-label">질문 1 제목 </label>
					<input type="text" class="form-control" placeholder="질문을 작성하세요" id="question1">
					
					<label style="margin-top: 20px;">선택 사항 </label>
					<input type="text" id="answer1_1" class="form-control" value="불만족"  disabled="disabled">
					<input type="text"  id="answer1_2" class="form-control" value="보통"  disabled="disabled">
					<input type="text"  id="answer1_3" class="form-control" value="만족"  disabled="disabled">
					
					
					
			
				</div>
				
				<hr>
				<div class="col-md-6" style="margin-bottom: 20px;" >
					<label class="form-label">질문 2 제목 </label>
					<input type="text" class="form-control" placeholder="질문을 작성하세요 " id="question2">
					
					<label style="margin-top: 20px;">선택 사항 </label>
					<input type="text"  id="answer2_1" class="form-control" value="불만족"  disabled="disabled">
					<input type="text"  id="answer2_2" class="form-control" value="보통"  disabled="disabled">
					<input type="text"  id="answer2_3" class="form-control" value="만족"  disabled="disabled">
					
					
					
				</div>
			
				
				<hr>
				
				<div class="col-md-6" style="margin-bottom: 20px;" >
					<label class="form-label">질문 3 제목 </label>
					<input type="text" class="form-control" placeholder="질문을 작성하세요 " id="question3">
					
					<label style="margin-top: 20px;">선택 사항 </label>
					<input type="text"  id="answer3_1" class="form-control" value="불만족"  disabled="disabled">
					<input type="text" id="answer3_2" class="form-control"value="보통"  disabled="disabled">
					<input type="text" id="answer3_3" class="form-control" value="불만족"  disabled="disabled">
					
					
					
				</div>
				
				<hr>
				
				


			<div class="d-flex justify-content-end mt-3">
				<button type="submit" class="btn btn-primary next-btn mb-0" id="question-btn">질문 등록하기 </button>
			</div>


		</form>

		
	</div>
	<!-- Page main content END -->
</div>
<!-- Page content END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="../assets/vendor/purecounterjs/dist/purecounter_vanilla.js"></script>
<script src="../assets/vendor/apexcharts/js/apexcharts.min.js"></script>
<script src="../assets/vendor/overlay-scrollbar/js/OverlayScrollbars.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>
<script src="../assets/js/jquery-3.6.0.min.js"></script>
<script>
	$("#question-btn").on("click",function(e){
		
		e.preventDefault();
		let surveyIdx = $("#surveyIdx").val();
		
		
		let question1 = $("#question1").val();
		let question2 = $("#question2").val();
		let question3 = $("#question3").val();
		
		
		
		$.ajax({
			url:"/survey/mng/survey/question",
			type:"POST",
			data:"surveyIdx="+surveyIdx+"&question1="+question1+"&question2="+question2+"&question3="+question3,
			success: function(){
				alert("설문조사 질문 최종 등록 성공 ");
				location.href="http://localhost:8083/survey/operate/list";
			},
			error: function(){
				alert(" 질문 등록에 문젝가 발생함 ");
			}
		});
		
		

	});
	
	
	
	
	
</script>
</html>
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
	<link rel="stylesheet" type="text/css" href="../assets/vendor/choices/css/choices.min.css">

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

		<div class="row">
			<div class="col-12 mb-3">
				<h1 class="h3 mb-2 mb-sm-0">설문조사 목록</h1>
			</div>
		</div>

		<!-- Card START -->
		<div class="card bg-transparent border">

		

			<!-- Card body START -->
			<div class="card-body">
			
				<!-- Course table START -->
				<div class="table-responsive border-0 rounded-3">
					<!-- Table START -->
					<table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
						<!-- Table head -->
						<thead>
							<tr>
								<th scope="col" class="border-0 rounded-start"  style="padding-left: 30px;">설문조사 제목</th>
								<th scope="col" class="border-0">작성자</th>
								<th scope="col" class="border-0">종료일 </th>
								<th scope="col" class="border-0">포인트</th>
								<th scope="col" class="border-0 rounded-end">편집</th>
							</tr>
						</thead>

						<!-- Table body START -->
						<tbody>
							
							<c:if test="${amount == 0 }" >
							
								<tr>
									<td>
									<div class="d-flex align-items-center position-relative" style="margin-left: 30px;">
										<!-- Title -->
										<h6 class="table-responsive-title mb-0 ms-2"> 현재 설문조사가 없습니다. 
										</h6>
									</div>
									</td>
								
								
								
								</tr>
							</c:if>
							
							
							
							<c:forEach items="${surveyInfoList }" var="surveyInfo">
							
							
								
							<!-- Table row -->
							<tr>
								<!-- Table data -->
								<td>
									<div class="d-flex align-items-center position-relative" style="margin-left: 20px;">
										<!-- Image -->
										<div class="w-60px" >
											<c:if test="${not empty surveyInfo.img }">
												<img src="http://localhost:8083/survey/images/survey/${surveyInfo.img }" class="rounded-3" >
											</c:if>
											<c:if test="${empty surveyInfo.img }">
												<img src="http://localhost:8083/survey/images/survey/no-images.webp" class="rounded-3" >
											</c:if>
										</div>
										<!-- Title -->
										<h6 class="table-responsive-title mb-0 ms-2">	
											<a href="http://localhost:8083/survey/survey/detail?page=survey_detail&surveyIdx=${surveyInfo.surveyIdx }" class="stretched-link">${surveyInfo.surveyTitle }</a>
										</h6>
									</div>
								</td>

								<!-- Table data -->
								<td>
									<div class="d-flex align-items-center">
										<!-- Avatar -->
										
										<!-- Info -->
										<div class="ms-2">
											<h6 class="mb-0 fw-light">관리자</h6>
										</div>
									</div>
								</td>

								<!-- Table data -->
								<td>
									${surveyInfo.endDate }
								</td>

								<!-- Table data -->
								<td>${surveyInfo.point}</td>

								<!-- Table data -->
								<td>
									<a href="/survey/survey/update?surveyIdx=${surveyInfo.surveyIdx }" class="btn btn-sm btn-success me-1 mb-1 mb-md-0" id="update-btn">수정하기 </a>
									<a href="/survey/survey/delete?surveyIdx=${surveyInfo.surveyIdx }" class="btn btn-sm btn-danger me-1 mb-1 mb-md-0" id="delete-btn">삭제하기 </a>
								</td>
							</tr>


							
							</c:forEach>
							
							

						</tbody>
						<!-- Table body END -->
					</table>
					<!-- Table END -->
				</div>
				<!-- Course table END -->
			</div>
			<!-- Card body END -->

			<!-- Card footer START -->
			<div class="card-footer bg-transparent pt-0">
				<!-- Pagination START -->
				<div class="d-sm-flex justify-content-sm-between align-items-sm-center">
					<!-- Content -->
					<!-- Pagination -->
					<nav class="d-flex justify-content-center mb-0" aria-label="navigation" style="margin: 0 auto;">
						<ul class="pagination pagination-sm pagination-primary-soft d-inline-block d-md-flex rounded mb-0">
							<c:forEach begin="1" end="${end }" var="number">
								<li class="page-item mb-0"><a class="page-link" href="http://localhost/survey/operate/list?pageNumber=${number }">${number }</a></li>
			
							</c:forEach>
						</ul>
					</nav>
				</div>
				<!-- Pagination END -->
			</div>
			<!-- Card footer END -->
		</div>
		<!-- Card END -->
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
<script src="../assets/vendor/choices/js/choices.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>
<script src="../assets/js/jquery-3.6.0.min.js"></script>

<script>
	$("#delete-btn").on("click",function(){
		
		
		$.ajax({
			url:"/survey/delete",
			type:"GET",
			data:"surveyIdx="+surveyIdx,
			success: function(){
				
			},
			error: function(){
				alert("설문조사 삭제에 문제가 발생했습니다. ")
			}
		});
		
		
	});
	
	
	$("#update-btn").on("click",function(){
		
		
		$.ajax({
			url:"/survey/survey/survey-detail.jsp",
		
			data:"surveyIdx="+surveyIdx,
			success: function(){
				
			},
			error: function(){
				alert("설문조사 수정에 문제가 발생했습니다. ")
			}
		});
		
		
	});

</script>

</body>
</html>
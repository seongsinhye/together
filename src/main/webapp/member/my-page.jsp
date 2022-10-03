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
	<link rel="stylesheet" type="text/css" href="../assets/vendor/aos/aos.css">

	<!-- Theme CSS -->
	<link id="style-switch" rel="stylesheet" type="text/css" href="../assets/css/style.css">
  
</head>

<body>

<!-- Header START -->
<header class="navbar-light navbar-sticky">
	 <!-- Navigation-->
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
	
	<div class="container mt-n4" >
		<div class="row">
			<div class="col-12" style="margin-top: 100px;">
				<div class="card bg-transparent card-body pb-0 px-0 mt-2 mt-sm-0">
					<div class="row d-sm-flex justify-sm-content-between mt-2 mt-md-0">
					
						<!-- Profile info -->
						<div class="col d-sm-flex justify-content-between align-items-center">
							<div>
								<h1 class="my-1 fs-4">${memberInfo.name } 님 환영합니다~ </h1>
								
							</div>
							
						</div>
					</div>
				</div>

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
						
									<a class="list-group-item active" href="#"><i class="bi bi-basket fa-fw me-2"></i>My Courses</a>
									<a class="list-group-item" href="#"><i class="far fa-fw fa-file-alt me-2"></i>1:1 문의 </a>
									
									<a class="list-group-item" href="http://localhost/survey/member/member-edit-profile.jsp"><i class="bi bi-pencil-square fa-fw me-2"></i>회원 정보 수정</a>
							
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
				<div class="card bg-transparent border rounded-3">
					<!-- Card header START -->
					<div class="card-header bg-transparent border-bottom">
						<h3 class="mb-0" style="color: #40DDDD; font-size: 42px;"> 포인트 : ${memberInfo.point }</h3>
					</div>
					<!-- Card header END -->

					<!-- Card body START -->
					<div class="card-body">

						

						<!-- Course list table START -->
						<div class="table-responsive border-0">
							<table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
								<!-- Table head -->
								<thead>
									<tr>
										<th scope="col" class="border-0 rounded-start">설문조사 이름 </th>
										<th scope="col" class="border-0">포인트</th>
										<th scope="col" class="border-0 rounded-end">참여 날짜 </th>
									</tr>
								</thead>

								<!-- Table body START -->
								<tbody>
								
								
								
								
								<c:forEach items="${surveyJoinInfoList }" var="surveyJoinInfoList">
								
									<!-- Table item -->
									<tr>
										<!-- Table data -->
										<td>
										
										
											<div class="d-flex align-items-center">
												
												<div class="mb-0 ms-2">
													<!-- Title -->
													<h6 class="table-responsive-title"><a href="#">${surveyJoinInfoList.surveyIdx }</a></h6>
													
												</div>
											</div>
										</td>

										<!-- Table data -->
										<td>56</td>

										

										<!-- Table data -->
										<td><br>
                                            
											<p>${surveyJoinInfoList.joinDate }</p>
										</td>
									</tr>
								
								
								</c:forEach>
								
									
								</tbody>
								<!-- Table body END -->
							</table>
						</div>
						<!-- Course list table END -->

						<!-- Pagination START -->
						<div class="d-sm-flex justify-content-sm-between align-items-sm-center mt-4 mt-sm-3">
							<!-- Content -->
							<!-- Pagination -->
							<nav class="d-flex justify-content-center mb-0" aria-label="navigation" style="margin: 0 auto;">
								<ul class="pagination pagination-sm pagination-primary-soft d-inline-block d-md-flex rounded mb-0">
									<c:forEach begin="1" end="${end }" var="number">
												<li class="page-item mb-0"><a class="page-link" href="http://localhost/survey/mypage/list?pageNumber=${number }">${number }</a></li>
			
									</c:forEach>
								</ul>
							</nav>
						</div>
						<!-- Pagination END -->
					</div>
					<!-- Card body START -->
				</div>
			</div>
			<!-- Main content END -->
		</div> <!-- Row END -->
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
<script src="../assets/vendor/choices/js/choices.min.js"></script>
<script src="../assets/vendor/aos/aos.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>


<script src="../assets/js/jquery-3.6.0.min.js"></script>
  <script>
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
  	
	$("#logout-btn").on("click", function(){
  		location.href="http://localhost/survey/member/logout";
  	});
  	$("#my-page").on("click",function(){
  		location.href="http://localhost/survey/member/my-page.jsp";
  	});
 
  
  </script>

</body>
</html>
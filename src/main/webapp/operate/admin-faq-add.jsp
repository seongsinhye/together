<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>


<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
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
				<h2 class="mb-3">FAQ 작성하기</h2>
	
			 <c:set var="action" value="http://localhost:8083/survey/faq/add"/>
			 
         		 <c:if test="${param.page == 'faq_update' }">
                  	<c:set  var="action" value="http://localhost:8083/survey/faq/update?page=faq_update"/>
                  </c:if>
	
			<form class="row g-3" action="${action }" method="POST" >

				<c:if test="${param.page == 'faq_update' }"> 
                    		<input type="hidden" name="faqIdx" value="${faqInfo.faqIdx }">
                   </c:if>

					<!--  id -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0" >제목 : <span class="text-danger"></span></h6>
								
							</div>
							<div class="col-lg-8" style="margin-left: -290px;">
								<input type="text" class="form-control" id="title" placeholder="제목" name="title" value="${faqInfo.title }">
							</div>
						</div>
					</div>




					<!-- Home address -->
					<div class="col-12">
						<div class="row g-xl-0">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">본문 <span class="text-danger"></span></h6>
							</div>
							<div class="col-lg-8" style="margin-left: -290px;">
								<input type="text" class="form-control" id="content" placeholder="본문 내용" name="content" value="${faqInfo.content }">
							</div>
						</div>
					</div>

					<!--  id -->
					<div class="col-12">
						<div class="row g-xl-0 align-items-center">
							<div class="col-lg-4">
								<h6 class="mb-lg-0">등록일<span class="text-danger"></span></h6>
								
							</div>
							<div class="col-lg-8" style="margin-left: -290px;"> 
								 <%= sf.format(nowTime) %>
							</div>
						</div>
					</div>
					

					<!-- Button -->
					<div class="col-12 text-sm-end" style="margin-left: -290px;">
					
						 <c:if test="${param.page == 'faq-add' }">
						 
						 <button type="submit" class="btn btn-primary mb-0" id="join-btn">등록하기</button>
						<button type="button" class="btn btn-success mb-0" id="list-btn">목록으로</button>
                  		</c:if>
					
					
						
					</div>
					
					<div class="col-12 text-sm-end" style="margin-left: -290px;">
						<c:if test="${param.page == 'faq_update' }"> 
                    		<button type="submit" class="btn btn-primary mb-0" id="update-btn">수정하기</button>
                  		 </c:if>
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
<script src="../assets/vendor/choices/js/choices.min.js"></script>
<script src="../assets/vendor/overlay-scrollbar/js/overlayscrollbars.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>
<script src="../assets/js/jquery-3.6.0.min.js"></script>

<script>
	$("#delete-btn").on("click",function(){
		
		let surveyIdx = ${surveyInfo.surveyIdx};
		
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

	
	$("#list-btn").on("click",function(){
		location.href="http://localhost:8083/survey/faq/list"
	});
	
	
	
	$("#faq-update-btn").on("click",function(){
		
		let faqIdx = ${faqInfo.faqIdx};
		let title = $("#title").val();
		let content = $("#content").val();
		
		$.ajax({
			url:"/faq/update",
			type:"POST",
			data:"faqIdx="+faqIdx+"&title="+title+"&content"+content,
			success: function(){
				
			},
			error: function(){
				alert("faq 수정에 문제가 발생했습니다. ")
			}
		});
		
	});
	
	
</script>

</body>
</html>
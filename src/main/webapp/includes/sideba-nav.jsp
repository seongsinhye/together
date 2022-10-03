<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<nav class="navbar sidebar navbar-expand-xl navbar-dark bg-dark">

	<!-- Navbar brand for xl START -->
	<div class="d-flex align-items-center">
		<a class="navbar-brand" href="/survey/member/index.jsp">
			<p>아울러포인트</p>
		</a>
	</div>
	<!-- Navbar brand for xl END -->
	
	<div class="offcanvas offcanvas-start flex-row custom-scrollbar h-100" data-bs-backdrop="true" tabindex="-1" id="offcanvasSidebar">
		<div class="offcanvas-body sidebar-content d-flex flex-column bg-dark">

			<!-- Sidebar menu START -->
			<ul class="navbar-nav flex-column" id="navbar-sidebar">
				
				
				<!-- Title -->
				<li class="nav-item ms-2 my-2">Pages</li>

				
				
				<!-- Menu item 5 -->
				<li class="nav-item"> <a class="nav-link" href="/survey/operate/list">전체 설문조사</a></li>
				
				<!-- Menu item 5 -->
				<li class="nav-item"> <a class="nav-link" href="/survey/operate/admin-survey-add.jsp">설문조사 추가하기</a></li>
				
				<!-- Menu item 5 -->
				<li class="nav-item"> <a class="nav-link" href="#">1:1 문의 내역</a></li>
				
				<li class="nav-item"> <a class="nav-link" href="/survey/faq/list">FAQ</a></li>
				
				
			
		</div>
	</div>
</nav>
</body>
</html>
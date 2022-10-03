<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="pageURLs.jsp" %>


<!-- Header START -->
<header class="navbar-light navbar-sticky navbar-transparent">
	<!-- Logo Nav START -->
	<nav class="navbar navbar-expand-lg">
		<div class="container">
			<!-- Logo START -->
			<a class="navbar-brand me-0" href="${homePage }">
				아울러포인트
			</a>
			<!-- Logo END -->

			

			<!-- Main navbar START -->
			<div class="navbar-collapse collapse" id="navbarCollapse">

				<!-- Nav Search END -->
				<ul class="navbar-nav navbar-nav-scroll ms-auto">
				
					

					<!-- Nav item 2 Course -->
					<li class="nav-item"><a class="nav-link" href="${allSurvey }">설문조사 </a></li>

					<!-- Nav item 3 link-->
					<li class="nav-item"><a class="nav-link" href="${pointPage }">포인트</a></li>

					

					<!-- Nav item 5 Demos -->
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle active" href="#" id="demoMenu" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">고객센터</a>
						<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="demoMenu">
							<li> <a class="dropdown-item" href="${faqPage }">FAQ</a></li>
							<li> <a class="dropdown-item" href="#">1:1 문의</a></li>
							
						</ul>
					</li>
				</ul>
			</div>
			<!-- Main navbar END -->


			<!-- Signin button -->
			  <%-- 로그인을 하지 않았을때 보여라 --%>
	        	<c:if test="${empty memberInfo }">
	        			<div class="navbar-nav ms-2 d-none d-sm-block">
							<a href="${loginPage }"><button class="btn btn-sm btn-warning mb-0" id="login-btn">로그인</button></a> 
						</div>
						<div class="navbar-nav ms-2 d-none d-sm-block">
							<a href="${joinPage }"><button class="btn btn-sm btn-success mb-0" id="join-btn">회원가입</button></a>	
						</div>
	        	</c:if>
	        	
	        	  <%-- 로그인을 했을때 보여라 --%>
	        	<c:if test="${not empty memberInfo && memberInfo.id != 'Admin00'}">
	        			<div class="navbar-nav ms-2 d-none d-sm-block">
						<a href="${logout }"> <button class="btn btn-sm btn-secondary mb-0" id="logout-btn">로그아웃</button></a>	
						</div>
						<div class="navbar-nav ms-2 d-none d-sm-block">
							<a href="${myPage }"><button class="btn btn-sm btn-danger mb-0" id="my-page">마이페이지</button></a>	
						</div>
	        	</c:if>
	        	
	        	<%-- 관리자가 로그인 했을 경우 --%>
				<c:if test="${memberInfo.id == 'Admin00'}">
					<div class="navbar-nav ms-2 d-none d-sm-block">
						<a href="${logout }"><button class="btn btn-sm btn-secondary mb-0" id="logout-btn">로그아웃</button></a>	
						</div>
						<div class="navbar-nav ms-2 d-none d-sm-block">
							<a href="${adminPage }"><button class="btn btn-sm btn-danger mb-0" id="admin-page">관리자 페이지</button></a>	
						</div>
				
				</c:if>

		

		</div>
	</nav>
	<!-- Logo Nav END -->
</header>
<!-- Header END -->



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:set var="header_title" value="모든 설문조사 리스트 " />
    
    <c:choose>
    	<c:when test="${param.page == 'all_survey' }">
    		<c:set var="header_title" value="모든 설문조사 리스트"/>
    	</c:when>
    	<c:when test="${param.page == 'natural' }">
    		<c:set var="header_title" value="환경 설문조사"/>
    	</c:when>
    	<c:when test="${param.page == 'economy' }">
    		<c:set var="header_title" value="경제 설문조사" />
    	</c:when>
    
    </c:choose>
    
    
<!-- =======================
Page Banner START -->
<section class="py-0">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="bg-dark p-4 text-center rounded-3" style="margin-top: 80px;">
					<h1 class="text-white m-0">${header_title }</h1>
					
				</div>
			</div>
		</div>
	</div>
</section>
<!-- =======================
Page Banner END -->
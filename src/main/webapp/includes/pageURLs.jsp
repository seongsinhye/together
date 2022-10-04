<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="homePage" value="/survey/member/index.jsp" />
<c:set var="allSurvey" value="/survey/survey/list?page=all_survey" />
<c:set var="naturalSurvey" value="/survey/survey/list?category=natural&page=natural" />
<c:set var="economySurvey" value="/survey/survey/list?category=economy&page=economy" />
<c:set var="pointPage" value="/survey/etc/pointShop.jsp" />


<c:set var="faqPage" value="/survey/view/faq" />
<c:set var="loginPage" value="/survey/member/login.jsp" />
<c:set var="joinPage" value="/survey/member/join.jsp" />
<c:set var="logout" value="/survey/member/logout" />
<c:set var="myPage" value="/survey/mypage/list?memberIdx=${memberInfo.memberIdx }" />
<c:set var="adminPage" value="/survey/operate/list" />



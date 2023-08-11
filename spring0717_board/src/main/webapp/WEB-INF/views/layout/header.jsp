<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<header>
	 		<div id="nav_up">
	 			<ul>
	 		
	 		   <c:if test="${sessionId == null }">
	 				<li><a href="/member/join01">회원가입</a></li>
	 				<li><a href="/member/login">로그인</a></li>
	 		   
	 		   </c:if>
	 		   <c:if test="${sessionId != null }">
	 				<li>${sessionName}님</li>
	 				<li><a href="/member/memberModify">회원정보수정</a></li>
	 				<li><a href="/member/logout">로그아웃</a></li>
	 		   
	 		   </c:if>
	 		
	 				<li><a href="/board/boardList">고객행복센터</a></li>
	 				<li>배송정보검색</li>
	 				<li>기프트카드 등록</li>
	 			</ul>
	 		</div>
	 		<nav>
	 			<h1></h1>
	 			<ul>
	 				<li>COOKIT소개</li>
	 				<li>COOKIT메뉴</li>
	 				<li>리뷰</li>
	 				<li>이벤트</li>
	 				<li>MY쿡킷</li>
	 			</ul>
	 			<ul>
	 				<li><a href="#"><span>장바구니</span></a></li>
	 				<li><a href="#"><span>메뉴찾기</span></a></li>
	 			</ul>
	 		
	 		</nav>
	 	</header>
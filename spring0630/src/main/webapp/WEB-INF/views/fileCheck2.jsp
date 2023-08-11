<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	  <h2>게시글 등록</h2>
	  <h3>제목 : ${btitle}</h3>
	  <h3>제목 : ${fNames}</h3>
	  <h3>이미지</h3>
	  <c:forEach var="i" items="${splitNames}">
	  <h3>${i}</h3>
	  </c:forEach>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/notice_list.css">
</head>
<body>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="/search" name="search" method="post">
        <select name="category" id="category">
          <option value="0">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
        <div class="title">
          <input type="text" style="display : none">
          <input type="text" size="16">
        </div>
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>
    <table>
      <colgroup>
        <col width="15%">
        <col width="40%">
        <col width="15%">
        <col width="15%">
        <col width="15%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach var = "board" items="${list }">
      <tr>
        <td><span class="table-notice">${board.bno }</span></td>
        <td class="table-title">
        <c:forEach begin="1" end="${board.bindent}" step="1" >
           <img src = "/images/icon_reply.png">
        </c:forEach>
	        <a href="boardView?bno=${board.bno }">${board.btitle}</a>
        </td>
        <td>${board.id }</td>
        <td>${board.bdate }</td>
        
        
        
        <!-- 
         <td>
        	<fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/>
        </td>
         -->
        
        
        
        <td>${board.bhit }</td>
      </tr>
      </c:forEach>
    </table>
    <ul class="page-num">
      <li class="first"></li>
      <li class="prev"></li>
      <c:forEach begin="${startPage}" end="${endPage}" step="1" var="num">
         <li class="num"><div>${num}</div></li>
      </c:forEach>
      <li class="next"></li>
      <li class="last"></li>
    </ul>
    <a href="/board/boardWrite"><div class="write">쓰기</div></a>
  </section>
</body>
</html>












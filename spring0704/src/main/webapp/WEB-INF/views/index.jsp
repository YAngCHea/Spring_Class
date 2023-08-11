<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>공공데이터</title>
<style>
h3 {
	text-align: center;
}

table {
	widows: 1000px;
	magin: 0 auto;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	width: 200px;
	height: 60px;
}

img {
	width: 60px;
}

div {
	width: 350px;
	height: 60px;
	margin: 10px auto;
}

input {
	width: 200px;
	height: 30px;
}

button {
	width: 120px;
	height: 40px;
}
</style>
<script>
		  function ajax_data(){
			  alert("공공데이터를 가져옵니다");
			  
			  $.ajax({
				  url : "/ajax_data",
				  type : "get",
				  dataType : "json",
				  data : {"page" : "1"},
				  success:function(data){
					  alert("성공");
					  console.log(data);
					  
					  
					  let htmlData="";
					  let arr = data.response.body.items.item;  //배열 10개 넘어옴.
					  
					  for(let i in arr){
						  htmlData += " <tr>";
						  htmlData += "<td>"+arr[i].galContentId+"</td>";
						  htmlData += "<td>"+arr[i].galTitle+"</td>";
						  htmlData += "<td>"+arr[i].galPhotographyMonth+"</td>";
						  htmlData += " <td>"+arr[i].galPhotographyLocation+"</td>";
						  htmlData += "<td><img src='"+arr[i].galWebImageUrl+"'></td>";
						  htmlData += " </tr>";
					  }
					  
					 $("#tbody").html(htmlData)
					  
					  
					  
					  
				  },
				  error:function(){
					  alert("실패");
				  }
				  
			  })
		  }//ajax_data   function
		  
		  
		  function search(){
			  alert($("#s_word").val() + " 검색어로 검색을 진행합니다.");
			  
			  $.ajax({
				  url : "/ajax_search",
				  type : "get",
				  dataType : "json",
				  data : {"s_word" : $("#s_word").val()},
				  success:function(data){
					  alert("성공");
					  console.log(data);
					  
					  let htmlData="";
					  let arr = data.response.body.items.item;  //배열 10개 넘어옴.
					  
					  for(let i in arr){
						  htmlData += " <tr>";
						  htmlData += "<td>"+arr[i].galContentId+"</td>";
						  htmlData += "<td>"+arr[i].galTitle+"</td>";
						  htmlData += "<td>"+arr[i].galPhotographyMonth+"</td>";
						  htmlData += " <td>"+arr[i].galPhotographyLocation+"</td>";
						  htmlData += "<td><img src='"+arr[i].galWebImageUrl+"'></td>";
						  htmlData += " </tr>";
					  }

					  $("#tbody").html(htmlData)
					  
					  
				  },
				  error:function(){
					  alert("실패");
				  }
		  })
		  }
		  
		  
		  
		</script>

</head>
<body>
	<h2>메인페이지_json</h2>
	<p></p>
	<button type="button" onclick="ajax_data()">공공데이터 가져오기</button>
	<br>
	<h3>관광정보</h3>
	<div>
		<input type="text" name="s_word" id="s_word">
		<button type="button" onclick="search()">검색</button>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>촬영날짜</th>
			<th>촬영장소</th>
			<th>이미지</th>
		</tr>
		<tbody id="tbody">
			<tr>
				<td colspan="5">데이터를 검색합니다.</td>
			</tr>
		</tbody>
	</table>

</body>
</html>
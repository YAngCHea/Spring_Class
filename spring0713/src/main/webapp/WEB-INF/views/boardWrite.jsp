<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
  
  <!-- include libraries(jQuery, bootstrap) -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
  <!-- include summernote css/js -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
  <script>
      $(function() {
    	  $('#summernote').summernote({
              placeholder: '최대 2048자까지 쓸 수 있습니다.',
              tabsize: 2,
              height: 300,
           	  toolbar: [
           		    // [groupName, [list of button]]
           		    ['fontname', ['fontname']],
           		    ['fontsize', ['fontsize']],
           		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
           		    ['color', ['forecolor','color']],
           		    ['table', ['table']],
           		    ['para', ['ul', 'ol', 'paragraph']],
           		    ['height', ['height']],
           		    ['insert',['picture','link','video']],
           		    ['view', ['fullscreen', 'help']]
           		  ],
           		 fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
           		 fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
   	             callbacks::{
   	            	 onImageUpload : function(files) {
   	            		  uploadSummernoteImageFile(files[0],this); //이미지 업로드 호출
   	            		  },
   	            		  onPaste: function (e) {
   	            		   var clipboardData = e.originalEvent.clipboardData;
   	            		   if (clipboardData && clipboardData.items &&
   	            		   clipboardData.items.length) {
   	            		       var item = clipboardData.items[0];
   	            		if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
   	            		  e.preventDefault();
   	            		       }
   	            		   }
   	            		 }//onImageUpload
   	             }//callbacks
              
            });//summernote
	  });//jQuery
      
      //파일 업로드 함수 - ajax 호출
	  function uploadSummernoteImageFile(file,editor){
		  data = new FormData();    //form태그에서 파일을 가져옴
			data.append("file", file);
			$.ajax({
				data : data,
				type : "POST",
				url : "/uploadSummernoteImageFile",
				contentType : false,  //
				processData : false,
				enctype: 'multipart/form-data',
				success : function(data) {
					console.log(data);
					console.log(data.url);
	            	//항상 업로드된 파일의 url이 있어야 한다.
					$(editor).summernote('insertImage', data);
				}
			});
	  }//uploadSummernoteImageFile
	  
  </script>
  
</head>
<body>
<section>
    <h1>관리자 글쓰기</h1>
    <hr>

    <form action="write.do" name="write" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bName">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="bTitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea id="summernote" name="bContent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='/boardList'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>
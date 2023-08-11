<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="/css/style_main.css">
	    <style>
	      /* 모달창 배치 */
	      #modal {
	            width: 100%;
	            height: 100%;
	            position: absolute;
	            z-index:100;
	            left: 0;
	            top: 0;
	            display: none; /* display: flex; */
	            flex-direction: column;
	            align-items: center; /* 가운데 정렬 */
	            justify-content: center; /* 가운데 정렬 */
	            background: rgba(0, 0, 0, 0.25);
	            backdrop-filter: blur(1.5px);
	            -webkit-backdrop-filter: blur(1.5px);
	        }
	        #modal .modal-window {
	            background: rgba( 69, 139, 197, 0.70 );
	            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
	            border-radius: 10px;
	            border: 1px solid rgba( 255, 255, 255, 0.18 );
	            width: 400px;
	            height: 500px;
	            position: relative;
	            top: 50px;
	            padding: 10px;
	        }
	        #modal .title {
	            padding-left: 10px;
	            display: inline;
	            text-shadow: 1px 1px 2px gray;
	            color: white;
	        }
	        #modal .title h2 {
	            display: inline;
	        }
	        #modal .close-area {
	            display: inline;
	            float: right;
	            padding-right: 10px;
	            cursor: pointer;
	            text-shadow: 1px 1px 2px gray;
	            color: white;
	        }
	        #modal .content {
	            margin-top: 20px;
	            padding: 0px 10px;
	            text-shadow: 1px 1px 2px gray;
	            color: white;
	        }
	      /* 모달창 배치 끝 */
	    </style>
	    <script>
	       //모달창 닫기버튼
	       function closeBtn(){
	    	   //alert("test");
	    	   $("#modal").css({"display":"none"});
	       }
	       
	       if("${resultCode}"=="s_login"){ alert("로그인 하였습니다.!!"); }
	       if("${resultCode}"=="s_logout"){ alert("로그아웃 되었습니다.!!"); }
	    </script>
	</head>
	<body>
	     <!-- 모달창 -->
         <div id="modal" class="modal-overlay">
	        <div class="modal-window">
	            <div class="title">
	                <h2>모달</h2>
	            </div>
	            <div onclick="closeBtn()" class="close-area">X</div>
	            <div class="content">
	                <p>가나다라마바사 아자차카타파하</p>
	                <p>가나다라마바사 아자차카타파하</p>
	                <p>가나다라마바사 아자차카타파하</p>
	                <p>가나다라마바사 아자차카타파하</p>
	                
	            </div>
	        </div>
	    </div>
	    <!-- 모달창 끝 -->
	 	
	 	<%@ include file="layout/header.jsp" %>
	 	
	 	<section>
	 		<div id="top_img">
	 			<div>
	 				<a href="#">
		 				<span>NEW</span>
		 				<span>3/16 신메뉴 출시</span>
		 				<span>따끈한 소울푸드<br>황태콩나물 해장국</span>
			 			<span><span></span>3인분</span>
			 			<span><span></span>조리 15분</span>
	 				</a>
	 				<span>16,800원 <a href="#"></a></span>
	 				<div>
	 					<a href="#"></a>
			 			<span>1/5</span>
			 			<a href="#"></a>
	 				</div>
	 			</div>
	 		</div>
	 		<div id="recomend">
	 			<div>
	 				<div>
		 				<span>얼큰한맛 <a href="#">▼</a></span>
		 				<span>메뉴<br>추천드려요</span>
		 				<span><a href="#">로그인</a>하시면 고객님의 구매내역과<br> 맛취향에 따라 딱맞는 맛있는 메뉴를 추천드려요</span>
		 			</div>
		 			<div></div>
		 			<img alt="우거지탕" src="images/recomand_tang.png">
		 			<div>
		 				<a href="#">얼큰소고기우거지탕</a>
		 				<div>
			 				<span>18,800원</span>
			 				<span>/3인분<a href="#"></a></span>
		 				</div>
	 				</div>
	 			</div>
	 		</div>
	 		<a href="#" id="event_banner"></a>
	 		<div id="best">
	 			<h2>실시간 베스트</h2>
	 			<ul>
	 				<li>
	 					<a href="#">
		 					<img alt="참스테이크" src="images/best01.jpg">
		 					<span id="best_top">BEST<br>01</span>
	 					</a>
	 					<a href="#">
		 					<span>부채살 찹스테이크</span>
		 					<span>
		 						20,800원
		 						<span>/2인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				  </li>
	 				<li>
	 					<a href="#">
		 					<img alt="감바스 알아히오" src="images/best02.jpg">
		 					<span>02</span>
	 					</a>
	 					<a href="#">
		 					<span>감바스 알아히오</span>
		 					<span>
		 						20,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="소고기 두부전골" src="images/best03.jpg">
		 					<span>03</span>
	 					</a>
	 					<a href="#">
		 					<span>소고기 두부전골</span>
		 					<span>
		 						24,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="스키야키" src="images/best04.jpg">
		 					<span>04</span>
	 					</a>
	 					<a href="#">
		 					<span>스키야키</span>
		 					<span>
		 						24,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="빠네크림 파스타" src="images/best05.jpg">
		 					<span>05</span>
	 					</a>
	 					<a href="#">
		 					<span>빠네크림 파스타</span>
		 					<span>
		 						20,800원
		 						<span>/2인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 				<li>
	 					<a href="#">
		 					<img alt="부추가득 오리불고기" src="images/best06.jpg">
		 					<span>06</span>
	 					</a>
	 					<a href="#">
		 					<span>부추가득 오리불고기</span>
		 					<span>
		 						24,800원
		 						<span>/3인분</span>
		 					</span>
	 					</a>
	 					<a href="#"></a>
	 				</li>
	 			</ul>
	 		</div>
	 		<script>
	 		   function boardBtn(){     //여기서 function 만 빼면 페이지가 넘어가면서 바로 돌아간다!!!!!!!!!!!
	 			   alert("글을 변경합니다.");
	 			   //ajax : 화면이 변경되지 않으면서, Controller에서 데이터를 가져올 수 있는 비동기식 방법
	 			   $.ajax({
	 				   url : "/board/reviewAjax",
	 				   type:"post",
	 				   data:{"bno" : "62"}, //여러개면 이렇게 중괄호로 묶고, 하나면 그냥 쓰면된다
	 				   dataType : "json",
	 				   success:function(data){
	 					   //게시글 1개 가져오기
	 					   /* console.log("data : "+data);
	 					   console.log("data : "+data.bcontent);
	 					   console.log("data : "+data.bfiles[0]);
	 					   alert("controller에서 데이터 받기 성공");
	 					   var src = '/upload/'+data.bfiles[0];
	 					   //받은 데이터를 html에 넣음.
	 					   
	 					   $(".review_ajax1").text(data.btitle);   //.text : 텍스트를 변경할꺼라서 text다!!
	 					   $(".review_ajax2").html(data.bcontent);   //.html : <br>태그가 있어서 html로 받는다! 문자가 아니고 태그로 받아야해서!!
	 					   $(".review_ajax3").prop("src",src);   //이미지 url을 찾아야해서 src를 넣는다  //{}여러개 있을때는 :이고, ()일때는 ,로 연결한다 */
	 					   
	 					   //게시글 여러개 가져오기----------------------------------------------------------------------------
	 					   console.log("data : "+data);
	 					   console.log("data[0] : "+data.bcontent);
	 					   //console.log("data[0] : "+data.bfiles[0]);
	 					   
	 					   alert("controller에서 데이터 받기 성공");
	 					   //받은 데이터를 html에 넣음.
	 					   
	 					   var arrSrc = data[0].bfile.split(",");   //자바스크립트에 split 함수 사용
	 					   console.log(arrSrc[0]);
	 					   var src = '/upload/'+arrSrc[0];
	 					   
	 					   $(".review_ajax1").text(data[0].btitle);   //.text : 텍스트를 변경할꺼라서 text다!!
	 					   $(".review_ajax2").html(data[0].bcontent);   //.html : <br>태그가 있어서 html로 받는다! 문자가 아니고 태그로 받아야해서!!
	 					   $(".review_ajax3").prop("src",src);   //이미지 url을 찾아야해서 src를 넣는다  //{}여러개 있을때는 :이고, ()일때는 ,로 연결한다
	 					   
	 					   
	 				   },
	 				   error:function(){
	 					   alert("데이터 받기 실패!");
	 				   }
	 				   
	 			   });//ajax
	 			   
	 		   }
	 		</script>
	 		<div id="review">
	 			<h2 class="review_ajax1">생생한 리뷰</h2>
	 			<div>
	 				<span></span>
	 				<span>속초식 코다리찜</span>
	 				<span class="review_ajax2">
						재료가 워낙 좋으니 생선이라도 비린내 걱정
						<br>없이 맛있었어요.나가서 사먹는것보다
						<br>내 집에서 믿고먹는 맛집, 쿡킷입니다!
					</span>
					<span></span>
	 				<span>by.for********</span>
	 				<div>
	 					<a href="#"></a>
			 			<span>1/5</span>
			 			<a onclick="boardBtn()" style="cursor: pointer;"></a>
	 				</div>
	 			</div>
	 			<img class="review_ajax3" alt="코다리찜1" src="images/review01.jpg">
	 			<img alt="코다리찜2" src="images/review02.png">
	 			<span></span>
	 		</div>
			<div id="menu">
				<div>
					<img alt="메뉴상단01" src="images/menu_top01.jpg">
					<h2>쿡킷 메뉴보기<br>
					Premium Mealkit</h2>
					<span>
					장보기, 재료손질, 레시피검색 <strong>번거로움 OUT!</strong><br>
					초간편함은 물론, 완벽한 맛 쿡킷이 다~ 했네
					</span>
					<ul>
						<li>
							<a href="#">
								<span>
									<img alt="황태콩나물해장국" src="images/menu01.png">
								</span>
								<span>황태콩나물해장국</span>
								<span>16,800원<span>/3인분</span></span>
								<span class="new_menu">NEW</span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="군산식 아귀찜" src="images/menu02.png">
								</span>
								<span>군산식 아귀찜</span>
								<span>29,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="해물짬뽕전골" src="images/menu03.png">
								</span>
								<span>해물짬뽕전골</span>
								<span>22,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="스키야키" src="images/menu04.png">
								</span>
								<span>스키야키</span>
								<span>24,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="우삼겹쌀국수" src="images/menu05.png">
								</span>
								<span>우삼겹쌀국수</span>
								<span>24,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="빠네크림파스타" src="images/menu06.png">
								</span>
								<span>빠네크림파스타</span>
								<span>20,800원<span>/2인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="감바스알아히요" src="images/menu07.png">
								</span>
								<span>감바스알아히요</span>
								<span>20,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="대만식 우육탕면" src="images/menu08.png">
								</span>
								<span>대만식 우육탕면</span>
								<span>23,800원<span>/2인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="얼큰소고기우거지탕" src="images/menu09.png">
								</span>
								<span>얼큰소고기우거지탕</span>
								<span>18,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="두툼 갈치조림" src="images/menu10.png">
								</span>
								<span>두툼 갈치조림</span>
								<span>17,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="부추가득 오리불고기" src="images/menu11.png">
								</span>
								<span>부추가득 오리불고기</span>
								<span>24,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="버섯소불고기" src="images/menu12.png">
								</span>
								<span>버섯소불고기</span>
								<span>23,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="속초식 코다리찜" src="images/menu13.png">
								</span>
								<span>속초식 코다리찜</span>
								<span>24,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="사천식 깐풍새우" src="images/menu14.png">
								</span>
								<span>사천식 깐풍새우</span>
								<span>25,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="애호박돼지고기짜글이" src="images/menu15.png">
								</span>
								<span>애호박돼지고기짜글이</span>
								<span>22,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="칠리&크림 반반새우" src="images/menu16.png">
								</span>
								<span>칠리&크림 반반새우</span>
								<span>26,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="쿵팟퐁커리" src="images/menu17.png">
								</span>
								<span>쿵팟퐁커리</span>
								<span>20,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="소고기두부전골" src="images/menu18.png">
								</span>
								<span>소고기두부전골</span>
								<span>24,800원<span>/3인분</span></span>
							</a>
							<a href="#"></a>
						</li>
						<li>
							<a href="#">
								<span>
									<img alt="부채살 찹스테이크" src="images/menu19.png">
								</span>
								<span>부채살 찹스테이크</span>
								<span>20,800원<span>/2인분</span></span>
							</a>
							<a href="#"></a>
						</li>
					</ul>
				</div>
				<div>
					<img alt="핫딜" src="images/menu_hotdeal.jpg">
					<h2>놓칠 수 없는 기회 <br>
					오픈 한정 핫딜</h2>
					<span>파격적인 가격으로<br>
					쿡킷을 경험할 수 있는 기회를 잡으세요.</span>
					<a href="#">
						<img alt="쿡킷소개" src="images/menu_cj_intro.jpg">
						<h2>프리미엄 밀키트<br>
						COOKIT을 소개합니다.</h2>
						<span>COOKIT은 장보기, 재료손질, 계량 등 복잡한 과정 없이도<br>
						누구나 간편하게 특별한 집밥을 만들 수 있도록 도와드립니다.</span>
					</a>
				</div>
			</div>
			<div id="main_notice">
				<a href="#">
					<dl>
						<dt>공지사항</dt>
						<dd>미리보는 쿡킷 전체 메뉴 (3月)</dd>
					</dl>
				</a>
			</div>	 		
	 	</section>
	 	<!-- footer -->
		<%@ include file="layout/footer.jsp" %>
		
	</body>
</html>
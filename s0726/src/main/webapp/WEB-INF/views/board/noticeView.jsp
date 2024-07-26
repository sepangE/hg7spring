<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN SHOP" />
<meta name="keywords" content="JARDIN SHOP" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/top_navi.js"></script>
<script type="text/javascript" src="../js/left_navi.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper-2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.anchor.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!--[if lt IE 9]>
<script type="text/javascript" src="../js/html5.js"></script>
<script type="text/javascript" src="../js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
$(document).ready(function() {
	


});
</script>
</head>
<body>



<!--익스레이어팝업-->
<div id="ieUser" style="display:none">
	<div class="iewrap">	
		<p class="img"><img src="../images/ico/ico_alert.gif" alt="알림" /></p>
		<p class="txt">IE버전이 낮아 홈페이지 이용에 불편함이 있으므로 <strong>IE9이상이나 다른 브라우저</strong>를 이용해 주세요. </p>
		<ul>
			<li><a href="http://windows.microsoft.com/ko-kr/internet-explorer/download-ie" target="_blank"><img src="../images/ico/ico_ie.gif" alt="IE 최신브라우저 다운" ></a></li>
			<li><a href="https://www.google.com/intl/ko/chrome/browser" target="_blank"><img src="../images/ico/ico_chrome.gif" alt="IE 최신브라우저 다운" ></a></li>
			<li><a href="http://www.mozilla.org/ko/firefox/new" target="_blank"><img src="../images/ico/ico_mozila.gif" alt="MOZILA 최신브라우저 다운" ></a></li>
			<li><a href="http://www.apple.com/safari" target="_blank"><img src="../images/ico/ico_safari.gif" alt="SAFARI 최신브라우저 다운" ></a></li>
			<li><a href="http://www.opera.com/ko/o/ie-simple" target="_blank"><img src="../images/ico/ico_opera.gif" alt="OPERA 최신브라우저 다운" ></a></li>		
		</ul>
		<p class="btn" onclick="msiehide();"><img src="../images/ico/ico_close.gif" alt="닫기" /></p>
	</div>
</div>
<!--//익스레이어팝업-->
<!--IE 6,7,8 사용자에게 브라우저 업데이터 설명 Div 관련 스크립트-->
 <script type="text/javascript">

     var settimediv = 200000; //지속시간(1000= 1초)
     var msietimer;

     $(document).ready(function () {
         msiecheck();
     });

     var msiecheck = function () {
         var browser = navigator.userAgent.toLowerCase();
         if (browser.indexOf('msie 6') != -1 ||
                browser.indexOf('msie 7') != -1 ||
				 browser.indexOf('msie 8') != -1) {
             msieshow();			 
         }
         else {
             msiehide();
         }
     }

     var msieshow = function () {
        $("#ieUser").show();
        msietimer = setTimeout("msiehide()", settimediv);
     }

     var msiehide = function () {
		$("#ieUser").hide();
        clearTimeout(msietimer);
     }
</script>

<div id="allwrap">
<div id="wrap">

	<%@ include file="../top.jsp" %>

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">CUSTOMER</a></li>
				<li class="last">NOTICE</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">CUSTOMER<span>고객센터</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">NOTICE</a></li>
					<li><a href="#" id="leftNavi2">1:1문의</a></li>
					<li><a href="#" id="leftNavi3">FAQ</span></a></li>
					<li class="last"><a href="#" id="leftNavi4">이용안내</a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="customer">
					<h2><strong>NOTICE</strong><span>쟈뎅샵 소식을 전해드립니다.</span></h2>

					<div class="viewDivMt">
						<div class="viewHead">
							<div class="subject">
								<ul>
									<li>${board.btitle }.</li>
								</ul>
							</div>
							<div class="day">
								<p class="txt">작성자<span>${board.id}</span></p>
								<p class="txt">작성일<span><fmt:formatDate value ="${board.bdate}" pattern="yyyy-MM-dd"/></span></p>
								<p class="txt">조회수<span>${board.bhit }</span></p>
							</div>
						</div>

						<div class="viewContents">
							${board.bcontent}
							<img src="/images/${board.bfile }" alt="" />
						</div>
					</div>


					<!-- 이전다음글 -->
					<div class="pnDiv web">
						<table summary="이전다음글을 선택하여 보실 수 있습니다." class="preNext" border="1" cellspacing="0">
							<caption>이전다음글</caption>
							<colgroup>
							<col width="100px" />
							<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th class="pre">PREV</th>
									
									<td><a href="/board/noticeView?bno=${prev.bno}&page=${page}&category=${category}&sWord=${sWord}">${prev.btitle}</a></td>
									
								</tr>

								<tr>
									<th class="next">NEXT</th>
									<td><a href="/board/noticeView?bno=${next.bno}&page=${page}&category=${category}&sWord=${sWord}">${next.btitle}</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- //이전다음글 -->
		
		<script type="text/javascript">
			function insReplyBtn(){
			//	alert("insReplyBtn()");
			//	alert("replyType : "+$(".replyType").val());
			//	alert("replynum : "+$(".replynum").val());
			 $.ajax({
				url : "/board/insertReply",
				method : "post",
				data : {"cpw" : $(".replynum").val(),
						"ccontent" :  $(".replyType").val(),
						"bno" : "${board.bno}",
						"id" : "${sessionId}"},
				success : function(data){
					alert("성공");
					console.log(data);
				 	let str = '';
					str+='<ul id="'+data.cno+'">';
					str+='<li class="name">'+data.id+'<span>['+data.cdate+']</span></li>';
					str+='<li class="txt">'+data.ccontent+'</li>';
					str+='<li class="btn">';
					str+='<a onclick="modiBtn('+data.cno+',\''+data.id+'\',\''+data.cdate+'\',\''+data.ccontent+'\')" class="rebtn">수정</a>';
					str+='<a onclick="delBtn('+data.cno+')" class="rebtn">삭제</a>';
					str+='</li>';
					str+='</ul>';
					$(".replyBox").append(str); 
					
					$(".replyType").val("");
					$(".replynum").val("");
				},
				error : function(){
					alert("실패");
				}
			})//ajax 
			} // insReplyBtn
			
			function delBtn(cno){
			//	alert(cno);
				$.ajax({
					url : "/board/delReply",
					method : "post",
					data : {"cno" : cno},
					success : function(data){
						alert("성공");
						console.log(data);
						$("#"+cno).remove(); 
					},
					error : function(){
						alert("실패");
					}
				}) // ajax
			} // delBtn
			
			function modiBtn(cno,id,cdate,ccontent){
				alert("");
				//alert(id);
				//alert(cdate);
				//alert(ccontent);
					 if(confirm("댓글 수정하기")){
					let str = '';
					str += '<ul>';
					str += '<li class="name">'+id+'<span>['+cdate+']</span>';
					str += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 비밀번호&nbsp;&nbsp;';
					str += '<input type="password" class="replynum" id="updatePw" />';
					str += '</li>';
					str += '<li class="txt"><textarea id="updateContent" class="replyType">'+ccontent+'</textarea></li>';
					str += '<li class="btn">';
					str += '<a onclick="udateSave('+cno+')" class="rebtn">저장</a>&nbsp;&nbsp;';
					str += '<a onclick="cancelBtn('+cno+',\''+id+'\',\''+cdate+'\',\''+ccontent+'\')" class="rebtn">취소</a>';
					str += '</li>';
					str += '</ul>';
					$("#"+cno).html(str);
				}  
			}// modiBtn
			
			function cancelBtn(cno,id,cdate,ccontent){
			//	alert("취소")
				console.log(cno);
				console.log(id);
				console.log(cdate);
				console.log(ccontent);
				
				var str='';
				str+='<li class="name">'+id+'<span>['+cdate+']</span></li>';
				str+='<li class="txt">'+ccontent+'</li>';
				str+='<li class="btn">';
				str+='<a onclick="modiBtn('+cno+',\''+id+'\',\''+cdate+'\',\''+ccontent+'\')" class="rebtn">수정</a>';
				str+='<a onclick="delBtn('+cno+')" class="rebtn">삭제</a>';
				str+='</li>';
				$("#"+cno).html(str);
			} // cancelBtn
			
			function udateSave(cno){
			//	alert("수정 저장하기")
				console.log($("#updateContent").val());
				console.log($("#updatePw").val());
				if(confirm("저장하시겠습니까?")){
					$.ajax({
						url : "/board/modiComm",
						method : "post",
						data : {"cno" : cno,
								"cpw" : $("#updatePw").val(),
								"ccontent" : $("#updateContent").val()},
						success : function(data){
							alert("성공");
							console.log(data);
							let str = '';
							str+='<li class="name">'+data.id+'<span>['+data.cdate+']</span></li>';
							str+='<li class="txt">'+data.ccontent+'</li>';
							str+='<li class="btn">';
							str+='<a onclick="modiBtn('+data.cno+',\''+data.id+'\',\''+data.cdate+'\',\''+data.ccontent+'\')" class="rebtn">수정</a>';
							str+='<a onclick="delBtn('+data.cno+')" class="rebtn">삭제</a>';
							str+='</li>';
							$("#"+cno).html(str);
						},
						error : function(){
							alert("실패");
						}
					})// ajax 
				} // confrim
			}
		</script>
		
						
					<!-- 댓글-->
					<div class="replyWrite">
						<ul>
							<li class="in">
								<p class="txt">총 <span class="orange">3</span> 개의 댓글이 달려있습니다.</p>
								<p class="password">비밀번호&nbsp;&nbsp;<input type="password" class="replynum" /></p>
								<textarea class="replyType"></textarea>
							</li>
							<li class="btn"><a onclick="insReplyBtn()" class="replyBtn">등록</a></li>
						</ul>
						<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
					</div>
					<div class="replyBox">
						<c:forEach var="list" items="${clist}">
						<ul id = "${list.cno}">
							<li class="name">${list.id} <span>[${list.cdate}]</span></li>
						<c:if test="${list.cpw!=null && sessionId !=list.id}">
							<li class="txt"><span class="orange">※ 비밀글입니다.</span></li>
						</c:if>
						<c:if test="${!(list.cpw!=null && sessionId !=list.id)}">
							<li class="txt">${list.ccontent }</li>
						</c:if>
						<c:if test="${sessionId==list.id }">
							<li class="btn">
								<a onclick="modiBtn(${list.cno},'${list.id}','${list.cdate}','${list.ccontent}')" class="rebtn">수정</a>
								<a onclick="delBtn(${list.cno})" class="rebtn">삭제</a>
							</li>
						</c:if>
						</ul>
						</c:forEach>
					</div>
					<!-- //댓글 -->

					<!-- Btn Area -->
					<div class="btnArea btline">
						<div class="bRight">
							<ul>
								<li><a href="/board/notice?page${page}&category=${category}&sWord=${sWord}" class="sbtnMini mw">목록</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->
					
				
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->

	<%@ include file="../foot.jsp" %>


</div>
</div>
</body>
</html>
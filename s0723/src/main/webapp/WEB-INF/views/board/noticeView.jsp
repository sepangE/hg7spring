<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

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





<div id="allwrap">
<div id="wrap">

	<%@ include file="../top.jsp" %>

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">EVENT</a></li>
				<li class="last">진행중 이벤트</li>
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
				<div id="mypage">
					<h2><strong>NOTICE</strong><span>쟈뎅샵의 특별한 혜택이 가득한 이벤트에 참여해 보세요.</span></h2>
					
					<div class="viewDivMt">
						<div class="viewHead">
							<div class="subject">
								<ul>
									<li>${board.btitle }</li>
								</ul>
							</div>
							<div class="day">
								<p class="txt">작성자<span>${board.id }</span></p>
								<p class="txt">작성일<span><fmt:formatDate value="${board.bdate }" pattern="yyyy-MM-dd"/></span></p>
								<p class="txt">조회수<span>${board.bhit }</span></p>
							</div>
						</div>

						<div class="viewContents">
							${board.bcontent }
							<img src="/images/${board.bfile}" alt="" />
						</div>
					</div>


					<!-- 이전다음글 -->
					<div class="pnDiv web">
						<table summary="이전다음글을 선택하여 보실 수 있습니다." class="preNext" border="1" cellspacing="0">
							<caption>이전다음글</caption>
							<colgroup>
							<col width="100px" />
							<col width="*" />
							<col width="100px" />
							</colgroup>
							<tbody>
								<tr>
									<th class="pre">PREV</th>
									<td><a href="noticeView?bno=${prev.bno}&category=${category}&sWord=${sWord}">${prev.btitle }</a></td>
									<td>&nbsp;</td>
								</tr>

								<tr>
									<th class="next">NEXT</th>
									<td><a href="noticeView?bno=${next.bno}&category=${category}&sWord=${sWord}
									+">${next.btitle}</a></td>
									<td>&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- //이전다음글 -->

	<script>
	function commentBtn(){
	//	alert("commentBtn");
	let ccontent = $(".replyType").val();
	let cpw = $(".replynum").val();
	let id = "${sessionId}";
	let bno = "${board.bno}";
	// 로그인 안하면 글 못씀
	if(id==""){
		alert("로그인 안하면 댓글 못씀");
		location.href="/member/login";
	} // if
	$.ajax({
		url : "/board/commentInsert",
		method: "post",
		data : {"id":id, "cpw":cpw, "ccontent":ccontent, "bno":bno},
		success: function(data){
			let str='';
			str += '<ul id='+data.cno+'>';
			str += '<li class="name">'+data.id+'<span>['+data.cdate+']</span></li>';
			str += '<li class="txt">'+data.ccontent+'</li>';
			str += '<li class="btn">';
			str += '<a onclick="cModiBtn('+cno+',\''+id+'\',\''+cdate+'\',\''+ccontent+'\')" class="rebtn">수정</a>';
			str += '<a onclick="delBtn('+cno+')" class="rebtn">삭제</a>';
			str += '</li>';
			str += '</ul>';
			$(".replyBox").prepend(str);
			
			var n =$("#comNum").text();
			console.log(n); // 기존 댓글의 수
			console.log(typeof(n)); // 문자열임
			// javascript에서 문자를 숫자로 Number()
			var commentNum = Number(n)+1;
			$("#comNum").text(Number(n)+1);
			$(".replyType").val("");
			$(".replyNum").val("");
		},
		error : function(){
			alert("실패");
		}
	});// ajax
	
	}// commentBtn
//========	
	function delBtn(cno){
		if(confirm("댓글을 삭제하시겠습니까?")){
			alert("삭제 : "+cno);
			$.ajax({
				url : "/board/delComment",
				method : "post",
				data : {"cno" : cno},
			success: function(data){
				alert("성공");
				console.log(data);
				
				$("#"+cno).remove(); // html에서 제거하기
				
				// 총 댓글 수 수정
				var commentNum = Number($("#comNum").text())-1;
				$("#comNum").text(commentNum);
			},
			error : function() {
				alert("실패");
			}
			})// ajax
		}// if - fonfirm
	}//delBtn
	
	function cModiBtn(cno,id,cdate,ccontent){
		
		if(confirm("댓글을 수정하시겠습니까?")){
		//	alert(cno);	alert(id);	alert(cdate);	alert(ccontent);
		
			let str = '';
			str += '<ul>';
			str += '<li class="name">'+ id +'<span>[ '+cdate+' ]</span>';
			str += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 비밀번호&nbsp;&nbsp;';
			str += '<input type="password" class="replynum" id="updatePw" />';
			str += '</li>';
			str += '<li class="txt"><textarea id="updateContent" class="replyType">'+ccontent+'</textarea></li>';
			str += '<li class="btn">';
			str += '<a onclick="updateSave('+cno+')" class="rebtn">저장</a>&nbsp;&nbsp;&nbsp;';
			str += '<a onclick="cancelBtn('+cno+',\''+id+'\',\''+cdate+'\',\''+ccontent+'\')" class="rebtn">취소</a>';
			str += '</li>';
			str += '</ul>';
			$("#"+cno).html(str);
		} // if - confirm
	}// cModiBtn
//////////댓글 수정하기///////////////////////////////////////////////////////////////////////////////////	
//////////취소하기///////////////////////////////////////////////////////////////////////////////////	
	function cancelBtn(cno,id,cdate,ccontent){
		alert('취소버튼');
		console.log(cno);
		console.log(id);
		console.log(cdate);
		console.log(ccontent);
		
		var str = '';
		str+= '<li class="name">'+id+'<span>$'+cdate+'</span></li>';
		str+= '<li class="txt">'+ccontent+'</li>';
		str+= '<li class="btn">';
		str+= '<a onclick="cModiBtn('+cno+',\''+id+'\',\''+cdate+'\',\''+ccontent+'\')" class="rebtn">수정</a>';
		str+= '&nbsp;<a onclick="delBtn('+cno+')" class="rebtn">삭제</a>';
		str+= '</li>';
		
		$("#"+cno).html(str);
	
	}// cancelBtn
	
	function updateSave(cno){
	//	alert(cno);
	// 입력한 cpw, 입력한 내용을 가져와서 콘솔에 출력해본다 updatePw  updateContent
		console.log($("#updatePw").val());
		console.log($("#updateContent").val());
		if(confirm("저장하시겠습니까?")){
			$.ajax({
				url : "/board/cModi",
				method : "post",
				data : {"cno" : cno, "cpw" :$("#updatePw").val(),
					"ccontent" : $("#updateContent").val() },
				success : function(data){
					alert("성공");
					console.log(data);
					
					var id = data.id;
					var cpw = data.cpw;
					var ccontent = data.ccontent;
					var cdate = data.cdate;
					
					var str = '';
					str+= '<li class="name">'+id+'<span>$'+cdate+'</span></li>';
					str+= '<li class="txt">'+ccontent+'</li>';
					str+= '<li class="btn">';
					str+= '<a onclick="cModiBtn('+cno+',\''+id+'\',\''+cdate+'\',\''+ccontent+'\')" class="rebtn">수정</a>';
					str+= '&nbsp;<a onclick="delBtn('+cno+')" class="rebtn">삭제</a>';
					str+= '</li>';
					$("#"+cno).html(str);
				},
				error : function(data){
					alert("실패");
				}
			})// ajax
		}
	} // updateSave
	
	
	
	</script>


					<!-- 댓글-->
					<div class="replyWrite">
						<ul>
							<li class="in">
								<p class="txt">총 <span class="orange" id="comNum">${comList.size() }</span> 개의 댓글이 달려있습니다.</p>
								<p class="password">비밀번호&nbsp;&nbsp;
								<input type="password" class="replynum" /></p>
								<textarea class="replyType"></textarea>
							</li>
							<li class="btn"><a onclick="commentBtn()" class="replyBtn">등록</a></li>
						</ul>
						<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
					</div>

					<div class="replyBox">
						
						<c:forEach var="cdto" items="${comList }">
							<ul id="${cdto.cno }">
								<li class="name">${cdto.id } <span>${cdto.cdate }</span></li>
						<c:if test="${!(sessionId != cdto.id && cdto.cpw != null)}">
								<li class="txt">${cdto.ccontent }</li>
						</c:if>
						<c:if test="${sessionId != cdto.id && cdto.cpw != null}">
								<li class="txt"><span class="orange">※ 비밀글입니다.</span></li>
						</c:if>
						<c:if test="${sessionId==cdto.id }">
								<li class="btn">
									<a onclick="cModiBtn(${cdto.cno},'${cdto.id}','${cdto.cdate}','${cdto.ccontent}')" class="rebtn">수정</a>
									<a onclick="delBtn(${cdto.cno })" class="rebtn">삭제</a>
								</li>
						</c:if>
							</ul>
						</c:forEach>

						<!-- <ul>
							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li>
							<li class="txt">대박!!! 이거 저한테 완전 필요한 이벤트였어요!!</li>
							<li class="btn">
								<a href="#" class="rebtn">수정</a>
								<a href="#" class="rebtn">삭제</a>
							</li>
						</ul>-->

						<ul>
							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li>
							<li class="txt">
								<span class="orange">※ 비밀글입니다.</span>
							</li>
						
						</ul> 
					</div>
					<!-- //댓글 -->


					<!-- Btn Area -->
					<div class="btnArea">
						<div class="bRight">
							<ul>
								<li><a href="/board/notice?page=${page}&category=${category}&sWord=${sWord}" class="sbtnMini mw">목록</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->
					
				</div>
			</div>
			<!-- //contents -->


<script type="text/javascript" src="../js/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../css/jquery.fancybox-1.3.4.css" />
<script type="text/javascript">
$(function(){
	
	var winWidth = $(window).width();
	if(winWidth > 767){
		var layerCheck = 540;
	}else{
		var layerCheck = 320;
	}

	$(".passwordBtn").fancybox({
		'autoDimensions'    : false,
		'showCloseButton'	: false,
		'width' : layerCheck,
		'padding' : 0,
		'type'			: 'iframe',
		'onComplete' : function() {
			$('#fancybox-frame').load(function() { // wait for frame to load and then gets it's height
			$('#fancybox-content').height($(this).contents().find('body').height());
			});
		}
	});


});
</script>

		</div>
	</div>
	<!-- //container -->
	<%@ include file="../foot.jsp" %>
</div>
</div>
</body>
</html>
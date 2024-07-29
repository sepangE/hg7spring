<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>publicData.jsp</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		#main{width:1600px; margin : 20px auto; text-align:center}
		#body{width:1600px; height:1000px; margin:20px auto;
			   border : 3px solid black;}
		table{width: 1400px; margin:0 auto;}
		talbe, th, td{border:1px solid black; border-collapse:collapse;}
		th{height:40px;}
		td{height:35px;}
		img{width:50px;}
		</style>
	</head>
	<body>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$.ajax({
			url:"/searchPublic",
			type:"get",
			data : {"txt":$("#txt").val()},
			dataType:"json",
			success : function(data){
				alert("성공");
				console.log(data);
				let iarr=data.response.body.items.item;
				var str = '';
				for(let i = 0; i < iarr.length; i++){
					str += '<tr>';
					str += '<th>'+iarr[i].galContentTypeId+'</th>';
					str += '<th>'+iarr[i].galTitle+'</th>';
					str += '<th>'+iarr[i].galPhotographyLocation+'</th>';
					str += '<th>'+iarr[i].galPhotographer+'</th>';
					str += '<th>'+iarr[i].galPhotographyMonth+'</th>';
					str += '<th><a href="'+iarr[i].galWebImageUrl+'">링크</a></th>';
					str += '</tr>';
				}
				$("#content").html(str);
			},
			error : function(){
				alert("실패");
			}
		})//ajax
	})//btn
})//jquery


</script>
		<div id="main">
			<h1>공공데이터 정보</h1>
			시작 숫자를 입력 :<input type="text" name="txt"id="txt">
			<button type="button" id="btn">검색</button>
			<br><br>
			<div id = "body">
				<table>
					<colgroup>
						<col width="10%">
						<col width="25%">
						<col width="10%">
						<col width="15%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>사진 제목</th>
							<th>촬영장소</th>
							<th>촬영 작가</th>
							<th>촬영 일자</th>
							<th>이미지 링크</th>
						</tr>
					</thead>
					<tbody id="content">
						
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
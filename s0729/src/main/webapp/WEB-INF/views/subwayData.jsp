<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>subwayData.jsp</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		#main{width:1600px; margin : 20px auto; text-align:center}
		#body{width:1600px; height:1000px; margin:20px auto;
			   border : 3px solid black;}
		table{width: 1400px; margin:0 auto;}
		talbe, th, td{border:1px solid black; border-collapse:collapse;}
		th{height:40px;}
		td{height:35px;}
		</style>
	</head>
	<body>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$.ajax({
			url:"/searchSubway",
			type:"get",
			data : {"txt":$("#txt").val()},
			dataType:"json",
			success : function(data){
				alert("성공");
				console.log(data);
				let iarr = data.realtimeArrivalList;
				var str = '';
				for(var i = 0; i < iarr.length; i++){
					str += '<tr>';
					str += '<th>'+iarr[i].subwayId+'</th>';
					str += '<th>'+iarr[i].trainLineNm+'</th>';
					str += '<th>'+iarr[i].arvlMsg3+'</th>';
					str += '<th>'+iarr[i].arvlMsg2+'</th>';
					str += '<th>'+iarr[i].bstatnNm+'</th>';
					if(iarr[i].lstcarAt==0){
						str += '<th>막차아님</th>';
					} else {
						str += '<th>막차</th>';
					}
					
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
			<h1>지하철 정보</h1>
			역 이름 입력 :<input type="text" name="txt"id="txt">
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
							<th>호선</th>
							<th>00행</th>
							<th>위치</th>
							<th>현재 상태</th>
							<th>종착역</th>
							<th>막차여부</th>
						</tr>
					</thead>
					<tbody id="content">
						
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
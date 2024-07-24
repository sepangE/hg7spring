<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax01</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		button{width:200px; height:50px; margin:50px 0 30px 0; cursor:pointer;}
		table, th, td{border: 1px solid black; border-collapse:collapse;
		width: 1100px; margin-top: 50px;
		margin:0 auto; text-align: center;}
		th, td{height:30px;}
		</style>
		<script>
		$(function(){
			// test.txt 파일과 연결
			$("#loadBtn").click(function(){
				$.ajax({
					url:"/test.txt",
					dataType: "text",
					success: function(data){
						alert('연결성공');
						console.log(data);
						$("#text").text(data);
					},
					error : function(){
						alert("연결실패");
					} 
				})// ajax
			})//loadBtn
			
			$("#ajaxBtn").click(function(){
				$.ajax({
					url:"/ajaxTest.json",
					dataType: "json",
					success: function(data){
						alert('연결성공');
						console.log(data);
						let str= '';
						for(let i = 0; i < data.length; i++){
							str+='<tr>'
							str+='<td>'+data[i].id+'</td>';
							str+='<td>'+data[i].first_name+'</td>';
							str+='<td>'+data[i].email+'</td>';
							str+='<td>'+data[i].gender+'</td>';
							str+='</tr>'
						}
						//$("#btable").append(str); // 기존에 있던거 아래로 
						$("#btable").html(str); // 기존에 있던거 지우고
						//$("#btable").prepend(str); // 기존에 있던거 위로
					},
					error : function(){
						alert("연결실패");
					} 
				})// ajax
			})//ajaxBtn
			$("#dbBtn").click(function(){
			//	alert("데이터 베이스 연결");
				$.ajax({
					url : "/member/selectAll",
					method : "post",
					success: function(data){
						alert("성공");
						console.log(data[0]);
						str = '';
						for(let i = 0; i< data.length; i++){
							str += '<tr>';
							str += '<td>'+(i+1)+'</td>';
							str += '<td>'+data[i].name+'</td>';
							str += '<td>'+data[i].phone+'</td>';
							str += '<td>'+data[i].gender+'</td>';
							str += '</tr>';
						}
						$("#btable").html(str);
					},
					error : function(data){
						alert("실패");
					}
				})//ajax
			})// dbBtn
			
		})// jquery
		
		</script>
		
	</head>
	<body>
		<h1>AJAX</h1>
		<h1><a href="/">메인으로 돌아가기</a></h1>
		<h1><a href="/member/login">login</a></h1>
		<p id="text"></p>
		<button id="loadBtn">load</button>
		<button id="ajaxBtn">ajax</button>
		<button id="dbBtn">DB</button>
		<table>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>핸드폰</th>
				<th>성별</th>
			</tr>
			<tbody id="btable">
			<tr>
				<td>1</td>
				<td>홍길동</td>
				<td>010-9878-7878</td>
				<td>남성</td>
			</tr>
			</tbody>
		</table>
	</body>
</html>
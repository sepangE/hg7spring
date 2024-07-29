<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
		<meta charset="UTF-8">
		<title>list.jsp</title>
		<style type="text/css">
		*{margin:0; padding:0;}
		div{width:1000px; margin: 30px auto; text-align:center;}
		h1{margin-bottom: 30px;}
		table,th,td{border: 1px solid black; border-collapse:collapse;
				font-size: 16px;}
		th,td { width: 200px; height: 40px;}
		button{width:200px; height: 60px; margin-top: 30px;}
		</style>
	</head>
	<body>
	<script>
	function listBtn(){
	//	alert("리스트");
		$.ajax({
			url:"/boardList",
			method:"post",
			success:function(data){
	//			alert("성공")
				console.log(data);
				let str ='';
				for(let i = 0; i < data.length;i++){
					str += '<tr>';
					str += '<td>'+data[i].bno+'</td>';
					str += '<td>'+data[i].btitle+'</td>';
					str += '<td>'+data[i].id+'</td>';
					str += '<td>'+data[i].bdate+'</td>';
					str += '<td>'+data[i].bhit+'</td>';
					str += '</tr>';
				}
				$("#tbody").html(str);
			},
			error : function(){
				alert("실패");
			}
		})// ajax
	}//listBtn
	
	function writeBtn(){
	//	alert();
//	console.log($("#id").val());console.log($("#btitle").val());console.log($("#bcontent").val());
	$.ajax({
		url:"/insertBoard",
		method:"post",
		data:{"id" : $("#id").val(),
			  "btitle" : $("#btitle").val(),
			  "bcontent" : $("#bcontent").val()},
		success : function(data){
			alert("성공");
			console.log(data);
			let str ='';
			str += '<tr>';
			str += '<td>'+data.bno+'</td>';
			str += '<td>'+data.btitle+'</td>';
			str += '<td>'+data.id+'</td>';
			str += '<td>'+data.bdate+'</td>';
			str += '<td>'+data.bhit+'</td>';
			str += '</tr>';
			$("#tbody").prepend(str);
		},
		error : function(){
			alert("실패")
		}
	})//ajax
	}// writeBtn
	</script>
		<div><h1>게시판</h1>
			<table>
				<colgroup>
					<col width="12%">	
					<col width="40%">
					<col width="18%">
					<col width="18%">
					<col width="12%">
				</colgroup>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<tbody id="tbody">
				<tr>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>			
				</tbody>
			
				
			</table>
			<a onclick="listBtn()"><button type="button">리스트 가져오기</button></a>
		<br><br><br><br> <hr> <br><br><br><br>
		<h1>글쓰기</h1>
			<form action="" name="b_frm"
				method="post" enctype="multipart/form-data">
			<table>
				<colgroup><col width="20%"><col width="80%"></colgroup>
				<tr>
					<th>제목</th>
					<td><input type="text" name="btitle" id="btitle"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
					<input type="text" name="id" id="id">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea id ="bcontent" name="bcontent" rows="30" cols="65"></textarea>
					</td>
				</tr>
			</table>	
			
			<a onclick="writeBtn()"><button type="button">글쓰기</button></a>
			</form>
		
		</div>
	
	</body>
</html>
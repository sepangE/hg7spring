<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
div {
	width: 1000px;
	margin: 0 auto;
	text-align: center;
}

button {
	width: 200px;
	height: 50px;
	margin: 10px auto;
	cursor: pointer;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	width: 800px;
	margin-top: 50px;
	margin: 0 auto;
	text-align: center;
}

th, td {
	height: 30px;
}
</style>
<script>
	function listBtn(){
		alert("버튼");
		$.ajax({
			url : "/productList",
			method : "post",
			success : function(data){
				alert("성공");
				console.log(data);
				let str='';
				for(let i = 0; i < data.length; i++){
					str += '<tr>';
					str += '<td>'+data[i].pno+'</td>';
					str += '<td>'+data[i].name+'</td>';
					str += '<td>'+data[i].price+'</td>';
					str += '<td>'+data[i].category+'</td>';
					str += '<td>'+data[i].pdate+'</td>';
					str += '</tr>';
				}
				$("#tbody").html(str);
			},
			error : function(){
				alert("실패");
			}
		})//ajax
	};// listBtn
	
	function submitBtn(){
		alert($("#name").val());
		alert($("#price").val());
		alert($("#category").val());
		
		$.ajax({
			url : "/insertProductInfo",
			method : "",
			data:{"name" : $("#name").val(),
				  "price" : $("#price").val(),
				  "category" : $("#category").val()},
			success:function(data){
				alert("성공");
				console.log(data);
				let str='';
					str += '<tr>';
					str += '<td>'+data.pno+'</td>';
					str += '<td>'+data.name+'</td>';
					str += '<td>'+data.price+'</td>';
					str += '<td>'+data.category+'</td>';
					str += '<td>'+data.pdate+'</td>';
					str += '</tr>';
					$("#tbody").prepend(str);
			},
			error : function(data){
				alert("실패");
			}
		})//ajax
	};
	
</script>
</head>
<body>
	<div>
		<button onclick="listBtn()">상품리스트 출력하기</button>
		<form action="" method="post" name="pFrm">
			<br>
			<label>상품명</label>
			<input type="text" id="name" name="name" />
			<br>
			<label>가격</label> 
			<input type="text" id="price" name="price" />
			<br>
			<label>카테고리</label> 
			<select name="category" id="category" >
				<option value="식품">식품</option>
				<option value="의류">의류</option>
				<option value="가전">가전</option>
				<option value="전자">전자</option>
			</select>
			<br>
			<input type="button" value="상품등록" onclick="submitBtn()">
		</form>

		<br>
		<br>
		<table>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>카테고리</th>
				<th>등록일</th>
			</tr>
			<tbody id="tbody">
				<tr>
					<td>1</td>
					<td>식빵</td>
					<td>3000</td>
					<td>식품</td>
					<td>2024-07-24</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
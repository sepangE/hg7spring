<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mlist.jsp</title>
		<style>
			*{margin: 0; padding: 0; }
			div{width: 800px; margin: 30px auto; text-align:center;}
			h1{margin-bottom: 30px;}
			table, th, td{border: 1px solid black; border-collapse: collapse;
							font-size: 16px;}
			th{width: 200px; height: 40px;}
			td{width: 400px; height: 40px;}
			button{width: 150px; height: 40px;}
			.sbtn{width: 50px;}
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			function mlistBtn(){
			//	alert("mlistBtn()");
			$.ajax({
				url : "/member/selectAll",
				method : "post",
				success : function(data){
					alert("성공");
					console.log(data);
					let str='';
					for(let i = 0; i < data.length; i++){
						str += '<tr id="'+data[i].id+'">';
						str += '<td>'+data[i].id+'</td>';
						str += '<td>'+data[i].name+'</td>';
						str += '<td>'+data[i].gender+'</td>';
						str += '<td>'+data[i].hobbys+'</td>';
						str += '<td><button type="button" class="sbtn">수정</button>&nbsp;'+
							   '<button onclick="delMBtn(\''+data[i].id+'\')" class="sbtn">삭제</button></td>';
						str += '</tr>';
					}// for
					$("#tbody").html(str);
				},
				error : function(){
					alert("실패")
				}
			})//ajax
			}// mlistBtn
			
			function mJoinBtn(){
			//	alert("mJoinBtn");
				var id = $("#id").val();
				var pw = $("#pw").val();
				var name = $("#name").val();
				var phone = $("#phone").val();
				var gender = $("input:radio[name='gender']:checked").val();
				var hobbys = '';
					$("input:checkbox[name='hobby']:checked").each(function(i){
					hobbys += $(this).val()+ ', ';
				});
			

				console.log(id);
				console.log(pw);
				console.log(name);
				console.log(phone);
				console.log(gender);
				console.log(hobbys);
				 $.ajax({
					url : "/member/mJoin",
					method : "post",
					data : {"id" : id,
							"pw" : pw,
							"name" : name,
							"phone" : phone,
							"gender" : gender,
							"hobbys" : hobbys
							},
					success: function(data){
						alert("성공");
						let str ='';
						str += '<tr id="'+data.id+'">';
						str += '<td>'+data.id+'</td>';
						str += '<td>'+data.name+'</td>';
						str += '<td>'+data.gender+'</td>';
						str += '<td>'+data.hobbys+'</td>';
						str += '<td><button type="button" class="sbtn">수정</button>&nbsp;'+
							   '<button onclick="delMBtn(\''+data.id+'\')" class="sbtn">삭제</button></td>';
						str += '</tr>';
						$("#tbody").html(str);
					},
					error : function(){
						alert("실패");
					} 
				})// ajax  
			}//mJoinBtn
			
			function delMBtn(id){
				alert(id);
				console.log(id);
			 	$.ajax({
					url : "/member/delOneMem",
					method : "post",
					data : {"id" : id},
					success : function(data){
						alert("성공");
						$("#"+id).remove();
					}
				}) // ajax 
			} // delMBtn
				
			
		</script>
	</head>
	<body>
	
		<div>
			<h1> 회원 전체 리스트 </h1>
			<table>
				<colgroup>
					<col width="20%">	
					<col width="20">
					<col width="10%">
					<col width="30%">
					<col width="20%">
				</colgroup>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>취미</th>
					<th>삭제/수정</th>
				</tr>
		<tbody id = "tbody">
			<tr>
				<td>aaa</td>
				<td>홍길동</td>
				<td>Male</td>
				<td>run</td>
				<td>
					<button type="button" class="sbtn">수정</button>
					<button type="button" class="sbtn">삭제</button>
				</td>
			</tr>	
		</tbody>
				

			</table>
			<br>
			<a onclick="mlistBtn()"><button type="button">회원전체리스트</button></a>
		
			<br>
			<br>
		<hr>
		<br>
		<h1>회원가입</h1>
			<form action="/mJoin" name="m_frm" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="pw" name="pw"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" id="phone" name="phone"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" id="Male" name="gender" value="Male">
						<label for="Male">남성</label>
						<input type="radio" id="Female" name="gender" value="Female">
						<label for="Female">여성</label>
					</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<input type="checkbox" name="hobby" id="game" value="game">
						<label for="game">게임</label>
						<input type="checkbox" name="hobby" id="golf" value="golf">
						<label for="golf">골프</label>
						<input type="checkbox" name="hobby" id="run" value="run">
						<label for="run">조깅</label>
						<input type="checkbox" name="hobby" id="cook" value="cook">
						<label for="cook">요리</label>
						<input type="checkbox" name="hobby" id="book" value="book">
						<label for="book">독서</label>
					</td>
				</tr>
			</table>
			
			<br>
			<button type="button" onclick="mJoinBtn()">저장</button>			
			<button type="button" onclick="javascript:history.back()">취소</button>			
			</form>
		
		</div>
	</body>
</html>
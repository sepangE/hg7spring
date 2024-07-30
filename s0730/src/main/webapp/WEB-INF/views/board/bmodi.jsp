<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bmodi.jsp</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style type="text/css">
		*{margin:0; padding:0;}
		div{width:800px; margin: 30px auto; text-align:center;}
		h1{margin-bottom: 30px;}
		table{width: 800px;}
		table,th,td{border: 1px solid black; border-collapse:collapse; 
				font-size: 16px;}
		th,td { height: 40px;}
		button{width:200px; height: 60px; margin-top: 30px;}
		textarea{font-size: 17px;}
		input[type=text]{width:97%; height:30px; font-size: 17px;}
		</style>
		<script>
		$(function(){
			$("#fbtn").click(function(){
				alert("글을 저장합니다.");
				b_frm.submit();
			});// fbtn
				
		}); // jquery
		</script>
	</head>
	<body>

		<div>
			<h1>글수정</h1>
			<form action="" name="b_frm" 
				method="post" enctype="multipart/form-data">
			<table>
				<colgroup>
					<col width="20%">
					<col width="80%">
				</colgroup>
				<tr>
					<th>번호</th>
					<td>
						<input type="hidden" id="bno" name="bno" value="">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="btitle" id="btitle" value="">
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
					<input type="hidden" name="id" 
						value="">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="bcontent" rows="30" cols="65"></textarea>
					</td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td>
						<img src=""><br>
						<input type="file" name="bfile" id="bfile">
					</td>
				</tr>
			</table>	
			<button type="button" id="fbtn">수정</button>
			<button type="button" onclick="javascript:history.back()">취소</button>
			
			</form>
		
		
		</div>
	
	</body>
</html>
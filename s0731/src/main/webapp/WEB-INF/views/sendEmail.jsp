<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>sendEmail.jsp</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	<body>

<script>
	function emailBtn(){
		var name = $("#name").val();
		var email = $("#email").val();
		//console.log(name);		console.log(email);
		$.ajax({
			url : "/email/emailSend",
			type : "post",
			data : {"name" : name, "email" : email},
			success : function(data){
				alert("성공");
				console.log(data);
			},
			error : function(){
				alert("실패");
			}
		}) // ajax
	} // emailBtn
</script>		

		
		이름 : <input type="text" id="name" name="name" /><br>
		이메일 : <input type="text" id="email" name="email" /><br>
		<button type="button" onclick="emailBtn()">메일발송</button> <br>
		<hr>
		인증번호 : <input type="text" id="snum" name="snum" /><br>
		<button> 인증 </button>
	</body>
</html>
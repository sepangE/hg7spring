<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doLogin.jsp</title>
	</head>
	<body>
		<h2>doLogin.jsp</h2>
		<script>
		if(${loginCheck}==1){
			alert("로그인되었습니다.");
			location.href="/index";
		} else {
			alert("아이디 또는 비밀번호가 일치하지 않음");
			location.href="login";
		}
		</script>
	</body>
</html>
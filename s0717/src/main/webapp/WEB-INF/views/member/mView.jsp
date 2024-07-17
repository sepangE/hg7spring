<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mView.jsp</title>
	</head>
	<body>
		<h2>회원정보</h2>
		<h3>아이디 : ${m.id }</h3>
		<h3>비밀번호 : ${m.pw }</h3>
		<h3>이름 : ${m.name }</h3>
		<h3>전화번호 : ${m.phone }</h3>
		<h3>성별 : ${m.gender }</h3>
		<h3>취미 : ${m.hobbys }</h3>
		<button><a href="mlist">회원목록</a></button>
		<button><a href="modiM?id=${m.id}">회원정보 수정</a></button>
		<button><a href="deleteM?id=${m.id}">회원탈퇴</a></button>
	</body>
</html>
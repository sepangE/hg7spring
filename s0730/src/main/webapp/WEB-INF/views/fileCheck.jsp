<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>fileCheck.jsp</title>
	</head>
	<body>
		<h2>게시글 등록</h2>
		<h3>제목 : ${btitle}</h3>
		<h3>파일 : ${fileName}</h3>
		<h3>이미지</h3>
		<img src="/images/${fileName}">
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>form1.jsp</title>
	</head>
	<body>
		<h2>게시글 등록</h2>
		<form action="/doForm2" method="post" enctype="multipart/form-data">
			<label>제목</label>
			<input type="text" name="btitle" />
			<br>
			<input multiple="multiple" type="file" name="files" />
			<br>
			<input type = "submit" value="저장">
		</form>
	</body>
</html>
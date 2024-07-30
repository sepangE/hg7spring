<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>fileCheck2.jsp</title>
	</head>
	<body>
		<h2>게시글 등록</h2>
		<h3>제목 : ${board.btitle}</h3>
		<h3>파일 : ${board.bfile}</h3>
		<h3>이미지</h3>
		<c:forEach var ="im" items="${board.bfiles }">
		<img src="/images/${im}">
		</c:forEach>
	</body>
</html>
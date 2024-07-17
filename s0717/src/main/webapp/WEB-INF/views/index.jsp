<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인 페이지</title>
	</head>
	<body>
		<h1>index 페이지</h1>
		<h2>${sessionName} 님</h2>
		<ul>
		<c:if test="${sessionId==null }">
			<li><a href="/member/join">회원가입</a></li>
			<li><a href="/member/login">로그인</a></li>
		</c:if>
		<c:if test="${sessionId!=null }">
			<li><a href="/member/logout">로그아웃</a></li>
			<li><a href="/board/blist">게시판</a></li>
			<li><a href="/board/bwrite">게시글 작성</a></li>
			<li><a href="/member/mlist">회원목록</a></li>
		</c:if>
		</ul>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>dologin.jsp</title>
	</head>
	<body>
		<c:if test="${result==1}">
			<script>
				alert("로그인되었습니다.");
				location.href="/index";
			</script>
		</c:if>
		<c:if test="${result!=1}">
			<script>
				alert("아이디 또는 비밀번호가 틀렸습니다. 다시 시도해주세요");
				location.href="login";
			</script>
		</c:if>
	</body>
</html>
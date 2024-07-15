<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>updatemForm</title>
	</head>
	<body>	
		<h1>회원정보 수정</h1>
		<form action="doMForm" name="jfrm" method="post">
		<label>아이디</label>
		<input type="text" name="id" id="id" value="${member.id }">
		<br>
		<label>비밀번호</label>
		<input type="text" name="pw" id="pw" value="${member.pw }">
		<br>
		<label>이름</label>
		<input type="text" name="name" id="name" value="${member.name}">
		<br>
		<label>성별</label>
		
		<input type="radio" name="gender" id="male" value="male"
		 <c:if test="${member.gender=='male'}">checked </c:if> >
		<label for="male">남성</label>
		
		<input type="radio" name="gender" id="female" value="female"
		<c:if test="${member.gender=='female'}"> checked </c:if>   >
		<label for="male">여성</label>
		
		<br>
		<label>직업</label>
		<select name="job">
			<option value="worker" <c:if test="${member.job=='worker'}">selected</c:if> >회사원</option>
			<option value="self" <c:if test="${member.job=='self'}">selected</c:if> >자영업자</option>
			<option value="freelancer" <c:if test="${member.job=='freelancer'}">selected</c:if> >프리랜서</option>
			<option value="housekeeper" <c:if test="${member.job=='housekeeper'}">selected</c:if> >백수</option>
		</select>
		<br>
		<label>취미</label><br>
		<input type="checkbox" name="hobbys" id="game" value="game" <c:if test="${fn: contains(member.hobby,'game')}"> checked </c:if> >
		<label for="game">게임</label>
		<input type="checkbox" name="hobbys" id="golf" value="golf" <c:if test="${fn: contains(member.hobby,'golf')}"> checked </c:if> >
		<label for="golf">골프</label>
		<input type="checkbox" name="hobbys" id="run" value="run" <c:if test="${fn: contains(member.hobby,'run')}"> checked </c:if> >
		<label for="run">달리기</label>
		<input type="checkbox" name="hobbys" id="book" value="book" <c:if test="${fn: contains(member.hobby,'book')}"> checked </c:if> >
		<label for="book">독서</label>
		<input type="checkbox" name="hobbys" id="swim" value="swim" <c:if test="${fn: contains(member.hobby,'swim')}"> checked </c:if> >
		<label for="swim">수영</label>
		<br><br>
		<input type="submit" value="가입하기">
		</form>
	</body>
</html>
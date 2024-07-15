<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>	
		<h1>회원가입</h1>
		<form action="doMForm" name="jfrm" method="post">
		<label>아이디</label>
		<input type="text" name="id" id="id">
		<br>
		<label>비밀번호</label>
		<input type="text" name="pw" id="pw">
		<br>
		<label>이름</label>
		<input type="text" name="name" id="name">
		<br>
		<label>성별</label>
		<input type="radio" name="gender" id="male" value="male">
		<label for="male">남성</label>
		<input type="radio" name="gender" id="female" value="female">
		<label for="female">여성</label>
		<br>
		<label>직업</label>
		<select name="job">
			<option value="worker">회사원</option>
			<option value="self">자영업자</option>
			<option value="freelancer">프리랜서</option>
			<option value="housekeeper">백수</option>
		</select>
		<br>
		<label>취미</label><br>
		<input type="checkbox" name="hobbys" id="game" value="game">
		<label for="game">게임</label>
		<input type="checkbox" name="hobbys" id="golf" value="golf">
		<label for="golf">골프</label>
		<input type="checkbox" name="hobbys" id="run" value="run">
		<label for="run">달리기</label>
		<input type="checkbox" name="hobbys" id="book" value="book">
		<label for="book">독서</label>
		<input type="checkbox" name="hobbys" id="swim" value="swim">
		<label for="swim">수영</label>
		<br><br>
		<input type="submit" value="가입하기">
		</form>
	</body>
</html>
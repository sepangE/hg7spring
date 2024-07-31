<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입력 연습</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
		function ckBtn(){
		//	alert($("#id").val().length);
		//	if($("#id").val().length<5) alert("아이디는 5자리 이상이어야 합니다.");
			// 이름은 한글로만 입력받는다
			let nameCheck = /^[가-힣]+$/; // 가~힣 까지만 입력받
			let numCheck = /^[0-9]+$/;	 // 숫자검사
			let alphaCheck = /^[a-zA-Z]+$/ // 영문검사
			let etcCheck =/^[!@#$%^&*,.?_-]+$/; // 포함된 특수문자 검사
			
			// id 검사 숫자, 영문자만 가능 영문자로 시작 특수문자 _ 만 가능
			let idCheck1 = /^[a-zA-Z0-9_]{5,10}$/;
			// 첫글자는 영문
			let idCheck2 = /^[a-zA-Z]{1}[a-zA-Z0-9_]{3,6}$/;
			// 영문자, 숫자 특수문자는 @-_.
			let emailCheck = /^[a-zA-Z0-9@-_.]+$/;
			// 비밀번호 검사
			// 하나이상의 영문자, 하나이상의 숫자, 하나이상의 특수문자 최소 5자리
			let pwCheck = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{5,16}$/;
		 	if( !idCheck2.test( $("#id").val() )){ // 한글이 입력되지 않았다면
				alert("첫글자 영문, 영문,숫자_만 가능함");
				$("#id").focus();
			}
			if( !nameCheck.test( $("#name").val() )){ // 한글이 입력되지 않았다면
				alert("한글만 입력 가능");
				$("#name").focus();
			}
			if( !emailCheck.test( $("#email").val() )){ // 한글이 입력되지 않았다면
				alert("영문, 숫자, 특수문자 @-_. 만 가능");
				$("#email").focus();
			} 
			if( !pwCheck.test( $("#pw").val() )){ // 한글이 입력되지 않았다면
				alert("5자리 이상, 영문자, 숫자, 특수문자 포함해야함(!@#$%^&*_?)");
				$("#pw").focus();
			}
			
		}//ckBtn
		</script>
		<style>
		.blue{color:blue;}
		.red{color:red;}
		</style>
		
		
	</head>
	<body>
		<h1>정규식</h1>
		아이디 : <input type="text" id="id" name="id"><br>
		이름 : <input type="text" id="name" name="name"><br>
		비밀번호 : <input type="text" id="pw" name="pw"><br>
		이메일 : <input type="text" id="email" name="eamil"><br>
		<button type="button" onclick="ckBtn()">가입</button>
		<hr><hr>
<script>
function pwKey(){
	console.log($("#pw2").val());
	var pw1 = $("#pw1").val();
	var pw2 = $("#pw2").val();
	// pw1 pw2 비교해서 비밀번호가 다르면 pwCk에 비밀번호가 일치하지 않음
	// 일치하면 일치함 pwCk에 비밀번호가 일치하지 않음
	if(pw1 == pw2){
		$("#pwCk").html('<span class="blue">비밀번호가 일치함</span>');
	} else {
		$("#pwCk").html('<span class="red">비밀번호가 일치하지 않음</span>');
	}
	
}
</script>	
		<h1>비밀번호 비교하기</h1>
		비밀번호 입력 <input type="text" id="pw1" name="pw1"><br>
		비밀번호 확인 <input type="text" id="pw2" name="pw2" onkeyup="pwKey()"><br>
		<p id="pwCk"></p>
		
		<br><hr><br>
		
		
		<h1> select option - 01월부터 12월</h1>
		<select>
			<script>
				for(var i = 1; i <= 12; i++){
					if(i<10){
					document.write("<option value='month"+i+"'>0"+i+"월</option>")
					}else{
					document.write("<option value='month"+i+"'>"+i+"월</option>")
					}
				}
			</script>
		</select>
		
		<br><br><br>
		
<script>
function hbCk(){
	console.log($("#hobbyList").val());
	if($("#hobbyList").val() != "txt"){
		$("#hobby").val($("#hobbyList").val());
		$("#hobby").attr("disabled",true);
	} else {
		$("#hobby").val("");
		$("#hobby").attr("disabled",false);
	}
}		
</script>
		
		<h1> select 선택된 값을 input 텍스트에 넣기</h1>
		<input type="text" id ="hobby" name="hobby" placeholder="직접입력">
		<select id="hobbyList" onchange="hbCk()">
			<option value="txt"></option>
			<option value="book">"book"</option>
			<option value="run">run</option>
			<option value="cook">cook</option>
			<option value="golf">golf</option>
		</select>
		<br><hr><br>
	
<script>
function idCkBtn(){
	//console.log($("#userId").val());
	 $.ajax({
		url : "/member/idCk",
		method : "post",
		dataType : "text",
		data : {"userId" : $("#userId").val()},
		success : function(data){
			console.log(data);
			if(data == null || data ==""){
				alert("사용 가능한 아이디");
			} else {
				alert("이미 사용중인 아이디\n다시 입력해주세요");
				$("#userId").val(""); // 값 지우기
				$("#userId").focus(); // 포커스 두기
				
			}
		},
		error : function(){
			alert("실패");
		}
	})// ajax 
} // idCkBtn
</script>		
		
		<h1> 아이디 중복 검사 ajax </h1>
		<input type="text" id="userId" name="userId">
		<button type="button" onclick="idCkBtn()">중복확인</button>
	</body>
</html>
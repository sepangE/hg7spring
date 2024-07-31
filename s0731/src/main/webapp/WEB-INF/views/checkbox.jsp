<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>체크박스 연습</title>
		<style>
		table,td{border: 1px solid black; border-collapse:collapse;}
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
		$(function(){
			$("#checkAll").click(function(){
				//alert("체크박스 클릭");
				if($("#checkAll").is(":checked")){
					$("input[name=agree]").prop("checked",true);
				} else{
					$("input[name=agree]").prop("checked",false);
				}
			});//checkAll.click
			
			$("input[name=agree]").click(function(){
				var total = $("input[name=agree]").length;
				var checked = $("input[name=agree]:checked").length;
			//	alert("전체 체크박스 수 : "+ total);
			//	alert("체크된 체크박스 수 : "+ checked);
			if(total != checked){
				$("#checkAll").prop("checked", false);
			} else {
				$("#checkAll").prop("checked", true);
			}
			})//input[name=agree].click
		});// jquery
		function sBtn(){
		//	alert("가입하기 버튼");
			var total = $("input[name=agree]").length;
			var checked = $("input[name=agree]:checked").length;
			if(checked < 3){
				confirm("전체 동의하셔야 합니다\n전체 동의 하시겠습니까?"){
					$("input[name=agree]").prop("checked", true);
				}
			}
			if(checked == 3){
				confirm("가입하시겠습니까?");
			}
		}
		</script>
	</head>
	<body>
		<h1>체크박스 연습</h1>
		<table>
			<tr>
				<td colspan="3"><input type="checkbox" id="checkAll"> 전체선택</td>
			</tr>
			<tr>
				<td> <input type="checkbox" name="agree"> option1 </td>
				<td> <input type="checkbox" name="agree"> option2 </td>
				<td> <input type="checkbox" name="agree"> option3 </td>
			</tr>
		</table>
		<br>
		<button type="button" onclick="sBtn()">가입하기</button>
	</body>
</html>
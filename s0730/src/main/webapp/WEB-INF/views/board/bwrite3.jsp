<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bwrite3.jsp - summernote</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="/js/summernote-ko-KR.js"></script>
		<script src="/js/summernote-lite.js"></script>
		<link href="/css/summernote-lite.css" rel="stylesheet">
		
		<style type="text/css">
		table,th,td{border: 1px solid black; border-collapse:collapse; 
				font-size: 16px;}
		</style>
		<script>
		$(function(){
			
			$('#summernote').summernote({
				  height: 300,                 // 에디터 높이
				  minHeight: null,             // 에디터 최소높이
				  maxHeight: null,             // 에디터 최대높이
				  focus: true,                 // 에디터 로딩 후 포커스 여부
				  lang : "ko-KR",			   // 한글설정
				  placeholder: '최대 1000자까지 쓸 수 있음',// placeholder 설정
				  toolbar : [
					  ['fontName', ['fontname']],
					  ['fontSize', ['fontsize']],
					  ['style', ['style']],
			          ['font', ['bold', 'underline', 'clear']],
			          ['color', ['color']],
			          ['para', ['ul', 'ol', 'paragraph']],
			          ['table', ['table']],
			          ['insert', ['link', 'picture', 'video']],
			          ['view', ['fullscreen', 'codeview', 'help']]
				  ],// toolbar
				  fontNames : ['맑은 고딕','궁서','굴림'],
				  fontSizes : ['10','15','20','32'],
				  callbacks : { // 여기가 이미지를 첨부하는 부분입니다 
					  onImageUpload : function(files){
						  // 하단 함수 호출
						  uploadImage(files[0],this);// 이미지 업로드 호출
						  // 이미지파일, 현재 위치 값
					  }
					  
				  } // callbacks
			}); // summernote
			
			$("#fbtn").click(function(){
				alert("글을 저장합니다.");
				b_frm.submit();
			});// fbtn
				
		}); // jquery
		
		function uploadImage(file, this_location){
			alert("uploadImage");
			var fdata = new FormData(); // ajax에서 전소ㅇ할때 form 형태로 전송
			fdata.append("afile",file); // file 이미지 첨부
			$.ajax({
				url: "/board/uploadImage",
				type : "post",
				dataType:"text",
				data : fdata,
				cache : false, // 남아있는 데이터 정보를 새롭게 정리
				contentType: false, // 파일을 보내는 형태 default값
				processData : false,
				enctype : "multipart/form-data",
				success : function(data){
					// js에서 함수호출을 해서 위치값에 데이터를 넣어줌(사진 넣어줌)
					$(this_location).summernote('editor.insertImage',data);
				},
				error : function(){
					alert("실패");
				}
			}); // ajax
		}
		</script>
	</head>
	<body>
		<div>
			<h1>글쓰기</h1>
			<form action="/board/bwrite" name="b_frm" 
				method="post" enctype="multipart/form-data">
			<table>
				<colgroup><col width="20%"><col width="80%"></colgroup>
				<tr>
					<th>제목</th>
					<td><input type="text" name="btitle" id="btitle"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td> 
					<input type="text" name="id" id="id">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea id="summernote" name="bcontent" rows="30" cols="65"></textarea>
					</td>
				</tr>
				 <tr>
		       		<th>파일첨부</th>
		       		<td><input type="file" name="file" id="file" ></td>
		     	 </tr>
		     	 
			</table>	
			<button type="button" id="fbtn">저장</button>
			<button type="button" onclick="javascript:history.back()">취소</button>
			
			</form>
		
		
		</div>
	
	</body>
</html>
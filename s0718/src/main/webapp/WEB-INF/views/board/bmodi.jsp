<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pages - Login</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/write.css">
</head>

<body>

  <section>
    <h1>게시글 수정</h1>
    <hr>

    <form action="bmodi" name="write" 
    	method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>아이디</th>
          <td>
          	${b.id}
            <input type="hidden" name="id" value="${b.id}">
            <input type="hidden" name="bno" value="${b.bno}">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" value="${b.btitle}">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" cols="50" rows="10">${b.bcontent}</textarea>
          </td>
        </tr>
        <tr>
          <th>파일</th>
          <td>${b.bfile}</td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
          	<img src="/images/${b.bfile}">
            <input type="hidden" name="bfile" id="file" value="${b.bfile}">
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">작성완료</button>
        <button type="button" class="cancel">취소</button>
      </div>
    </form>

  </section>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/notice_list.css">
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
 <script>
 
 </script>
</head>
<body>
	<script>
	function serchBtn(){
		//alert($('#s_word').val());
		if($('#s_word').val().length<2){
			alert("두글자 이상 입력해주세요");
			$('#s_word').focus();
			return false;
		} 
		serch.submit();
		
	}
	</script>
  <section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="/board/blist" name="search" method="post">
        <select name="category" id="category">
          <option value="all">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
        <div class="title">
          <input type="text" size="16" id="s_word" name="s_word" value="${s_word}">
        </div>
        <button type="submit" onclick="serchBtn()"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="15%"><col width="40%"><col width="15%"><col width="15%"><col width="15%">
      </colgroup>
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <c:forEach var="board" items="${list}">
	      <tr>
	        <td><span class="table-notice">  ${board.bno}  </span></td>
	        <td class="table-title">
	       	 <a href="/board/bread?bno=${board.bno}&page=${page}&category=${category}&s_word=${s_word}">${board.btitle } </a>
	        </td>
	        <td>${board.id }</td>
	        <td>${board.bdate }</td>
	        <td>${board.bhit }</td>
	      </tr>
      </c:forEach>

    </table>

    <ul class="page-num">
    <c:if test="${page!=1}">
      <a href="blist?page=1&category=${category}&s_word=${s_word}"><li class="first"></li></a>
    </c:if>
    <c:if test="${page==1}">
      <li class="first"></li>
    </c:if>
    
    <c:if test="${page==1}">
      <li class="prev"></li>
    </c:if>  
    <c:if test="${page!=1}">
      <a href="blist?page=${page-1}&category=${category}&s_word=${s_word}"><li class="prev"></li>
    </c:if>  
    
      <c:forEach begin="${startPage}" end="${endPage}" step="1" var="pNum">
       <a href="/board/blist?page=${pNum}&category=${category}&s_word=${s_word}"><li class="num"><div>${pNum}</div></li> </a>
      </c:forEach>
   
   <c:if test="${page!=maxPage}">
      <a href="blist?page=${page+1}&category=${category}&s_word=${s_word}"><li class="next"></li>
   </c:if>
   <c:if test="${page==maxPage}">
      <li class="next"></li>
   </c:if>
      
     <c:if test="${page==maxPage}">
      <li class="last"></li>
     </c:if>
     <c:if test="${page!=maxPage}">
     <a href="blist?page=${maxPage}&category=${category}&s_word=${s_word}"><li class="last"></li></a>
     </c:if>
     
    </ul>
    <div class="write"><a href="bwrite">쓰기</a></div>
  </section>

</body>
</html>
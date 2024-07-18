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
</head>
<body>

  <section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="/search" name="search" method="post">
        <select name="category" id="category">
          <option value="0">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>

        <div class="title">
          <input type="text" size="16">
        </div>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="15%">
        <col width="45%">
        <col width="15%">
        <col width="15%">
        <col width="15%">
      </colgroup>
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <c:forEach var="b" items="${list }">
      <tr>
        <td><span class="table-notice">${b.bno }</span></td>
        <td class="table-title">
         <c:forEach begin="1" end="${b.bindent}" step="1">
         <img src="/images/reply.png" style="width:17px">
         </c:forEach>
         <a href="bview?bno=${b.bno}">${b.btitle }</a> &nbsp;&nbsp;
         <c:if test="${b.bfile != null }"><img src="/images/img.png" style="width:17px"></c:if>
        </td>
        <td>${b.id }</td>
        <td>${b.bdate }</td>
        <td>${b.bhit }</td>
      </tr>
      </c:forEach>
    </table>
    <ul class="page-num">
    <c:if test="${page!=1}">
      <a href="/board/blist?page=1"><li class="first"></li></a>
    </c:if>
    <c:if test="${page==1}">
      <li class="first"></li>
    </c:if>
    <c:if test="${page>1}">
      <a href="/board/blist?page=${page-1}"><li class="prev"></li></a>
    </c:if>
    <c:if test="${page==1}">
      <li class="prev"></li>
    </c:if>
      
<c:forEach var="p" begin="${startPage}" end="${endPage}" step="1">
   	<c:if test="${p!=page}">
     <a href="/board/blist?page=${p}"><li class="num"><div>${p}</div></li></a>
   	</c:if>
   	<c:if test="${p==page}">
   		<li class="num"><div>${p}</div></li>
   	</c:if>
</c:forEach>

    <c:if test="${page<maxPage}">
      <a href="/board/blist?page=${page+1}"><li class="next"></li></a>
    </c:if>
    <c:if test="${page==maxPage}">
      <li class="next"></li>
    </c:if>
    <c:if test="${page!=maxPage}">
      <a href="/board/blist?page=${maxPage}"><li class="last"></li></a>
    </c:if>
    <c:if test="${page==maxPage}">
      <li class="last"></li>
    </c:if>
      
      
    </ul>

    <a href="bwrite"><div class="write">쓰기</div></a>
  </section>

</body>
</html>
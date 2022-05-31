<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-23
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%-- forEach쓸때 필요한 테그 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  <%--  날짜 forEach쓸때 필요한 테그 --%>
<html>
<head>
    <title>Title</title>
    <link rel ="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<h2>글목록 페이지 list.jsp</h2>
<table class="container">
    <tr class="Table">
    <tr>
        <th>글번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>작성시간</th>
        <th>내용</th>
        <th>작성시간</th> <%--(fmt적용) --%>
        <th>조회수</th>
    </tr>
    <c:forEach items="${boardList}" var="board">
        <tr>
            <td>${board.id}</td>
            <td>${board.boardWriter}</td>
            <td><a href="/board/detail?id=${board.id}">${board.boardTitle}</a></td> <%-- 제목에 링크 걸기 작업 --%>
            <td>${board.boardCreatedDate}</td>
            <td>${board.boardContents}</td>
                <%-- 날짜출력 작업 --%>
            <td><fmt:formatDate  pattern="yyyy-MM-dd hh:mm:ss" value="${board.boardCreatedDate}"></fmt:formatDate></td>
            <td>${board.boardHits}</td>
        </tr>

    </c:forEach>
</table>
</body>

</html>

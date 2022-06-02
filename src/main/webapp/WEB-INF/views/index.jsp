<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">


</head>
<body>
<jsp:include page="./layout/header.jsp" flush="false"></jsp:include>
<h2>회원게시판 시작페이지</h2>
<c:if test="${sessionScope.loginId ==null}">
<a href="/member/save-form">회원 가입 </a> <br>
</c:if>
</body>

</html>

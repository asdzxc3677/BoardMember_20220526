<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>로그인 페이지</h2>
    <form action="/member/login" method="post">
        <input type="text" name="memberId" placeholder="아이디">
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="submit" value="로그인">
    </form>

</body>
</html>

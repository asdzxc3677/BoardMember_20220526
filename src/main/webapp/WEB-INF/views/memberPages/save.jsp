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
<h2>회원가입 페이지</h2>
<div class="container">
    <form action="/save" method="post">
    계정: <input type="text" onblur="duplicateCheck()" id="memberId" name="memberId" placeholder="아이디"><br>
    <span id="dup-check-result"></span>
    비번: <input type="text" name="memberPassword" placeholder="비번"><br>
    이름: <input type="text" name="memberName" placeholder="이름"><br>
    나이: <input type="text" name="memberAge" placeholder="나이"><br>
    폰번호: <input type="text" name="memberPhone" placeholder="폰번호">
        <input type="submit" value="회원가입">
    </form>
</div>
</body>
</html>

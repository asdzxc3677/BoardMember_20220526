<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">


</head>
<body>
<h2>회원게시판 시작페이지</h2>
<a href="/member/save-form">회원 가입 </a> <br>
<a href="/member/login-form">로그인 하라</a> <br>
<a href="/member/findAll">신상정보 </a> <br>
<button class="btn btn-outline-success" onclick="paging()">페이징목록</button>

</body>
<script>
    const paging = () =>{
        location.href = "/board/paging";
    }
</script>
</html>

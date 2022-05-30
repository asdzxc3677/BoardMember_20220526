<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-23
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">

</head>
<body>
<jsp.include page="../layot/header.jsp" flush=""false></jsp.include>
<div class="container">
    <h2 class="display-4 fw-normal">saveFile.jsp</h2>
    <div class="py-5 text-center">

        <form action="/board/saveFile" method="post" enctype="multipart/form-data">
            <input class="form-control mb-2" type="text" name="boardTitle" placeholder="제목"><br>
            <input class="form-control mb-2" type="text" name="boardWriter" placeholder="작성"><br>
            <input class="form-control mb-2" type="text" name="boardPassword" placeholder="비번"><br>
            <textarea class="form-control mb-2" name="boardContents" rows="5" cols="10" placeholder="내용"></textarea>
            첨부파일:<input type="file" name="boardFile">
            <input class="btn btn-primary" type="submit" name="boardContents" placeholder="글작성"><br>
        </form>
    </div>
</div>
</body>
</html>

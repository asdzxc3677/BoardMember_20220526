<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<h2>업데이트(수정)update.jsp</h2>
<form action="/board/update" method="post" name="updateForm">
    <input type="text" name="id" value="${boardUpdate.id}" class="form-control" readonly><br>
    <input type="text" name="boardTitle" value="${boardUpdate.boardTitle}" class="form-control"><br>
    <input type="text" name="boardPassword" id="passwordConfirm" class="form-control" placeholder="비번"><br>
    <input type="text" name="boardWriter" value="${boardUpdate.boardWriter}" class="form-control" readonly><br>
    <textarea name="boardContents" id="" cols="30" rows="10">${boardUpdate.boardContents}</textarea><br>
    <input type="button" class="btn btn-danger" value="수정" onclick="boardUpdate()"><br>
</form>
</body>
<script>
    const boardUpdate = () => {
        const passwordConfirm = document.getElementById("passwordConfirm").value;
        const passwordDB = '${boardUpdate.boardPassword}';
        if(passwordConfirm == passwordDB){
            updateForm.submit();
        }else{
            alert("비번이 틀립니다.")
        }
    }
</script>
</html>

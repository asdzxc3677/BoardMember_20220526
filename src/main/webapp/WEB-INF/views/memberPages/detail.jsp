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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<h2>내정보 datail.jsp</h2>
<a href="/">index 시작페이지로 이동</a><br>
<div class="container">
    <table class="table">
        <tr>
            <th>회원번호</th>
            <th>아이디</th>
            <th>비번</th>
            <th>이름</th>
            <th>나이</th>
            <th>폰번호</th>
            <th>정보수정</th>
            <th>삭제</th>
        </tr>
            <tr>
                <td>${member.id}</td>
                <td>${member.memberId}</td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberPhone}</td>
                <td><button class="btn btn-outline-info" onclick="update()">정보수정</button></td>
                <td><button class="btn btn-primary" id="delete" onclick="deleteMember()">탈퇴</button></td>
                    <%-- 클릭한 회원의 정보를 DB에서 가져와서 detail.jsp에 출력 --%>
            </tr>
    </table>

    <div id="detail">

    </div>
</div>
</body>
<script>
    function update() {
        location.href="/member/update-form";
    }
    function deleteMember() {
        let result = confirm("회원탈퇴?")
        const memberId = "${member.id}";
        if(result){
        location.href="/member/delete?id=" + memberId;
            alert("끄지라")
        }else {
            alert("어딜도망가려고")
        }
    }
</script>
</html>

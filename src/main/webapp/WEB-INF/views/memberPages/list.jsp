<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
    <h2>회원조회 list.jsp</h2>
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
                <th>ajax 조회</th>
                <th>삭제</th>
            </tr>
            <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>${member.memberId}</td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberPhone}</td>
                <td><button class="btn btn-outline-info" onclick="detailByAjax('${member.id}')">조회</button></td>
                <td><a href="/member/delete?id=${member.id}">삭제</a></td>
                    <%-- 클릭한 회원의 정보를 DB에서 가져와서 detail.jsp에 출력 --%>
            </tr>
            </c:forEach>
        </table>

        <div id="detail">

        </div>
    </div>
</body>
<script>
    const detailByAjax = (id) => {
        console.log(id);
        const detail = document.getElementById("detail");
        $.ajax({
            type: "get",
            url: "detail-ajax",
            data: {"id": id},
            dataType: "json",
            success: function (result) {
                let output = "<table class='table'>";
                output += "<tr>" +
                    "<th>회원번호</th> <th>아이디</th> <th>비번</th> <th>이름</th>" +
                    "<th>나이</th> <th>폰번호</th> " +
                    "</tr>";
                output += "<tr>";
                output += "<td>" + result.id                  + "</td>";
                output += "<td>" + result.memberId            + "</td>";
                output += "<td>" + result.memberPassword      + "</td>";
                output += "<td>" + result.memberName          + "</td>";
                output += "<td>" + result.memberAge           + "</td>";
                output += "<td>" + result.memberPhone         + "</td>";
                output += "</tr>";
                output += "</table>";

                detail.innerHTML = output;
            },
            error: function () {
                alert("오타체크");
            }
        });

    }

</script>
</html>

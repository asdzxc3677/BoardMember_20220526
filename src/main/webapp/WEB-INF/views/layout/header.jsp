<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-23
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 역할 : c테그의 if문.for문 같은 조건문,반복문 등을 쓸수 있는 링크이다. --%>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/board/paging" class="nav-link px-2 text-white">글목록</a></li>
                <c:if test="${sessionScope.loginId !=null }">   <%-- 사용용도: 로그인했을때에만 글쓰기,수정등 보이게 하는 기능이다. .--%>
                <li><a href="/board/saveFile" class="nav-link px-2 text-white">글쓰기</a></li>
                </c:if> <%-- <c:if></c:if> 써주면 2줄 라인의 기능을 묶을수 있다.   --%>


            </ul>
            <div class="text-end">
                <c:if test="${sessionScope.loginId ==null}">
                <button type="button" class="btn btn-outline-light me-2" onclick="login()">Login</button>
                </c:if>
                <button type="button" class="btn btn-warning" onclick="logout()">로그아웃</button>

                <c:if test="${sessionScope.loginId == 'admin'}">  <%-- 관리자만 보일수 있게 하는 문법이다. --%>
                <button type="button" class="btn btn-warning" onclick="memberList()">회원신상정보</button>
                </c:if>

                <c:if test="${sessionScope.loginId !=null and sessionScope.loginId !='admin'}">  <%-- 개인회원은 '나의정보' 라는것이 보이지만 관리자는 안보이게 처리하였다. --%>
                <button type="button" class="btn btn-warning" onclick="detail()">나의정보</button>
                </c:if>
            </div>
        </div>
    </div>
</header>
</body>
<script>
const login = () => {
    location.href="/member/login-form";
}
const logout = () => {
    location.href="/member/logout";
}
const memberList = () =>{
    location.href="/member/findAll";
}
const detail = () =>{
    location.href="/member/detail";
}  <%-- 개인회원은 '나의정보' 라는것이 보이지만 관리자는 안보이게 추가 --%>
</script>
</html>








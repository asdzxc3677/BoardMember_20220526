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
    <script src="/resources/js/jquery.js"></script>

</head>
<body>
<h2>회원가입 페이지</h2>
<div class="container">
    <form action="/member/save" method="post">
    계정: <input type="text" onblur="duplicateCheck()" id="memberId" name="memberId" placeholder="아이디"><br>
    <p id="dup-check-result"></p>
    비번: <input type="text" id="memberPassword" name="memberPassword" placeholder="비번"><br>
    이름: <input type="text" id="memberName" name="memberName" placeholder="이름"><br>
    나이: <input type="text" id="memberAge" name="memberAge" placeholder="나이"><br>
    폰번호: <input type="text" id="memberPhone" name="memberPhone" placeholder="폰번호">
        <input type="submit" value="회원가입">
    </form>
</div>
</body>
<script>
    const duplicateCheck = () => {
        const memberId = document.getElementById("memberId").value;
        const checkResult  = document.getElementById("dup-check-result");
        $.ajax({
            type:"post",
            url:"/member/duplicate-check",
            data:{"memberId":memberId},
            dataType:"text",
            success: function (result){
                if(result == "ok"){
                    checkResult.innerHTML ="사용가능한 아이디 입니다."
                    checkResult.style.color = "green";
                }else {
                    checkResult.innerHTML = "이미사용한 아이디 입니다."
                    checkResult.style.color = "red";
                }
                alert("ajax 성공");
            },
            error: function (){
                alert("오타체크");
            }
        });
    }
</script>
</html>

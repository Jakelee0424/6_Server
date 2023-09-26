<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원 탈퇴</title>

    <link rel="stylesheet" href="/resources/css/main.css" type="text/css">
</head>

<body>

    <p class="signupTitle">
        회원 탈퇴
    </p>
    
    <c:if test="${not empty sessionScope.msg}">

		<script>
			alert('${msg}')
		</script>

		<c:remove var="msg" scope="session"/>

	</c:if>
	


    <form action="/deleteMem" method="post" onsubmit="return pwCheck()">

        <fieldset class="pwCheckContainer">

            <p>비밀번호</p>
            <input type="password" name="pwForDelete" id="pwForDelete">

            <p>비밀번호 확인</p>
            <input type="password" name="checkPwForDelete" id="checkPwForDelete">

            <br>

            <button class="signupBtn">탈퇴하기</button>

        </fieldset>

    </form>


    <script src="/resources/js/signup.js"></script>
</body>

</html>
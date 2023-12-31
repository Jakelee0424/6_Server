<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>todoList메인화면</title>

<link rel="stylesheet" href="/resources/css/main.css" type="text/css">
</head>

<body>

	<c:if test="${not empty sessionScope.msg}">

		<script>
			alert('${msg}')
		</script>

		<c:remove var="msg" scope="session"/>

	</c:if>
	
	<c:choose>

		<c:when test="${empty sessionScope.member}">

			<p>투 두 리스트 로그인</p>

			<form action="/login" method="post">

				<fieldset class="loginContainer">

					<div>
						<p>아이디</p>
						<input type="text" name="inputId">
					</div>

					<div>
						<p>패스워드</p>
						<input type="password" name="inputPw">
					</div>

					<button class="loginBtn">로그인</button>


					<a href="/signup">회원가입</a>

				</fieldset>

			</form>

		</c:when>

		<c:otherwise>

			<p id="todolistTitle">${member.memberNickname}의 투두 리스트</p>

			<span>
				
				
				<table class="todoTable">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>할일</th>
						<th>작성 일시</th>
						<td style="display: none;"></td>
						<td style="display: none;"></td>
					</tr>
					
					<c:forEach var="todo" items="${list}" varStatus="vs">
						<tr>
							<td>${vs.count}</td>
							<td>${todo.todoTitle}</td>
							<td>${todo.todoMemo}</td>
							<td>${todo.todoDate}</td>
							<td class="todoBtn"><a href="/update?index=${vs.index}&todoNo=${todo.todoNo}" id="updateBtn">수정</a></td>
							<td class="todoBtn"><a href="/delete?index=${vs.index}" id="deleteBtn">삭제</a></td>
						</tr>
						<!-- <div class="todo-div${vs.index}&todoNo=${todo.todoNo}">
							${vs.count}. ${todo.todoTitle} (${todo.todoMemo}) 
							${todo.todoDate}  
							<a href="/update?index=${vs.index}&todoNo=${todo.todoNo}" id="updateBtn">수정</a>
							<a href="/delete?index=${vs.index}" id="deleteBtn">삭제</a>
						</div> -->
						
					</c:forEach>
					
				</table>
			</span>

			<div class="btn">

				<a href="/deleteAll" id="deleteAll">전체&nbsp;삭제</a>
				<a href="/insert" id="insertBtn">등록하기</a>
				<a href="/logout" id="logoutBtn">로그아웃</a>
				<a href="/deleteMem" id="deleteMem">회원&nbsp;탈퇴</a>

			</div>

		</c:otherwise>



	</c:choose>




	
</body>

</html>
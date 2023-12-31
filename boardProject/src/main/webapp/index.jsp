<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="/resources/css/main-style.css" type="text/css">
		<script src="https://kit.fontawesome.com/b2efae0e57.js" crossorigin="anonymous"></script>
	</head>

	<body>
		<main>
			
			<%-- header.jsp 추가 --%>

			<%-- 

				<jsp:include page="jsp파일경로" />

				- jsp 파일 경로는 webapp 폴더 기준 작성
				- jsp 액션 태그(jsp에 기본 내장)
				- 다른 jsp 파일의 코드를 현재 위치에 추가

			--%>

			<jsp:include page ="/WEB-INF/views/common/header.jsp"/>


			<section class="content">
				
				<section class="content-1">

					<h3>로그인된 회원 정보</h3>




				</section>

				<section class="content-2">

					<c:choose>

						<%-- 로그인 안되었을때 --%>
						<%-- EL empty : 비어있거나 null --%>
						<c:when test="${empty sessionScope.member}">


							<form action="/member/login" name="login-form" id="loginFrm" method="post">

								<fieldset class="id-pw-area">
		
									<section>
										<input type="text" name="inputEmail" placeholder="이메일">
										<input type="password" name="inputPw" placeholder="비밀번호">
									</section>
		
									<section>
										<button>로그인</button>
									</section>
		
								</fieldset>
		
								<label for="saveId">
									<input type="checkbox" name="saveId">아이디 저장
								</label>
		
								<section class="signup-find-area">
									<a href="#">회원가입</a>
									<span>|</span>
									<a href="#">ID/PW 찾기</a>
								</section>
		
							</form>
	
						</c:when>


						<%-- 로그인 되었을 때 --%>
						<c:otherwise>
							
							<article class="login-area">
							
								<a href="#">
									<img src="/resources/images/user.png" id="memberProfile" alt="">
								</a>

								<div class="my-info">
									<div>
										<a href="#" id="nickname">${session.member.memberNickname}</a>
										<a href="/member/logout" id="logoutBtn">로그아웃</a>
									</div>

									<p></p>
								</div>
								
							</article>


						</c:otherwise>

					</c:choose>


				</section>

			</section>

			<jsp:include page ="/WEB-INF/views/common/footer.jsp"/>

		</main>

	</body>

	</html>
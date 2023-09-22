<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>

		<body>

			<jsp:include page="/WEB-INF/views/common/header.jsp" />
				<section class="search-page">
					<p>"${param.query}"로 검색한 결과입니다.</p>
				</section>

			<c:choose>

				<c:when test="${empty list}">
					<p>${msg}</p>
				</c:when>

				<c:otherwise>

					<c:forEach var="mem" items="${list}">
						<div class="search-div">
							유저 닉네임 : ${mem.memberNickname}<br>
							유저 이메일 : ${mem.memberEmail}<br>
							전화번호 : ${mem.memberTel}<br>
						</div>

					</c:forEach>

				</c:otherwise>

			</c:choose>


		</body>

		</html>
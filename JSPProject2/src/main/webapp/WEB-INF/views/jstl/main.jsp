<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%--
    <%@ %> : 지시자 태그
    taglib : 태그 라이브러리 추가
    prefix : 태그명 앞에 작성되는 단어 <c:if> (c = core)
    uri(Uniform Resource Identifier, 통합 자원 식별자) -> 자원을 식별하는 고유문자열(ID)
    
    * 참고 * 
    url(Uniform Resource Location)

--%>


<!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>JSTL(JSP Standard Tag Library)</title>
    </head>

    <body>

        <!-- 
            현재 경로 : localhost:8080/jstl/main 
                        index -> jstl/main
            목표 경로 : localhost:8080/jstl/condition
        -->
        <a href="condition">JSTL을 이용한 조건문(if / choose, when, otherwise)</a> <br>

        <a href="loop">JSTL을 이용한 반복문</a> <br>

        <!-- 
            Controller -> Service -> DAO -> DB 
        -->
        <a href="student/selectAll">workbook에서 학생 전체 조회하기</a> <br>

		<a href="student/select">workbook에서 건축공학과인 학생만 찾기</a>
        
        <form action="/deptSelect" method="get">

            학과명 : <input type="text" name="dept">
            <button>제출</button>


        </form>


        <h1>JSTL(JSP Standard Tag Library)</h1>

        <pre>
            JSP에서 자주 사용되거나 공통적으로 사용되는 
            java 코드 (if, for, 변수 선언, 형변환)에 대해

            스크립틀릿 대신 html 태그 형식을 태그화 하여 
            표준으로 제공하는 라이브러리
        </pre>

        <h3>JSTL 라이브러리 등록 방법</h3>

        <ol>
            <li>JSTL 다운로드 (https://tomcat.apache.org/download-taglibs.cgi)</li>
            <li>/webapp/WEB-INF/lib 폴더에 추가(.jar 파일)</li>
            <li>JSTL 라이브러리를 사용하고자 하는 JSP 파일 상단에
                taglib JSP 지시자 태그를 추가    
            </li>
        </ol>

        <hr>

        <h1>1. 변수 선언 (c:set 태그)</h1>

        <pre>
            - 변수 선언을 위한 태그
            
            - c:set에 작성 가능한 속성
            1) var : 변수명(속성 key)
            2) value : 대입할 값
            3) scope : page, request, session, applicaiton 중 하나 지정
                       (기본값 = page)
        </pre>

        <% pageContext.setAttribute("num1", 10); %> 

        <%--JSTL로 page scope에 속성 세팅하는 방법 --%>

        <c:set var="num2" value="20" scope="page"/>

		num1 : ${num1}
		<br>
		num2 : ${num2}

        <hr>

        <h1>2. 변수 제거 (c:remove)</h1>

        <pre>
            - 변수 제거 : 내장 객체에 세팅된 속성을 제거
            (removeAttribute())

            - c:remove 속성
            1) var : 삭제할 변수명
            2) scope : 내장 객체 범위(기본값 = 모든 scope)
        </pre>

        <% pageContext.removeAttribute("num1"); %> 

        num1 제거 확인 : ${num1} <br>

        <c:remove var="num2" />
        
        num2 제거 확인 : ${num2}

        <hr>

        <h1>3. 변수 출력 (c:out)</h1>

        <pre>
            EL구문과 비슷

            escapeXml="true"(기본값) 설정시 html 태그 해석 X
            escapeXml="false" : html 태그 해석 O
        </pre>


        <c:set var="temp" value="<h1>안녕</h1>"/>

        html 태그 해석 x : <c:out value="${temp}"/> <br>
        html 태그 해석 o : <c:out value="${temp}" escapeXml="false" />


        <hr><hr>




    </body>

    </html>
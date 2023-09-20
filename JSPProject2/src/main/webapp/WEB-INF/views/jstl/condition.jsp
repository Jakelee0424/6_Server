<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>JSTL 조건문</title>
        </head>

        <body>

            <h1>4. 조건문 - if(c:if 태그)</h1>

            <pre>
                - 단독 if 문 (else 없음)
                - 속성은 test만 존재

                ** 주의사항 **
                1) test의 속성값은 무조건 EL구문으로 작성
                2) test의 속성값은 true 또는 false가 나오는 조건식이어야함
                3) test의 속성값을 작성하는 " 사이에는 앞뒤 공백이 존재하면 안됨
            </pre>

            request에 세팅된 name : ${name}
            <br>
            request에 세팅된 money : ${money}
            <br>

            <c:if test="${money == 50000}">
                <h3 style="color: gold;">돈이 5만원 있습니다.</h3>
            </c:if>
            
            <h3>EL에서 모든 비교는 == 또는 eq //// != 또는 ne</h3>
            <h3>EL에서 문자열은 ''(홑따옴표) 로 표현</h3>
            
            <c:if test="${money eq 50000}">
                <h3 style="color: gold;">eq!</h3>
            </c:if>

            <c:if test="${name eq '홍길동'}">
                <h3 style="color: rebeccapurple;">홍길동 등장!</h3>
            </c:if>

            <c:if test="${name ne '홍길순'}">
                <h3 style="color: rebeccapurple;">홍길동 등장!</h3>
            </c:if>

            <hr>

            <h1>5. 조건문 - choose, when, otherwise</h1>

            <pre>
                choose : when, otherwise 태그를 감싸는 역할
                        (이 안에 if, else if, else와 같은 조건문을 쓰겠다 통보)
                
                when : if, else if 역할의 태그
                        속성은 test 한 개
                
                otherwise : else 역할, 속성 x        

                <%--
                lt(little) : <
                gt(greater) : >
                le(little or equal) : <=
                ge(greater or equal) : >=
                --%>

            </pre>

            <%-- queryString : 주소에 작성된 파라미터 문자열 --%>

            <%-- choose안에서는 %주석만 가능 --%>
            <c:choose>
                <c:when test="${param.val gt 100}">
                        100 초과
                </c:when>

                <c:when test="${param.val < 100}">
                        100 미만
                </c:when>

                <c:otherwise>
                        100과 같음
                </c:otherwise>
            </c:choose>

            <br><br>


            <hr>
            <button onclick="history.back()">돌아가기</button>


        </body>

        </html>
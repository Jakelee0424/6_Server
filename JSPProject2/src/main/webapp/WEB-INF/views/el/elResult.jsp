<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>EL 결과</title>
    </head>

    <body>

        <h1>EL을 이용해서 출력하기</h1>

        <h3>파라미터</h3>
        <ul>
            <li>\${param.name속성값} : request에 담긴 파라미터 얻어오기</li>
            <li>\${paramValues} : 모든 파라미터를 배열로 얻어오기</li>
            <li>\${paramValues.name속성값[인덱스]}:
                name이 일치하는 파라미터 중 지정된 인덱스 번째 value
            </li>
        </ul>

        <p>
            이름 : ${param.inputName} <br>
            나이 : ${param.inputAge} <br>

            option : ${param.opt}  -> \${param.opt}<br> <!-- 0번째 인덱스만-->
            option : ${paramValues.opt} -> \${paramValues.opt}  <br>
            option : ${paramValues.opt[0]} -> \${paramValues.opt[0]} <br>
            option : ${paramValues.opt[1]} -> \${paramValues.opt[1]} <br>
            option : ${paramValues.opt[2]} -> \${paramValues.opt[2]} <br>
            option2 : ${param.opt2} <br>
        </p>

        <hr>

        <h3>속성(Attribute)</h3>

        <ul>
            <li>기본 : \${ key } (key는 세팅한 속성의 key)</li>
            <li>배열 또는 List : \${ key[index] } </li>
            <li>dto 또는 Map : \${ key.필드명 }</li>
        </ul>

        <p>
            address(JSP) : request.getAttribute("address") <br>
            address(JSP) : <%= request.getAttribute("address") %> <br>
            address(EL) : \${address} <br>
            address(EL) : ${address} <br>

            score : ${score} <br>
            strList : ${strList}<br>
            strList[0] : ${strList[0]}<br>
            strList[1] : ${strList[1]}<br>
            strList[2] : ${strList[2]}<br>
            book : ${book}<br>

            book의 title : ${book.title}<br>
            <!-- book의 title(jsp) : <%-- <%= ((Book)request.getAttribute("book")).getTitle() %> --%><br> -->
            book의 writer : ${book.writer}<br>
            book의 price : ${book.price}<br>
        </p>

        <hr>

        <h3>EL은 null, 비어있다를 같은 것으로 생각</h3>
        
        ${List} / ${list2}
        
        <h4>empty 연산자</h4>
        
        ${empty List} / ${empty list2}

        

    </body>

    </html>
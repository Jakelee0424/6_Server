<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert todo</title>

            <link rel="stylesheet" href="/resources/css/main.css">
        </head>

        <body>

            <p>To do 등록하기</p>

            <form action="">

                <fieldset>
                    
                    <p>제목</p>
                    <input type="text" name="todoTitle" id="todoTitle">

                    <p>메모</p>
                    <input type="text" name="todoMemo" id="todoMemo">
                    
                    
                </fieldset>
            
                
                <button>등록하기</button>

            </form>


        </body>

        </html>
package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 * @WebServlet 어노테이션
 * -> 해당 클래스를 Servlet으로 등록하고 
 * 	  매핑할 주소를 연결하라고 지시하는 어노테이션 
 * 
 * -> 서버 실행시 자동으로 web.xml에 <servlet><servlet-mapping>을 작성하는 효과
 * 
 * */

@WebServlet("/example2")
public class ExampleController2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String test = "sonar";
		//HttpServletRequest는 요청 데이터를 담은 객체

		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");

		// name 속성 값이 같은 파라미터가 여러개인 경우 
		// String 배열로 한번에 반환 받은 getParameterValues("name") 사용

		String[] optionArr = req.getParameterValues("opt");


		// 응답 코드

		resp.setContentType("text/html; charset=UTF-8");

		// 응답용 스트림(서버 -> 클라이언트) 얻어오기
		PrintWriter out = resp.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head> <title> "+orderer+"님의 주문 결과 </title> </head>");
		out.println("<body>");

		out.println("<h3>주문자명 : " + orderer + "</h3>");

		out.println("<h3>주문한 커피 : ");

		if(type.equals("ICE")) 	out.print("차가운 ");
		else					out.print("따뜻한 ");

		out.print(coffee);
		out.println("</h3>");

		// 옵션이 선택된 경우 출력
		// -> getParameter(), getParameterValues() 수행 시
		// 전달된 값 중 name이 일치하는 값이 없으면
		// null 반환
		if(optionArr != null) {
			out.println("<ul>");

			for(String opt : optionArr) {
				out.println("<li>"+opt+"</li>");
			}

			out.println("</ul>");
		}

		out.println("</body>");
		out.println("</html>");

	}


}

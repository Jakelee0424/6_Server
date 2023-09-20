package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @WebServlet("scope") : 서블릿 매핑에서 유효하지 않은 url
// 매핑할 주소 앞 / 반드시 작성

@WebServlet("/scope")
public class ScopeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/scope/scope.jsp");
		
		// 1. page scope : JSP에서 확인

//-----------------------------------------------------------------		
		
		// 2. request scope : 요청 페이지(servlet) + 위임 페이지(jsp)
		
		req.setAttribute("reqValue", "리퀘스트밸류");
		
//-----------------------------------------------------------------		
		
		// 3. session scope : 브라우저 당 1개
		//					-> 브라우저 종료 or session 만료까지 유지
		
		
		// session 객체 얻어오기
		HttpSession session = req.getSession();
		
		session.setAttribute("sessionValue", "세션밸류");
		
//-----------------------------------------------------------------		

		// 4. application scope : 서버가 켜져있는 동안 유지
		
		// application 객체 얻어오기 -> req, session 객체에서 얻어오기 가능
		// req.getServletContext();
		ServletContext application = session.getServletContext();
		
		application.setAttribute("appValue", "앱밸류");
		
//-----------------------------------------------------------------		
		
		// 모든 스코프는 속성을 세팅하고 얻어오는 방법이 동일
		
//-----------------------------------------------------------------		
		
		// 모든 범위에 같은 key로 속성 세팅
		
		req.setAttribute("str", "request범위에 세팅된 문자열");
		session.setAttribute("str", "session범위에 세팅된 문자열");
		application.setAttribute("str", "application범위에 세팅된 문자열");
		
		
		
		dispatcher.forward(req, resp);
	
	}
	
}

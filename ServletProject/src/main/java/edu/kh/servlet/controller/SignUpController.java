package edu.kh.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전달받은 값을 얻어와서 확인
		// -> 한글이 깨지는 문제 발생
		// 요청데이터 문자 인코딩 vs 서버 인코딩이 다름
		
		// 해결방법 : 전달 받은 데이터의 문자 인코딩을 서버에 맞게 변경 (UTF-8)
		req.setCharacterEncoding("UTF-8");
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		String intro = req.getParameter("intro");
		
		// 응답화면 만들기
		// java에서 작성 어려움 -> JSP가 대신 화면 만들어서 응답
		
		// JSP가 대신 화면을 만들기 위해 servlet이 어떤 요청을 받았는지 알아야함
		// -> servlet이 받은 요청을 JSP로 위임하는 작업 진행
		
		// 클라이언트에서 직접 접근 불가 폴더(WEB-INF 폴더)
		// 에 jsp로 파일을 작성
		// 후 servlet이 받은 요청을 jsp로 위임하는 작업을 진행
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		
		dispacher.forward(req, resp);
		
	
	}
}

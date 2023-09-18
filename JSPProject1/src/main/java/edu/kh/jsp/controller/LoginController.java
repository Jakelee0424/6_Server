package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") // 현재 클래스를 servlet으로 등록 + /login 요청 처리
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
	
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		
		String msg = null;
		
		if(id.equals("user01") && pw.equals("pass01")) {
			msg = "로그인 성공";
		}else {
			msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
		}
		
		
		// servlet 으로 응답 화면 만들기 힘듬
		// jsp로 위임
		
		// **jsp 경로 작성 방법**
		// -> webapp 기준으로 작성
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		// msg 값을 속성으로 추가
		req.setAttribute("msg", msg);
		
		// forward : 주소창이 요청 주소로 바뀌고
		// 그 요청에 맞는 화면으로 변환 -> 요청에 맞는 응답을 했기 때문
		
		// servlet이 가지고 있던 req, resp 객체를 JSP에게 전달하여 요청을 위임 
		dispacher.forward(req, resp);
		
		
		// ctrl + shift + r :강력새로고침
	}
}


// 서버 실행 -> web.xml -> index.html 
// -> form태그의 action으로 요청 보냄(value값과 함께(parameter) 
// -> @WebServlet(action 주소)로 처리
// -> jsp로 위임(RequestDispatcher, forward) (밸류값을 담은 request 객체와 함께)
// -> jsp 코드로 결과 반환



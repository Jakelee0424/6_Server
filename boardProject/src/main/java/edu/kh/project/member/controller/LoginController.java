package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import edu.kh.project.model.dto.Member;
import edu.kh.project.model.service.MemberService;


@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	
	MemberService service = new MemberService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			req.setCharacterEncoding("UTF-8");

			String inputEmail = req.getParameter("inputEmail");
			String inputPw = req.getParameter("inputPw");
			
			Member member =  service.login(inputEmail, inputPw);
			
			HttpSession session = req.getSession();
			
			if(member != null) {
				session.setAttribute("member", member);
			
				// 세션 만료 시간 지정(초단위 지정)
				session.setMaxInactiveInterval(60*60);

				resp.sendRedirect("/"); // 메인페이지 재요청
				
				// forward : 요청 처리 후 자체적 화면 존재하여 
				//			  이를 이용해서 응답
				
				// Redirect : 요청 처리 후 자체적인 화면이 없어서 
				//			  화면이 있는 다른 요청을 다시 호출
				
			}else{
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	
	}
}

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
				
				// 로그인 실패시 메시지를 session에 추가
				session.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
				
				// 현재 요청 이전 페이지로 redirect
				String referer = req.getHeader("referer");
				// referer = 각 페이지 방문시 남는 흔적
				// requeset.getHeader() : 안에 파라미터로 referer 전달시 이전페이지 주소값 반환
				
				resp.sendRedirect(referer);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	
	}
}

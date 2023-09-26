package edu.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;

@WebServlet("/deleteMem")
public class DeleteMemController extends HttpServlet {

	MemberService service = new MemberService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/deleteMem.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {


			HttpSession session = req.getSession();

			Member member = (Member)session.getAttribute("member");

			int memberNo = member.getMemberNo();
			String pwForDelete = req.getParameter("pwForDelete");

			int result = service.deleteMem(memberNo, pwForDelete);

			if(result > 0) {

				session.setAttribute("msg", "탈퇴가 완료되었습니다.");

				session.invalidate();

				resp.sendRedirect("/");

			} else {
				
				session.setAttribute("msg", "비밀번호를 잘못 입력하셨습니다.");
				
				resp.sendRedirect("/");
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}

	}



}

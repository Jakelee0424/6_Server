package edu.kh.project.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.project.model.dto.Member;
import edu.kh.project.model.service.MemberService;

@WebServlet("/search")
public class SearchController extends HttpServlet{

	MemberService service = new MemberService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Member> list = new ArrayList<Member>();
		
		try {
			
			String query = req.getParameter("query");
			
			list = service.searchUser(query);
			
			req.setAttribute("query", query);
			req.setAttribute("list", list);
			req.setAttribute("msg", "검색결과가 없습니다.");
				
			req.getRequestDispatcher("/WEB-INF/views/searchUser.jsp").forward(req, resp);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}

package edu.kh.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.member.model.dto.Member;
import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{

	TodoService service = new TodoService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			
			Todo todo = (Todo) session.getAttribute("r");
			
			int result = service.delete();
		
		if(result > 0) {
			
			session.setAttribute("msg", "삭제되었습니다.");
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
}


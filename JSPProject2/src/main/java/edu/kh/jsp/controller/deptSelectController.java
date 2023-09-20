package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;


@WebServlet("/deptSelect")
public class deptSelectController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentService service = new StudentService();
		
		String dept = req.getParameter("dept");
		
		try {
		
		List<Student> list = service.deptSelect(dept);
		
		req.setAttribute("list", list);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		req.getRequestDispatcher("/WEB-INF/views/student/deptSelect.jsp").forward(req, resp);
		
	}
	
}

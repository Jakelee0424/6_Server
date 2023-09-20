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

@WebServlet("/jstl/student/select")
public class SelectController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentService std = new StudentService();
		
		try {
		
		List<Student> archStd = std.archSelect();
		req.setAttribute("archStd", archStd);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/views/student/archSelect.jsp").forward(req, resp);
		
	}
	
}

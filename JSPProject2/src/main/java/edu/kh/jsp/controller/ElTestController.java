package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Book;

@WebServlet("/elTest") // 절대경로
public class ElTestController extends HttpServlet{

	// form태그의 전달 방식에 따라 알아서 읽음
	
	// a태그 : get방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp");
		dispatcher.forward(req, resp);
			
	}
	
	// form태그 : post방식
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
// ---------------------------------------------------------------------
		
		req.setAttribute("address", "서울시 중구 남대문로 120");
		req.setAttribute("score", 100);
		
// ---------------------------------------------------------------------
		
		List<String> strList = new ArrayList<String>();
		strList.add("가가");
		strList.add("나나");
		strList.add("다다");
	
		req.setAttribute("strList", strList);
		
// ---------------------------------------------------------------------
		
		Book book = new Book("어린왕자", "생텍쥐베리", 4000);
		
		req.setAttribute("book", book);

// ---------------------------------------------------------------------

		List<String> list1 = null;
		List<String> list2 = new ArrayList<String>();
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		
		
		// 요청 위임
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/elResult.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
}

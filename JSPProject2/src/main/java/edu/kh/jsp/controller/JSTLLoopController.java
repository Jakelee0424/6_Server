package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Book;

@WebServlet("/jstl/loop")
public class JSTLLoopController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add( new Book("언어의 무게", "파스칼 메르시어", 19000));
		bookList.add( new Book("7년의 밤", "정유정", 15000));
		bookList.add( new Book("28", "정유정", 13000));
		bookList.add( new Book("노르웨이의 숲", "무라카미 하루키", 30000));
	
		req.setAttribute("bookList", bookList);
		
		req.getRequestDispatcher("/WEB-INF/views/jstl/loop.jsp").forward(req, resp);
	}
	
	
}

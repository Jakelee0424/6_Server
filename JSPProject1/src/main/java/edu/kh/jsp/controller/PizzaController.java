package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.kh.jsp.model.dto.Pizza;

@WebServlet("/pizzaOrder")
public class PizzaController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Pizza> pizzaList = new ArrayList<Pizza>();
		
		pizzaList.add( new Pizza("치즈피자", 8000) );
		pizzaList.add( new Pizza("콤비네이션", 9000) );
		pizzaList.add( new Pizza("핫치킨", 10000) );
		
		req.setCharacterEncoding("UTF-8");
	
		String pizza = req.getParameter("pizza"); //1, 2, 3 중 하나
		String size = req.getParameter("size");
		String amount = req.getParameter("amount");
		
		
		// L사이즈 2000원 추가
		
		// 피자 종류 파악
		// -> pizza(1,2,3)는 문자열 -> 정수로 형변환 파싱
		Pizza p = pizzaList.get(Integer.parseInt(pizza) - 1 );
		
		String pizzaName = p.getName();
		int price = p.getPrice();
		
		if(size.equals("L")) {
			price += 2000;
		}
		price *= Integer.parseInt(amount);
		
		
		req.setAttribute("pizzaName", pizzaName);
		req.setAttribute("price", price);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/pizzaResult.jsp");
		dispatcher.forward(req, resp);
	}
}

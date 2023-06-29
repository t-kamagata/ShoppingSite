package jp.co.aforce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.model.Product;

/**
 * Servlet implementation class Sort
 */
@WebServlet("/controller/sort")
public class Sort extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		
		ProductDAO dao = new ProductDAO();
		List<Product> products = new ArrayList<>();
		
		
		try {
			if(order.equals("asc")) {
				products = dao.getAllAscending(sort);
				request.setAttribute("products", products);
			} else {
				products = dao.getAllDescending(sort);
				request.setAttribute("products", products);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/views/listUser.jsp")
			.forward(request, response);
	}

}

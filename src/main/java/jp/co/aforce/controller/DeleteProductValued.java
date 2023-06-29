package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.model.Product;

/**
 * Servlet implementation class FormValue
 */
@WebServlet("/controller/delete-valued")
public class DeleteProductValued extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ProductDAO dao = new ProductDAO();
		
		Product product = null;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			product = dao.getProduct(id);
		} catch(Exception e) {
			request.setAttribute("message", "入力されたIDは存在しません。");
			request.getRequestDispatcher("../views/complete.jsp")
				.forward(request, response);
			return;
		}
		request.setAttribute("product", product);
		request.getRequestDispatcher("../views/deleteConfirm.jsp")
			.forward(request, response);
	}

}

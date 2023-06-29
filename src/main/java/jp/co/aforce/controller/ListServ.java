package jp.co.aforce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.model.Product;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/controller/list")
public class ListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var dao = new ProductDAO();
		try {
			List<Product> products = dao.getAllProduct();
			request.setAttribute("products", products);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/views/listAdmin.jsp")
			.forward(request, response);
	}

}

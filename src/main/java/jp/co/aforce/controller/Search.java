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
 * Servlet implementation class Search
 */
@WebServlet("/controller/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		var dao = new ProductDAO();
		List<Product> products = new ArrayList<>();
		try {
			String key = request.getParameter("key");
			products = dao.search(key);
			request.setAttribute("products", products);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		if(products.size() == 0) {
			request.setAttribute("message", "該当する商品がありませんでした。");
			request.getRequestDispatcher("/views/fail.jsp")
			.forward(request, response);
		}
		request.getRequestDispatcher("/views/listUser.jsp")
			.forward(request, response);
	}

}

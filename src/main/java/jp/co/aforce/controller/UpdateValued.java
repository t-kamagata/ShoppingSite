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
@WebServlet("/controller/update-valued")
public class UpdateValued extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ProductDAO dao = new ProductDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = null;
		try {
			product = dao.getProduct(id);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("/views/updateProduct.jsp")
			.forward(request, response);
	}

}

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
 * Servlet implementation class Update
 */
@WebServlet("/controller/update-product")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Product product = new Product();
		int id = Integer.parseInt(request.getParameter("id"));
		product.setId(id);
		product.setName(request.getParameter("name"));
		int price = Integer.parseInt(request.getParameter("price"));
		product.setPrice(price);
		int stock = Integer.parseInt(request.getParameter("stock"));
		product.setStock(stock);
		
		
		ProductDAO dao = new ProductDAO();
		try {
			int line = dao.updateProduct(product);
			
			if(line == 1) {
				request.setAttribute("message", "更新が完了しました。");
				var ses =request.getSession();
				ses.setAttribute("products", dao.getAllProduct());
			} else {
				request.setAttribute("message", "更新できませんでした。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../views/adminHome.jsp")
			.forward(request, response);
	}

}

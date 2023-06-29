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
 * Servlet implementation class Create
 */
@WebServlet("/controller/create-product")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setStock(Integer.parseInt(request.getParameter("stock")));
		
		
		ProductDAO dao = new ProductDAO();
		try {
			int line = dao.createProduct(product);
			
			if(line == 1) {
				request.setAttribute("message", "登録が完了しました。");
			} else {
				request.setAttribute("message", "登録できませんでした。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		try {
			var ses = request.getSession();
			ses.setAttribute("products", dao.getAllProduct());
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		request.getRequestDispatcher("/views/completeAdmin.jsp")
			.forward(request, response);
	}

}

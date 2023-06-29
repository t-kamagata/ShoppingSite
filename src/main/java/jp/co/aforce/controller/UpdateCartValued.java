package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.CartDAO;
import jp.co.aforce.model.Cart;

/**
 * Servlet implementation class UpdateCart
 */
@WebServlet("/controller/update-cart-valued")
public class UpdateCartValued extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CartDAO dao = new CartDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Cart cart = null;
		try {
			cart = dao.getCart(id);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("/views/updateCart.jsp")
			.forward(request, response);
	}

}

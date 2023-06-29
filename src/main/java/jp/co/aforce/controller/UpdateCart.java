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
@WebServlet("/controller/update-cart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Cart cart = new Cart();
		int id = Integer.parseInt(request.getParameter("id"));
		cart.setId(id);
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.setQuantity(quantity);
		
		
		CartDAO dao = new CartDAO();
		try {
			int line = dao.updateCart(cart);
			
			if(line == 1) {
				request.setAttribute("message", "更新が完了しました。");
			} else {
				request.setAttribute("message", "更新できませんでした。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../views/complete.jsp")
			.forward(request, response);
	}

}

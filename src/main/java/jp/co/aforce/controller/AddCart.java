package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.CartDAO;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/controller/add-cart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int stock = Integer.parseInt(request.getParameter("quantity"));
		
		CartDAO dao = new CartDAO();
		try {
			dao.addToCart(userId, productId, stock);
			HttpSession ses = request.getSession();
			ses.setAttribute("items", dao.returnCartItems(userId));
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.setAttribute("message", "カートに追加しました。");
		request.getRequestDispatcher("/views/completeCart.jsp")
			.forward(request, response);
	}

}

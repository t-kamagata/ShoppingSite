package jp.co.aforce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.CartDAO;
import jp.co.aforce.model.Cart;
import jp.co.aforce.model.User;
/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/controller/show-cart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		User user = (User) ses.getAttribute("user");
		
		CartDAO dao = new CartDAO();
		
		List<Cart> cartItems = new ArrayList<>();
		try {
			cartItems = dao.returnCartItems(user.getId());
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		ses.setAttribute("items", cartItems);
		request.getRequestDispatcher("/views/cart.jsp")
			.forward(request, response);
	}

}

package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.CartDAO;
import jp.co.aforce.model.User;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/controller/delete-cart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CartDAO dao = new CartDAO();
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int line = dao.deleteFromCart(id);
			HttpSession ses = request.getSession();
			User user = (User) ses.getAttribute("user");
			ses.setAttribute("items", dao.returnCartItems(user.getId()));
			request.setAttribute("message", "削除が完了しました。");
		} catch(Exception e) {
			request.setAttribute("message", "削除に失敗しました。");
		}
		request.getRequestDispatcher("../views/completeCart.jsp")
			.forward(request, response);
	}

}

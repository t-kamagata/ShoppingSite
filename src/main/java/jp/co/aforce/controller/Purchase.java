package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.OrdersDAO;
import jp.co.aforce.model.User;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/controller/purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		User user = (User) ses.getAttribute("user");
		
		OrdersDAO dao = new OrdersDAO();
		try {
			int line = dao.createOrders(user.getId());
			
			if(line == 1) {
				request.setAttribute("message", "購入が完了しました。");
			} else {
				request.setAttribute("message", "購入できませんでした。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../views/complete.jsp")
			.forward(request, response);
	}

}

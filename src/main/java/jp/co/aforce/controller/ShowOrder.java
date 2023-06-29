package jp.co.aforce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.OrdersDAO;
import jp.co.aforce.model.Order;

/**
 * Servlet implementation class ShowOrder
 */
@WebServlet("/controller/show-order")
public class ShowOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrdersDAO dao = new OrdersDAO();
		
		List<Order> orders = new ArrayList<>();
		try {
			orders = dao.getAllOrders();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/views/orders.jsp")
			.forward(request, response);
	}

}

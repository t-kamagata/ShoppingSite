package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.ProductDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/controller/delete-product")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ProductDAO dao = new ProductDAO();
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int line = dao.deleteProduct(id);
			HttpSession ses = request.getSession();
			ses.setAttribute("products", dao.getAllProduct());
			request.setAttribute("message", "削除が完了しました。");
		} catch(Exception e) {
			request.setAttribute("message", "削除に失敗しました。");
		}
		request.getRequestDispatcher("../views/completeAdmin.jsp")
			.forward(request, response);
	}

}

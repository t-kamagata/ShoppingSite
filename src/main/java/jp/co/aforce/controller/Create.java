package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.model.User;
/**
 * Servlet implementation class Create
 */
@WebServlet("/controller/create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		User user = new User();
		user.setLast_name(request.getParameter("last_name"));
		user.setFirst_name(request.getParameter("first_name"));
		user.setMail_address(request.getParameter("mail_address"));
		user.setPassword(request.getParameter("password"));
		user.setPayment(request.getParameter("payment"));
		user.setAddress(request.getParameter("address"));
		user.setBirth_year(Integer.parseInt(request.getParameter("birth_year")));
		user.setBirth_month(Integer.parseInt(request.getParameter("birth_month")));
		user.setBirth_day(Integer.parseInt(request.getParameter("birth_day")));
		
		user.setPhone_number(
				request.getParameter("phone_number")
			);
		user.setIsAdmin(false);
		
		
		UserDAO dao = new UserDAO();
		try {
			int line = dao.createUser(user);
			
			if(line == 1) {
				request.setAttribute("message", "登録が完了しました。");
			} else {
				request.setAttribute("message", "登録できませんでした。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		HttpSession ses = request.getSession();
		ses.setAttribute("user", user);
		
		request.getRequestDispatcher("../views/complete.jsp")
			.forward(request, response);
	}

}

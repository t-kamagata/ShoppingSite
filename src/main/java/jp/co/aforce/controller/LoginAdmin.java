package jp.co.aforce.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/controller/login-admin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		request.setAttribute("error", false);
		String mail_address = request.getParameter("mail_address");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAO();
		try {
			User user = dao.getUser(mail_address, password);
			
			if(Objects.isNull(user)) {
				request.setAttribute("error", true);
				request.setAttribute("mail_address", mail_address);
				request.setAttribute("password", password);
				request.setAttribute("message", "IDまたはパスワードが違います。");
				request.getRequestDispatcher("/views/loginAdmin.jsp")
					.forward(request, response);
				return;
			}
			if(!user.getIsAdmin()) {
				request.setAttribute("error", true);
				request.setAttribute("mail_address", mail_address);
				request.setAttribute("password", password);
				request.setAttribute("message", "管理者権限がありません。");
				request.getRequestDispatcher("/views/loginAdmin.jsp")
					.forward(request, response);
				return;
			}
			HttpSession ses = request.getSession();
			ses.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("message", "ログインしました。");
		request.getRequestDispatcher("/controller/admin-home")
			.forward(request, response);
	}
}

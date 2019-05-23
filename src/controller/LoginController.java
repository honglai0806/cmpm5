package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import modelDAO.CheckLogin;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// 2. Lấy Dữ liệu từ trang Login gồm các trường mà mình nhập vào
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		System.out.println(username);
		System.out.println(password);
		// Tạo ra 1 sesion mục đích để giữ đăng nhập
		HttpSession session = request.getSession();
		// 3. kiểm tra login
		CheckLogin checkLogin = new CheckLogin();
		Users users;

		try {
			// 3.1 Kiểm tra trong database nếu tồn tại usename và password thì cho login vào
			// hẹ thống.
			users = checkLogin.checkLogin(username, password);
			// 3.2 Nếu usename và password đúng thì quay về trang wellcome bao gồm thông tin
			// của user
			if (users != null) {
				session.setAttribute("user", users);
				response.sendRedirect("Wellcome.jsp");

			} else {
				//3.3 Nếu lỗi thì thông báo ra sai tên tài đã tồn tại và quay về trang Login.jsp
				session.setAttribute("error",
						" <i class=\"fas fa-exclamation-triangle\"></i>  Bạn đã Nhập sai tên tài khoản hoặc mật khẩu");
				response.sendRedirect("Login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

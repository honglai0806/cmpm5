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
		// 1. Nhận dữ liệu gửi từ client gồm username và password
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		// Tạo ra 1 sesion mục đích để giữ đăng nhập
		HttpSession session = request.getSession();
		// 2. Khởi tạo User
		Users users;
		try {
			// 3. Gọi phương thức checkLogin để kiểm tra tính đúng đắn của usernme và
			// password trả về user
			CheckLogin check = new CheckLogin();
			users = check.checkLogin(username, password);
			// 3.2 Nếu usename và password đúng thì quay về trang wellcome bao gồm thông tin
			// của user
			if (users != null) {
				// 4.1 Đúng username , password
				
				//4.1.1 Lưu thông tin user
				session.setAttribute("user", users);
				//4.1.2 Chuyển đến trang Welcome
				response.sendRedirect("Welcome.jsp");

			} else {
				// 4.2 Sai username hoặc password
				
				//4.2.1 Thông báo " Bạn đã Nhập sai tên tài khoản hoặc mật khẩu"
				session.setAttribute("error",
						" <i class=\"fas fa-exclamation-triangle\"></i>  Bạn đã Nhập sai tên tài khoản hoặc mật khẩu");
				//4.2.2 Chuyển về trang Login
				response.sendRedirect("Login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

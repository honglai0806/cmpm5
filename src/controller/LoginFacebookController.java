package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.types.User;

import model.RestFB;

@WebServlet("/login-facebook")
public class LoginFacebookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginFacebookController() {
		super();
	}
	// Kiểm tra tài khoản có tồn tại không
		// 2 Hệ thống gửi yêu cầu xác thực với Facebook
				// 3 Hệ thống hiện form yêu cầu đăng nhập tài khoản
				// 4 Người dùng đăng nhập.
				// 5 Hệ thống chứng thực Facebook yêu cầu xác nhận các quyền truy cập thông tin tài khoản.
				// 6 Người dùng cấp quyền cho ứng dụng cá nhân đó.
				// 7 Gửi tham số "code" xác thực và nhận code

				
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//khi đăng nhập thành công sẽ trả về cái code 
		//get code
		String code = request.getParameter("code");
		
		 
		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
			dis.forward(request, response);
		} else {
			//8. Yêu cầu truy cập để lấy thông tin tài khoản từ "code" xác thực.
			String accessToken = RestFB.getToken(code);
			// 10 lấy thông tin tài khoản Facebook thông qua accesssToken
			User user = RestFB.getUserInfo(accessToken);
			//13. Lấy ra id, name
			request.setAttribute("id", user.getId());
			request.setAttribute("name", user.getName());
			//13. Chuyển về trang welcome
			RequestDispatcher dis = request.getRequestDispatcher("Welcome.jsp");
			dis.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

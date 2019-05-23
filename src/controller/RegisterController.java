package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import model.Validate;
import modelDAO.CheckRegister;
import modelDAO.UserDAO;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CheckRegister checkRegister = new CheckRegister();

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// lấy dữ liệu từ trang Rigister
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		Users users = new Users(username, email, pass);
		UserDAO userDAO = new UserDAO();
		Validate validate = new Validate();
		CheckRegister checkRegister = new CheckRegister();
		// quay về trang Rigister khi được gọi đến
		RequestDispatcher dis = request.getRequestDispatcher("Register.jsp");
		// ===================4.Kiểm tra Validate==============
		if (Validate.checkFormatName(username) == false) {
			request.setAttribute("error",
					" <i class=\"fas fa-exclamation-triangle\"></i> Tên Đăng nhập từ 2-50 ký tự (vd: abc) ");
			dis.forward(request, response);

		} else {
			try {
				// ===================5.Kiểm tra trùng Trong DB============================
				if (checkRegister.checkUser(users) == true) {
					request.setAttribute("error",
							" <i class=\"fas fa-exclamation-triangle\"></i> Tên tài khoản đã tồn tại");
					// quay về và lưu lại dữ liệu
					dis.forward(request, response);
				} else {// ===================6.Kiểm tra Validate=====================
					if (!Validate.checkFormatEmail(email)) {
						request.setAttribute("error",
								" <i class=\"fas fa-exclamation-triangle\"></i> Bạn phải nhập đúng định dạng gmail ( vd: abc@gmail.com)");
						// quay về và lưu lại dữ liệu
						dis.forward(request, response);
					} else {
						if (!Validate.checkFormatPass(pass)) {
							request.setAttribute("error",
									" <i class=\"fas fa-exclamation-triangle\"></i> Mật khẩu từ 2-30 ký tự (vd: abcd )");
							// quay về và lưu lại dữ liệu
							dis.forward(request, response);
						} else {
							// ===================7.Kiểm tra trùng Trong DB=====================
							if (checkRegister.checkGmail(users) == true) {
								request.setAttribute("error",
										" <i class=\"fas fa-exclamation-triangle\"></i> Gmail đã tồn tại");
								// quay về và lưu lại dữ liệu
								dis.forward(request, response);
							}

							else {
								// Kiểm tra xem 2 pass có giống nhau hay không
								if (Validate.checPass(pass, repass) == false) {
									request.setAttribute("error",
											"<i class=\"fas fa-exclamation-triangle\"></i> Mật khẩu không trùng nhau");
									// quay về và lưu lại dữ liệu
									dis.forward(request, response);
								} else {
									// ===================8.Thêm Tài khoản vào Trong DB=====================
									userDAO.insertUser(users);
									//  ============9.Thêm tài thành công và quay về trang Login.jsp==========
									response.sendRedirect("Login.jsp");

								}
							}
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
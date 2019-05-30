package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class CheckLogin {

	public Users checkLogin(String username, String pass) throws SQLException {		
	       Users users = null;
		//1. Kết nối tới database quyenvipcjd_NMCNPM
		Connection conn = new DBConnection().getConnectDatabase();
		String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
		try {
			//2. Tìm thông tin tài khoản dựa vào username và password
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, pass);
			//3. Nhận một resultset gồm một rs
			
		ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				//4.1 Trả về Users chứa thông tin tài khoản 
				users = new Users(rs.getString("Username"), rs.getString("Email"), rs.getString("Password"));
			}
			//5. Đóng kết nối
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static void main(String[] args) throws SQLException {
		Users users = new Users("abc", "123d");
		CheckLogin checkLogi = new CheckLogin();
		System.out.println(checkLogi.checkLogin("abc", "123"));

	}

}

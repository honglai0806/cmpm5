package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class CheckLogin {
	static ResultSet rs;
	static DBConnection connection = new DBConnection();
	static Connection conn = connection.getConnectDatabase();
	static PreparedStatement preparedStmt = null;

//Trả về 1 User gồm Username và Password
	public Users checkLogin(String username, String pass) throws SQLException {

		return getUsers(username, pass);
	}

	// connect tới databasse User
	//kiểm tra tồn tại ĐBj
	public Users getUsers(String username, String pass) {
		conn = connection.getConnectDatabase();
		String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
		Users users = null;
		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, pass);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				users = new Users(rs.getString("Username"), rs.getString("Email"), rs.getString("Password"));
			}

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

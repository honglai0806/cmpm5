package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class CheckRegister {
	static ResultSet rs;
	DBConnection connection = new DBConnection();
	Connection conn = connection.getConnectDatabase();
	PreparedStatement preparedStmt = null;

	public boolean checkUser(Users User) throws SQLException {
		String SQL = "SELECT * FROM Users WHERE Username=?";
		preparedStmt = conn.prepareStatement(SQL);
		preparedStmt.setString(1, User.getUsername());
		rs = preparedStmt.executeQuery();
		while (rs.next()) {
			return true;

		}
		return false;
	}

	public boolean checkGmail(Users User) throws SQLException {
		String SQL = "SELECT * FROM Users WHERE Email=?";
		preparedStmt = conn.prepareStatement(SQL);
		preparedStmt.setString(1, User.getEmail());
		rs = preparedStmt.executeQuery();
		while (rs.next()) {
			return true;

		}
		return false;
	}

	

	public static void main(String[] args) throws SQLException {
		Users users = new Users("abc", "abc@gmail.com", "abc");
		CheckRegister checkRegister = new CheckRegister();
		System.out.println(checkRegister.checkUser(users));
		System.out.println(checkRegister.checkGmail(users));

	}
}

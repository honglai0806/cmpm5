package modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UserDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	static ResultSet rs;

	// ===================8.Thêm Tài khoản vào Trong DB=====================
	public boolean insertUser(Users users) throws SQLException {
		DBConnection connection = new DBConnection();
		conn = connection.getConnectDatabase();
		String SQL = " INSERT INTO Users(Username, Email, Password) VALUES (?,?,?)";
		preparedStmt = conn.prepareStatement(SQL);
		preparedStmt.setString(1, users.getUsername());
		preparedStmt.setString(2, users.getEmail());
		preparedStmt.setString(3, users.getPassword());
		preparedStmt.executeUpdate();
		preparedStmt.close();
		conn.close();
		return true;
	}

//	public static void main(String[] args) throws SQLException {
//		UserDAO dao = new UserDAO();
//		Users users1 = new Users("mnjughuuihukjh", "123", "123");
//		System.out.println(dao.insertUser(users1));
//
//	}
}

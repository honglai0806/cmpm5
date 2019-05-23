package modelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection cnn;
	String dbHostName = "103.98.148.33";
	String dbName = "quyenvipcjd_NMCNPM";
	String dbUsername = "quyenvipcjd_dw5";
	String dbPassword = "datawarehouse5";

	public DBConnection() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnn = DriverManager.getConnection("jdbc:mysql://" + dbHostName + ":3306/" + dbName, dbUsername, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnectDatabase() {
		return cnn;
	}

	public void closeCnn() {
		try {
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//
//		DBConnection connection = new DBConnection();
//		connection.getConnectDatabase();
//		if (connection != null) {
//			System.out.println("Ket nối thành công ");
//		} else {
//			System.out.println("Ket nối thất bại");
//		}
//	}
}

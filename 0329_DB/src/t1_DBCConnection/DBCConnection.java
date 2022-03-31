package t1_DBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCConnection {
	private Connection conn;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
	private static final String URL = "jdbc:mysql://localhost:3306/javagreen";

	public DBCConnection() {
		try {
			System.out.println("드라이버 연결");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
			try {
				conn.close();
			}catch (SQLException e1) {
			}
		}
	}
}

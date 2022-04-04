package Pack_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
	private boolean idCheck = false;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	// stmt객체 Close
	public void stmtClose() {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {}
		}
	}
	
	// rs객체 close
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
				stmtClose();
			} catch (SQLException e) {}
		}
	}
	
  // 데이터베이스객체 Close 
	public void dbClose() {
		try {
			conn.close();
			//System.out.println("DB를 닫았습니다.");
		} catch (Exception e) {}
	}
	
	public LoginDAO() {
		// db 연결정보 설정 및 드라이버 로딩
		String url = "jdbc:mysql://localhost:3306/javagreen02";
		String user = "root";
		String password = "1234";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
	}

	// 1. 로그인창: 아이디 비번 확인 메서드
	public boolean searchId(String id, String pw) throws SQLException {
		// sql문 선언 및 실행
		String sql = "select u_id, u_pass from user";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("u_id").equals(id)) {
				if (rs.getString("u_pass").equals(pw)) {
					idCheck = true;
				}
			}
		}
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return idCheck;
	}

	// 2. 회원가입창: 아이디 중복확인 메서드
	public boolean checkId(String id) throws SQLException {
		// sql문 선언 및 실행
		String sql = "select u_id from user";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("u_id").equals(id)) {
				idCheck = true;
			}
		}
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();

		return idCheck;
	}

	// 2. 회원가입창: 회원가입메서드
	public void createUser(String u_id, String u_pass, String u_name, String u_gender, String u_birth, String u_pno){
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into user values('" + u_id + "', '" + u_pass +"', '" + u_name +"', '" + u_gender +"', '" + u_birth +"', '" + u_pno +"');";
			stmt.executeUpdate(sql);
			System.out.println("자료가 등록되었습니다.");
		} catch (SQLException e) {
			System.out.println("SQL오류" + e.getMessage());
		} finally {
			stmtClose();
		}
	}

}

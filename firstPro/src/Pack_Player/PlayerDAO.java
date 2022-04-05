package Pack_Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerDAO {
	private Connection conn;
	private ArrayList<PlayerVO> players = new ArrayList<PlayerVO>();
	private ArrayList<PlayerVO> players_6 = new ArrayList<PlayerVO>();

	public PlayerDAO() {
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

	// 선수 추가 창: 선수추가 메서드
	public void insertPlayer(String t_code, String p_name, String p_length, String p_birth, String p_weight,
			String p_pos, String p_backno) throws SQLException {
		// 선수 추가하기
		try {
			Statement stmt = conn.createStatement();
			String sqlNum = "select p_no from player where t_code = '" + t_code + "' order by p_no desc limit 1";
			PreparedStatement pstmt = this.conn.prepareStatement(sqlNum);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int p_no = rs.getInt(1) + 1;

			String sql = "insert into player values (default,'" + p_no + "','" + t_code + "','" + p_backno + "','"
					+ p_name + "','" + p_birth + "','" + p_length + "','" + p_weight + "','" + p_pos + "')";
			stmt.executeUpdate(sql);
			System.out.println("선수 등록되었습니다.");
		} catch (SQLException e) {
			System.out.println("SQL오류" + e.getMessage());
		}
	}

	// 선수 수정 창: 선수 수정 메서드
	public void updatePlayer(int p_code, int p_no, String t_code, String p_name, String p_length, String p_birth,
			String p_weight, String p_pos, String p_backno) throws SQLException {
		try {
			Statement stmt = conn.createStatement();
			String sql = "update player set p_backno='" + p_backno + "', p_name='" + p_name + "', p_birth='" + p_birth
					+ "', p_length='" + p_length + "', p_weight='" + p_weight + "', p_pos='" + p_pos + "', p_no='"
					+ p_no + "' where p_code = '" + p_code + "' ";
			stmt.executeUpdate(sql);
			System.out.println("수정완료!");
		} catch (SQLException e) {
			System.out.println("SQL오류" + e.getMessage());
		}
	}

	// 선수 검색하는 메서드
	public ArrayList<PlayerVO> searchPlayer(String t_code) {

		try {
			String sql = "select * from player p,team t where p.t_code = t.t_code and t.t_code =?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, t_code);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PlayerVO pv = new PlayerVO();
				pv.setP_no(rs.getString("p.p_no"));
				pv.setT_code(rs.getString("t.t_name"));
				pv.setP_name(rs.getString("p.p_name"));
				pv.setP_length(rs.getString("p.p_length"));
				pv.setP_birth(rs.getString("p.p_birth"));
				pv.setP_weight(rs.getString("p.p_weight"));
				pv.setP_pos(rs.getString("p.p_pos"));
				pv.setP_backno(rs.getString("p.p_backno"));
				players.add(pv);
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return players;
	}

	// 선수 삭제하는 메서드
	public void deletePlayer(int p_no) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete from player where p_no ='" + p_no + "'";
			stmt.executeUpdate(sql);
			System.out.println("삭제완료!");
		} catch (SQLException e) {
			System.out.println("SQL오류" + e.getMessage());
		}

	}

	// 선수 검색하는 메서드
	public ArrayList<PlayerVO> searchPlayer_6(Integer p_code) {
		try {
			String sql = "select * from player where p_code = ?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, p_code);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PlayerVO pv = new PlayerVO();
				pv.setP_no(rs.getString("p_no"));
				pv.setT_code(rs.getString("t_code"));
				pv.setP_backno(rs.getString("p_backno"));
				pv.setP_name(rs.getString("p_name"));
				pv.setP_birth(rs.getString("p_birth"));
				pv.setP_length(rs.getString("p_length"));
				pv.setP_weight(rs.getString("p_weight"));
				pv.setP_pos(rs.getString("p_pos"));
				players_6.add(pv);
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return players_6;
	}
}

package Pack_Team;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamDAO {
	private Connection conn;
	private ArrayList<TeamVO> teams = new ArrayList<TeamVO>();

	public TeamDAO() {
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

	// 팀 추가하기 메서드
	public void InsertTeam() {
		try {
			// 선수엑셀파일 가져오기
			BufferedReader br = new BufferedReader(new FileReader("./team.csv"));
			String team = null;

			// sql문 선언 및 엑셀파일읽어서 sql문 실행
			String sql = "insert into team values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			while ((team = br.readLine()) != null) {
				String[] teams = team.split(",");
				pstmt.setString(1, teams[0]);
				pstmt.setString(2, teams[1]);
				pstmt.setString(3, teams[2]);
				pstmt.setString(4, teams[3]);
				pstmt.setString(5, teams[4]);

				ResultSet rs = pstmt.executeQuery();
				if (rs != null)
					rs.close();
			}

			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 모든 팀 리턴해주는 메소드 (선수 추가 패널의 콤보박스 만들 때 사용)
	public ArrayList<TeamVO> selectTeam() {
		String sql = "select t_code, t_name from team order by t_code asc";
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				TeamVO vo = new TeamVO();
				vo.setT_code(rs.getString(1));
				vo.setT_name(rs.getString(2));
				teams.add(vo);
			}

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teams;
	}

}
package org.comstudy.myweb.DBCP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil_jdbc {
	public static Connection getConnection() {
		// JDBC 연동 - 커넥션 드라이버 찾기
		String url = "jdbc:h2:~/test";
		String user = "sa";
		String password = "";
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver"); // 드라이버 검색 -> 인스턴스화
			System.out.println("드라이버 검색 성공");
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.append("SQL 오류");
			e.printStackTrace();
		}
		return conn;
	}
	
	// 메소드 오버로딩
	public static void close(Connection obj) {
		try {
			if (obj != null)
				obj.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(ResultSet obj) {
		try {
			if (obj != null)
				obj.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(Statement obj) {
		try {
			if (obj != null)
				obj.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// static멤버 = class멤버 : 클래스 외부에서 클래스명으로 접근 가능
	public static void close(Connection conn, ResultSet rs, Statement stmt) {
		close(conn);
		close(rs);
		close(stmt);
	}
}

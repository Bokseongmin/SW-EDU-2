package org.comstudy.myweb.saram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy.myweb.DBCP.JdbcUtil;

public class SaramDAO {
	// CRUD를 전담하는 클래스
	Connection conn = null; // 디비 연결
	PreparedStatement stmt = null; // 디비에 SQL 전달
	ResultSet rs = null; // 결과를 받아온다

	final String FIND_ALL = "SELECT * FROM SARAM";
	final String FIND_ONE = "SELECT * FROM SARAM WHERE SEQ=?";
	final String SAVE = "INSERT INTO SARAM (id, name, age) values(?,?,?)";
	final String UPDATE = "UPDATE saram SET id=?, name=?, age=? WHERE seq=?";
	final String DELETE = "DELETE FROM saram WHERE seq=?";

	// 검색
	public List<SaramDTO> findAll() {
		List<SaramDTO> list = new ArrayList<SaramDTO>();
		try {
			conn = JdbcUtil.getConnection();
			// conn.prepareStatement();
			// 자식으로 만들었으니 preparedstatement로 만들어줘야 됨
			stmt = conn.prepareStatement(FIND_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				list.add(new SaramDTO(seq, id, name, age));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, rs, stmt);
		}
		return list;
	}

	public SaramDTO findOne(SaramDTO dto) {
		SaramDTO saram = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(FIND_ONE);
			stmt.setInt(1, dto.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				int seq = rs.getInt("seq");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				saram = new SaramDTO(seq, id, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, rs, stmt);
		}
		return saram;
	}

	// 입력
	public void save(SaramDTO dto) {
		SaramDTO saram = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(SAVE);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getName());
			stmt.setInt(3, dto.getAge());
			// SELECT문 외에는 모두 excuteUpdate
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("입력 성공!");
				conn.commit();
			} else {
				System.out.println("입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, rs, stmt);
		}
	}

	// 수정
	public void update(SaramDTO dto) {
		System.out.println("Saram update ... " + dto);
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getName());
			stmt.setInt(3, dto.getAge());
			stmt.setInt(4, dto.getSeq());
			// SELECT문 외에는 모두 excuteUpdate
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("수정 성공!");
				conn.commit();
			} else {
				System.out.println("수정 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, rs, stmt);
		}
	}

	// 삭제
	public void remove(SaramDTO dto) {
		SaramDTO saram = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, dto.getSeq());
			// SELECT문 외에는 모두 excuteUpdate
			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("삭제 성공!");
				conn.commit();
			} else {
				System.out.println("삭제 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, rs, stmt);
		}
	}

	// ----------------- test -----------------
	public static void main(String[] args) {
		// 어플리케이션 테스트...
		// JNDI는 톰캣에서 테스트 해야 한다.
		// main()에서 실행 하면 톰캣과 별도로 실행 된다.
		testFindAll();
	}

	// JDBC는 톰캣과 상관 없이 실행 되므로 main()에서 테스트 가능.
	// JNDI는 톰캣에 의존적으로 싱행 되므로 main()에서 단독 실행 불가능.
	public static void testFindAll() {
		SaramDAO dao = new SaramDAO();
		List<SaramDTO> saramList = dao.findAll();
		// System.out.println(saramList);
		for (int i = 0; i < saramList.size(); i++) {
			System.out.println(saramList.get(i));
		}
	}
}

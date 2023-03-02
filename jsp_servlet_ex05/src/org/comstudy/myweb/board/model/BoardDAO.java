package org.comstudy.myweb.board.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {

	SqlSession session;

	public BoardDAO() {
		try {
			String resource = "org/comstudy/ex05/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			session = sqlSessionFactory.openSession();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<BoardDTO> findAll() {
		List<BoardDTO> list = session.selectList("org.comstudy.ex05.BoardMapper.findAll");
		return list;
	}

	public BoardDTO findOne(BoardDTO dto) {
		BoardDTO board = session.selectOne("org.comstudy.ex05.BoardMapper.findOne", dto.getSeq());
		return board;
	}

	// 입력
	public void save(BoardDTO dto) {
		session.insert("org.comstudy.ex05.BoardMapper.save", dto);
		session.commit();
	}

	// 수정
	public void update(BoardDTO dto) {
		session.update("org.comstudy.ex05.BoardMapper.update", dto);
		session.commit();
	}

	// 삭제
	public void remove(BoardDTO dto) {
		session.delete("org.comstudy.ex05.BoardMapper.delete", dto);
		session.commit();
	}
	
	// 테스트
	static BoardDAO dao = new BoardDAO();
	public static void main(String[] args) {
		// BoardDTO board = dao.findOne(new BoardDTO(0L, "", "", new Date(), "", 0L));
		// List<SaramDTO> list = dao.findAll();
		/*
		BoardDTO board = new BoardDTO();
		board.setTitle("test");
		board.setContent("test2");
		board.setWriteDate(new Date());
		board.setWriter("tester");
		dao.save(board);
		*/
		/*
		BoardDTO board = new BoardDTO();
		board.setSeq(1L);
		board.setTitle("test ch");
		board.setContent("test ch2");
		board.setWriteDate(new Date());
		board.setWriter("tester ch3");
		dao.update(board);
		*/
		
		BoardDTO board = new BoardDTO();
		board.setSeq(2L);
		dao.remove(board);
		
		List<BoardDTO> list = dao.findAll();
		System.out.println(list);
	}
}
package org.comstudy.myweb.saram.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SaramDAO {

	SqlSession session;

	public SaramDAO() {
		try {
			String resource = "org/comstudy/ex05/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			session = sqlSessionFactory.openSession();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SaramDTO> findAll() {
		List<SaramDTO> list = session.selectList("org.comstudy.ex05.SaramMapper.findAll");
		return list;
	}

	public SaramDTO findOne(SaramDTO dto) {
		SaramDTO saram = session.selectOne("org.comstudy.ex05.SaramMapper.findOne", dto.getSeq());
		return saram;
	}

	// 입력
	public void save(SaramDTO dto) {
		session.insert("org.comstudy.ex05.SaramMapper.save", dto);
		session.commit();
	}

	// 수정
	public void update(SaramDTO dto) {
		session.update("org.comstudy.ex05.SaramMapper.update", dto);
		session.commit();
	}

	// 삭제
	public void remove(SaramDTO dto) {
		session.delete("org.comstudy.ex05.SaramMapper.delete", dto);
		session.commit();
	}
	
	// 테스트

	static SaramDAO dao = new SaramDAO();
	public static void main(String[] args) {
		// SaramDTO saram = dao.findOne(new SaramDTO(5, null, null, 0));
		// List<SaramDTO> list = dao.findAll();
		/*
		SaramDTO saram = new SaramDTO();
		saram.setId("test");
		saram.setName("test2");
		saram.setAge(3);
		dao.save(saram);
		*/
		/*
		SaramDTO saram = new SaramDTO();
		saram.setSeq(1);
		saram.setId("변경된 아이디");
		saram.setName("변경된 이름");
		saram.setAge(0);
		dao.update(saram);
		*/
		SaramDTO saram = new SaramDTO();
		saram.setSeq(1);
		dao.remove(saram);
		List<SaramDTO> list = dao.findAll();
		System.out.println(list);
	}
}
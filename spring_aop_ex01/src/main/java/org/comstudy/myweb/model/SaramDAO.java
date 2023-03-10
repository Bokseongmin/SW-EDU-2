package org.comstudy.myweb.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SaramDAO {
	// SaramDAO에 있는 method들을 기준으로 Service 인터페이스를 만든다.
	// 우클릭 > refactor > Extract interface 기능 활용
	
	public List<SaramDTO> selectAll() {
		System.out.println(">>> selectAll():List<SaramDTO> - SaramDAO 호출");
		return null;
	}

	public SaramDTO selectOne(SaramDTO dto) {
		System.out.println(">>> selectOne(SaramDTO):SaramDTO - SaramDAO 호출");
		return null;
	}

	public void insert(SaramDTO dto) {
		System.out.println(">>> insert(SaramDTO dto):void - SaramDAO 호출");
	}

	public void update(SaramDTO dto) {
		System.out.println(">>> update(SaramDTO dto):void - SaramDAO 호출");
	}

	public void delete(SaramDTO dto) {
		System.out.println(">>> delete(SaramDTO dto):void - SaramDAO 호출");
	}

}

package org.comstudy.myapp.saram.model;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

// 클래스 선언 및 빈 등록
@Repository
public class SaramDAO {
	
	public ArrayList<SaramDTO> selectAll() {
		System.out.println("SaramDAO의 selectAll() 호출 됨!");
		return null;
	}
}

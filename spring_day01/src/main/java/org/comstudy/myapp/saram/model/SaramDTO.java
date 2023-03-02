package org.comstudy.myapp.saram.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaramDTO {
	private int idx;
	private String id;
	private String name;
	private int age;
}

// 스프링 프로젝트 내보내기
// File > Export
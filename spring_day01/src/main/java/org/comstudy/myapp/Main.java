package org.comstudy.myapp;

import org.comstudy.myapp.saram.model.SaramDTO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	// Run As > Run on Server �떎�뻾 : �쎒 �꽌踰� �뼱�뵆由ъ��씠�뀡 �떎�뻾
	// Run As > Java Application �떎�뻾 :  main()�뿉�꽌 �떎�뻾 �릺�뒗 Application
	public static void main(String[] args) {
		// �쎒�뿉�꽌 �떎�뻾 �릺吏� �븡�쓬.
		System.out.println("Hello Spring world!");
		
		// 吏곸젒 鍮� 媛앹껜瑜� �깮�꽦�빐�꽌 �궗�슜.
//		SaramDTO saramDTO = new SaramDTO(11, "KIM", "源��쑀�떊", 35);
//		System.out.println(saramDTO);
		
		// applicationContext.xml�뿉 �꽑�뼵�맂 Bean 媛앹껜 Lookup
		String resource = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(resource);
		SaramDTO dto = (SaramDTO)factory.getBean("saramDTO");
		System.out.println(dto);
	}

}

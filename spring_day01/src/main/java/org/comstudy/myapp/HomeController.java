package org.comstudy.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.comstudy.myapp.saram.model.SaramDAO;
import org.comstudy.myapp.saram.model.SaramDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SaramDTO saramDTO;
	
	@Autowired
	SaramDAO saramDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("HomeController 환영 메세지 {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("--- root-context.xml의 빈 사용 하기 ---");
		System.out.println(saramDTO); //SaramDTO(idx=101, id=PARK, name=박길동, age=24)
		
		// DAO 멤버 호출
		saramDAO.selectAll(); //SaramDAO의 selectAll() 호출 됨!
		
		return "home";
	}
}
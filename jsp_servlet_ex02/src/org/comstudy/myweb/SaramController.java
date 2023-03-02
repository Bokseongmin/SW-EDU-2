package org.comstudy.myweb;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml에 servlet-mapping
// @WebServlet("/saram")
public class SaramController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
		int beginIndex = ctxPath.length();
		String urlPattern = reqUri.substring(beginIndex);
		
		// printf()함수는 변환 문자열을 사용 가능.
		// %s - string, %d - decimal, %i - integer, %f - float
		System.out.printf("%s, %s\n", ctxPath, reqUri);
		System.out.println("urlPattern => " + urlPattern);
		
		// view 페이지에서 사용될 변수 request에 저장
		// forward 될 때 request도 전달
		// JSP 페이지에서 request.getAttribute("username");
		// ${username} EL문법
		// 정수, 문자열, 객체, 컬렉션 리스트 등 전달 가능.
		req.setAttribute("username", "홍길동");
		ArrayList<String> userList = new ArrayList<String>();
		userList.add("박길동 | 의사 | 28");
		userList.add("이길동 | 변호사 | 35");
		userList.add("김길동 | 프로그래머 | 32");
		// JSP에서는 request.getAttribute("userList"); 사용
		req.setAttribute("userList", userList);
		
		// view 페이지로 forward
		// RequestDispatcher 객체를 이용한 view 페이지 forward
		String viewName = "/WEB-INF/views/saram/list.jsp"; // view 역할 하는 JSP페이지 위치
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		// Servelt 페이지에서 하는 일을 JSP 페이지로 위임.
		// request와 response 객체를 전달한다.
		view.forward(req, resp);
	}
}

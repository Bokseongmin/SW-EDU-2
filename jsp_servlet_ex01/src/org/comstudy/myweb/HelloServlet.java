package org.comstudy.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 클래스는 HttpServlet을 상속 받아야 한다.
public class HelloServlet extends HttpServlet {
	// 오버라이드(Override) - 부모 클래스의 멤버 메서드를 자식 클래스가 재정의 하는 것.
	// @Override 어노테이션으로 검증
	// 방법1. 우클릭 > Source > Override/implement methods
	// 방법2. doGet 작성 후 > Ctrl+spacebar

	// 서블릿 실행 하는 방법은 web.xml에 매핑 시킨 주소를 브라우저 주소창에 주소를 입력 한다.
	// 브라우저를 이용해서 실행해야만 한다.

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Server의 console에 출력 됨.
		System.out.println("doGet() - HelloServlet 호출 됨.");

		// 브라우저에 출력 되는 방식
		// Request객체체에는 요청 정보(파라미터 등)가 저장 된다.
		// Response 객체에는 브라우저에 처리하는 정보(forward, redirect)가 저장된다.
		
		resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("  <head>");
		out.println("    <title>Hello world</title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("    <h1>Hello world</h1>");
		out.println("    <p><a href=\"http://www.naver.com\">네이버로 이동</a></p>");
		out.println("  </body>");
		out.println("</html>");

		out.close();
	}
}

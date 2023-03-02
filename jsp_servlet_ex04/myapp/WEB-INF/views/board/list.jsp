<%@page import="org.comstudy.myweb.board.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>길동이의 홈페이지</h3>
	<h1>게시판 목록</h1>
	<%
		// 리스트를 출력한다.
	// request에서 list속성으로 저장된 목록을 가져온다.
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) request.getAttribute("boardList");
	for (BoardDTO board : list) {
		out.println("<p>" + board + "</p>");
	}
	%>
</body>
</html>
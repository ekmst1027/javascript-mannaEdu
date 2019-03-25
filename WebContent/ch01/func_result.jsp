<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// post 방식의 한글 처리
	request.setCharacterEncoding("utf-8");
	// request.getParameter("태그의 name")
	// 태그에 name 속성이 없으면 결과값이 null로 출력됨
	String name = request.getParameter("name");
	String position = request.getParameter("position");
	String str = name + " " + position + "님의 방문을 환영합니다.";
	out.println(str);
	%>
</body>
</html>
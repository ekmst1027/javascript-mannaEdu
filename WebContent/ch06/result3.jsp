<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "keyword.KeywordDAO" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 한글 인코딩 설정(post 방식일 경우)
request.setCharacterEncoding("utf-8");
String keyword = request.getParameter("search");	// 태그의 name
// out.println("키워드 : " + search);
KeywordDAO dao = new KeywordDAO();
List<String> items = dao.list(keyword);	// 키워드 목록이 리턴됨
for(String str : items) {
	out.println(str + "<br>");
}
%>
</body>
</html>
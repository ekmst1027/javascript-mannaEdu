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
// request.getParameter("태그의 name") : 태그에 입력한 값을 가져옴
// Integer.parseInt("문자열") : 문자열을 숫자로 변환
int dan = Integer.parseInt(request.getParameter("dan"));
for(int i = 1; i <= 9; i++) {
	out.println(dan + "x" + i + "=" + dan*i + "<br>");
}
%>
</body>
</html>
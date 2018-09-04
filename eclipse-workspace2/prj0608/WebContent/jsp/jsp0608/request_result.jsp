<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.io.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>
<%!
public String toKoreanEncoding(String str) throws UnsupportedEncodingException {
	return(new String(str.getBytes("ISO-8859-1"),"UTF-8"));
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>여긴 request_result화면 입니다.</center>
<hr>
이름 :<%=request.getParameter("username")%>,<BR>
직업 :<%=request.getParameter("job") %><BR>
관심분야 :<% 
	String favorites[] = request.getParameterValues("favorite");
	for (String favorite :favorites ) {
		out.println(favorite+"<br>");
	}
%>

주소 :<%= request.getRemoteAddr() %> <br>
메쏘드 :<%= request.getMethod() %> <br>
<% Cookie cookie[]=request.getCookies();  %> <br>
쿠키이름 :<%= cookie[0].getName() %> <br>
쿠키값 :<%= cookie[0].getValue() %> <br>
프로토콜 :<%= request.getProtocol() %>
</body>
</html>
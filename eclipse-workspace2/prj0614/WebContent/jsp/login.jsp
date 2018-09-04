<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<jsp:useBean id="login" class="prj0614_00.LoginBean" scope="page" />
<jsp:setProperty name="login" property="*" />
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>
<hr2>로그인 화면</hr2>
<hr>
<%
	if (!login.checkUser() ) {
		out.println("로그인 실패 !!");
	} else {
		out.println("로그인 성공 !!");
	}
%>
<hr>
사용자 아이디 : <jsp:getProperty name="login" property="userid" /><BR>
사용자 패스워드 : <jsp:getProperty name="login" property="passwd" /><BR>

</body>
</html>
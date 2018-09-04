<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.io.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 :<%=request.getParameter("username1")+request.getParameter("username2")%>,<BR>
아이디 :<%=request.getParameter("id") %><BR>
비밀번호:<% 
	String password1 = request.getParameter("password1");
	String password2 = request.getParameter("password2");
	if (password1.compareTo(password2)==0) 
		out.println("비밀번호 적합");
	else
		out.println("비밀번호 부적합"+"["+password1+"]["+password2+"]");
%>

<form name=form2 method=post action=>
<input type=submit value="회원가입">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Simple Twitter</title>
</head>
<body>
<hr2>로그인 화면</hr2>
<hr>
	<form name="loginForm" action="<%=request.getContextPath() %>/jsp/jvMember.jsp">
		아이디 <input type="text" name="userid" size="30">
		<input type="submit" value="로그인">
	</form>
</body>
</html>
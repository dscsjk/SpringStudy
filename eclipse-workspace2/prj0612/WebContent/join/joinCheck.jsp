<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("userid");
	String password = request.getParameter("pwd");
	if (id.equals(password)) {
		session.setAttribute("MEMBERID",id);
		response.sendRedirect(request.getContextPath()+"/main/main.jsp");
	} else { //로그인 실피시
%>
<script>
alert("회원가입에 실패하였습니다. 아이디와 패스워드가 같아야 회원가입이 가능합니다.");
history.go(-1)
</script>%>
<%
	}
%>
</body>
</html>
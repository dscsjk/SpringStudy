<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String memberId = (String)session.getAttribute("MEMBERID");
	boolean login = memberId == null ? false : true ;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면입니다.</title>
</head>
<body>
<%
	if(login) {
%>
아이디: "<%= memberId %>"님 환영합니다.
<hr>
정회원 서비스
<%
	} else {
%>
게스트님 환영합니다.
<%
	}
%>
<form name="logoutForm" method="post" action="<%= request.getContextPath() %>/login/logout.jsp">
	<input type="submit" value="로그아웃">
</form>
</body>
</html>
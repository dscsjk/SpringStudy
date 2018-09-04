<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,prj0612_homework.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="logoutForm" method="post" action="<%= request.getContextPath() %>/jsp/logout.jsp">
	<input type="submit" value="로그아웃">
	<%=request.getParameter("userid") %>님 환영합니다.
</form>
<h2>여기는 Spring Class 모임입니다.</h2><hr>
멤버<hr>
<%
String userid="";
String pwd="";
String name="";
String addr="";

List<StudentBean> stdList = new ArrayList<StudentBean>();
stdList = (List<StudentBean>) session.getAttribute("student");
int i = 1;
for ( StudentBean std : stdList ) {
	name = std.getName();
	addr = std.getAddr();
	userid = std.getUserid();
	pwd = std.getPwd();
	out.println( i +". "+ name +"  "+ userid +"  "+ addr +"<hr>");
	i++;
}
%>


<!-- %= name +" "+ addr +"<hr>" % -->
</body>
</html>
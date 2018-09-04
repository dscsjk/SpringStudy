<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,prj0612_homework.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
List<StudentBean> stdList = new ArrayList<StudentBean>();
session.setAttribute("student",stdList);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr2>로그인 화면</hr2>
<hr>
	<form name="loginForm" action="<%=request.getContextPath() %>/jsp/loginCheck.jsp">
		아이디 <input type="text" name="userid" size="10">
		암호<input type="password" name="password" size="10">
		<input type="submit" value="로그인">
		<input type="button" value="수강신청" onClick="goAsk()">
	</form>
</body>
<script type="text/javascript">
	function goAsk(){
		document.loginForm.action="<%= request.getContextPath() %>/jsp/join.jsp";
		document.loginForm.submit();
	}
</script>
</html>
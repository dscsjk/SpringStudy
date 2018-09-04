<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h2>Spring Class 수강신청</h2>
<form name="joincheckForm" method="post" action="joinCheck.jsp">
	아이디 <%=request.getParameter("userid") %><hr>
	패스워드 <%=request.getParameter("pwd") %><hr>
	이름 <%=request.getParameter("username") %><hr>
	주소 <%=request.getParameter("useraddr") %><hr>

	<input type=hidden name="userid" value="<%= request.getParameter("userid") %>">
	<input type=hidden name="pwd" value="<%= request.getParameter("pwd") %>">
	<input type=hidden name="username" value="<%= request.getParameter("username") %>">
	<input type=hidden name="useraddr" value="<%= request.getParameter("useraddr") %>">

	<input type=submit value="수강신청 ">
	<input type=button value="취소 --+" onClick="goJoinPage()">
</form>
</body>
<script type="text/javascript">
	function goJoinPage(){
		document.joincheckForm.action="join/join.jsp";
		document.joincheckForm.submit();
	}
</script>
</html>
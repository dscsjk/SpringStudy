<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form name="joincheckForm" method="post" action="joinCheck.jsp">
	아이디 <%=request.getParameter("userid") %><hr>
	패스워드 <%=request.getParameter("pwd") %><hr>
	JOB<%=request.getParameter("job") %><hr>
	관심분야
	<%
		String favorites[] = request.getParameterValues("favorite");
		for(String favorite : favorites) {
			out.println(favorite+"<BR>");
		}
	%>
	<input type=hidden name="userid" value="<%= request.getParameter("userid") %>">
	<input type=hidden name="pwd" value="<%= request.getParameter("pwd") %>">
	<input type=submit value="회원가입하기 ">
	<input type=button value="다시 회원가입 하러가기 --+" onClick="goJoinPage()">
</form>
</body>
<script type="text/javascript">
	function goJoinPage(){
		document.joincheckForm.action="join.jsp";
		document.joincheckForm.submit();
	}
</script>
</html>
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
<%
StudentBean std = new StudentBean();

std.setName("이상해");
std.setAddr("경기도 성남시 분당동");
std.setUserid(request.getParameter("userid"));
std.setPwd(request.getParameter("pwd"));

List<StudentBean> stdList = new ArrayList<StudentBean>();
stdList = (List<StudentBean>) session.getAttribute("student");
stdList.add(std);
session.setAttribute("student",stdList);

%>

<form name=joincheckForm method=post action=myPage.jsp>
	<input type=hidden name="userid" value="<%= request.getParameter("userid") %>">
</form>
<script>
document.joincheckForm.submit();
</script>%>
</body>
</html>
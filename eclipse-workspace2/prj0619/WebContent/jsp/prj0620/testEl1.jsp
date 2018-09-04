<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<%
	request.setAttribute("id", "kimsj");
	session.setAttribute("id2", "leeeh");
	application.setAttribute("id3", "shimsa");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>\$Eltest</title>
</head>
<body>
${param.name}
${param.age}
<hr>
id: ${requesScope.id }<br>
id2: ${sessionScope.id2 }<br>
id3: ${application.id3 }<br>
</body>
</html>
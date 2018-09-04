<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setAttribute("name", "최범균"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form1" action=>
요청 URI:${pageContext.request.requestURI}<br>
request의 name 속성:${requestScope.name}<br>
code 파라미터:${param.code}<br>
<hr>
<%=pageContext.getRequest() %><br>

<%=request.getAttribute("name") %><br>
<%=request.getParameter("code") %><br>
<input type="submit" value="확인">
</form>
</body>
</html>
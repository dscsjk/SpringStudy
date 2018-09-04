<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>footer.jsp출력화면</title>
</head>
<body>
<center>여긴 footer화면 입니다.</center>
<hr>
<%=request.getParameter("email") %>,
<%=request.getParameter("tel") %>
</body>
</html>
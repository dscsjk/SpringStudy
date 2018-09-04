<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
forward action jsp page_control_end.jsp파일 호출
<jsp:forward page="page_control_end.jsp">

<jsp:param value="123-456-7890" name="tel"/>
</jsp:forward>


</body>
</html>
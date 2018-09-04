<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>url_tag</title>
</head>

<body bgcolor="#FFFFFF">
<h3>&lt;c:redirect&gt;</h3>
<c:redirect url="choose.jsp">
<c:param name="sel">a</c:param>
</c:redirect>
</body>
</html>

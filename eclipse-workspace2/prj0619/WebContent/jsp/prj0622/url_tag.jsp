<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>redirect</title>
</head>

<body bgcolor="#FFFFFF">
<h3>&lt;c:redirect&gt;</h3>
<c:url value="choose.jsp" var="target">
<c:param name="sel">a</c:param>
</c:url>
<hr>
단순출력 : ${target}<br>
링크연동 : <a href="${target}">choose.jsp-a선택</a>
</body>
</html>
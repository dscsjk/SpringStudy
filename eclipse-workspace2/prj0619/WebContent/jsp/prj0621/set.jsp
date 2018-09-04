<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>set</title>
</head>
<body bgcolor="#FFFFFF">

<h3>&lt;c:set&gt;</h3>
<!-- c:set으로 설정된 변수는 c:out이나 EL을 통해 가져옴
기본적으로  page scope에 저장됨
JSP스크립틀릿을 이용시 pageContext.getAttribute  를 통해 가져올 수 있음 -->

<c:set value="Hello World" var="msg" />
msg : ${msg} <BR>
msg : <%= pageContext.getAttribute("msg") %><BR>

<c:set target="${member}" property="email" value="chaged@test.net" />
Member name : ${member.name} <BR>
Member email : ${member.email}
</body>
</html>
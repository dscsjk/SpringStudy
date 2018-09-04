<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="prj0619.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Member m = new Member();
m.setName("이름1");
%>
<c:set var="m" value="<%= m%>" />

<c:set var="name" value="${m.name}" /><%--이 시점에 바로 값 계산 --%>
<% m.setName("이름2"); %>
${name}<%--name의 값은 이름1 --%><hr>


<%
Member m2 = new Member();
m.setName("이름1");
%>

<c:set var="m" value="<%= m%>" />
<c:set var="name" value="#{m.name}" /><%--이 시점에는 값 생성하지 않음 --%>
<% m2.setName("이름2"); %>
${name}<%--사용할 때 값 계산, 이름2 출력 --%><hr>
<% m2.setName("이름3"); %>
${name}<%--사용할 때 값 계산, 이름3 출력 --%>



</body>
</html>
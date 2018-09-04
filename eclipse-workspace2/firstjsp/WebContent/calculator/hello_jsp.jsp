<%@page import="java.util.Timer"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>hello jsp</h1>
<hr>현재 Date Time<%= new Date()%>
<input type = "radio" value = "라디오" onclick = "alert('hello world')">
<input type = "button" value = "제출" onclick = "alert('hello world')">
<input type = "checkbox" value = "체크" onclick = "alert('hello world')">
<input type = "text" value = "text" onclick = "alert('hello world')">
<input type = "password" value = "password" onclick = "alert('hello world')">

<form id="search" method ="get">
<label for="s">검색</label>
<input type = "search" value="search" >
<input type = "submit" value = "search">
</form>
<input type = "tel" value = "tel" onclick = "alert('hello world')">
<input type = "url" value = "url" onclick = "alert('hello world')">
<input type = "email" value = "email" onclick = "alert('hello world')">
<input type = "number" value = "number" onclick = "alert('hello world')">
<input type = "range" value = "range" onclick = "alert('hello world')">
<input type = "file" value = "file" onclick = "alert('hello world')">
<input type = "reset" value = "reset" onclick = "alert('hello world')">
<input type = "image" value = "image" onclick = "alert('hello world')">
<input type = "color" value = "color" onclick = "alert('hello world')">
<input type = "datetime" value = "datetime" onclick = "alert('hello world')">
<input type = "datetime-local" value = "datetime-local" onclick = "alert('hello world')">
<input type = "date" value = "date" onclick = "alert('hello world')">
<input type = "month" value = "month" onclick = "alert('hello world')">
<input type = "week" value = "week" onclick = "alert('hello world')">
<input type = "time" value = "time" onclick = "alert('hello world')">
</center>
</body>
</html>
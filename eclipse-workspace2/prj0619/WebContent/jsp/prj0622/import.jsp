<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>import 태그</title>
</head>
<body>
<h4>import tag</h4>
<form>
	<select name=type>
		<option>blog</option>
		<option>youtube</option>
		<option>help</option>
</select>
<input type=submit value=go />
</form>
<br><hr>
<c:choose>
	<c:when test="${param.type == 'blog' }">
		<c:import url="http://www.goole.com">
		</c:import>
	</c:when>
	<c:when test="${param.type == 'youtube' }">
		<c:import url="http://www.youtube.com/results">
			<c:param name="search_query" value="보라매공원" />
		</c:import>
	</c:when>
	<c:when test="${param.type == 'help' }">
		<c:import url="import_help.jsp">
			<c:param name="message" value="선택해주세요" />
		</c:import>
	</c:when>
</c:choose>
</body>
</html>
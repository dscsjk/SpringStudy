<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forEach 태그</title>
</head>
<body>
 
<h3>1부터 100까지 홀수의 합</h3>
<c:set var="sum" value="0" />
	<c:forEach var="i" begin="1" end="100" step="2">
<c:set var="sum" value="${sum + i}" />
</c:forEach>
결과 : ${sum }
<hr> 
<h4>구구단 </h4>
<c:forEach var="i" begin="2" end="9">
	<c:forEach var="j" begin="1" end="9">
 		${i} * ${j} = ${i*j} <br>
 	</c:forEach>
</c:forEach>
<hr>

<h4>int형 배열</h4>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />
<!-- items  반복을 위한 데이터를 가진 아이템의 컬렉션
     status 반복 상태값이 있는 변수 -->
<c:forEach var="i" items="${intArray}" begin="2" end="4" varStatus="status">
	     ${stauts.index } - ${status.count } - [${i }] <br>
</c:forEach>

<%
	HashMap<String, Object> mapData = new HashMap<String, Object>();
	mapData.put("name", "아무개");
	mapData.put("today", new java.util.Date());
%>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />
<c:set var="map" value="<%= mapData %>" />

<c:forEach var = "i" items="${map }">
	${i.key} = ${i.value} <br> 
</c:forEach>

<h4>forToken</h4>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />
 
<!-- for문과 유하나 STringTokenizer 클래스 ㅇ기능 제공. 특정 구분자를 기준으로 각 문자열을 분할함 -->
<c:forTokens var = "token" items="빨강/주황/노랑/초록/남/보라/흑" delims="/">
	${token} <br> 
</c:forTokens>

</BODY>
</HTML>





</body>
</html>
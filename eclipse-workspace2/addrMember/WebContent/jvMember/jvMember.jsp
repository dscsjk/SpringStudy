<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,jvMember.*"%>
<jsp:useBean id="datas" scope="request" class="java.util.ArrayList"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<!DOCTYPE HTML>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:목록화면</title>
</head>
<body>
<div align="center"> 
<H2>My Simple Twitter</H2>
<hr>
<%=request.getParameter("userid")%>
<hr>
<form>
		<table border="1">
			<tr><th>번호</th><th>이 름</th><th>전화번호</th><th>생 일</th><th>회 사</th><th>메 모</th></tr>
<%
	for(JvMember ab : (ArrayList<JvMember>)datas) {
%>	
			  <tr>
				<td><%=ab.getAb_id()%></a></td>
				<td><%=ab.getAb_memo()%></td>
				<td><%=ab.getAb_tdate()%></td>
			  </tr>
<% } 
%>
		</table>
</form>
</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="prj0614_01.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="addr" class="prj0614_01.AddrBean" />
<jsp:setProperty name="addr" property="*" />
<jsp:useBean id="am" class="prj0614_01.AddrManager" scope="application"/>
<%
	am.del(addr);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addr_add.jsp</title>
</head>
<body>
<h2>삭제내용</h2>
이름 : <jsp:getProperty property="username" name="addr" /><p>
전화번호 : <%=addr.getTel() %><p>
이메일 : <%=addr.getEmail() %><p>
성별 : <%=addr.getSex() %><p>
<hr>
<a href="addr_list.jsp">목록 보기</a>
</body>
</html>
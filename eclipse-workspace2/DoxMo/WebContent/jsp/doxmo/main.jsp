<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, doxmo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/list.jsp">주문조회</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/main.jsp">DoxMo피자</a>
<%
Dxm01 dxm01;
if (!session.isNew()) {
	dxm01 = (Dxm01) session.getAttribute("login");
} else { dxm01 = null; }

if ( dxm01 == null ) { %>
<a href="<%=request.getContextPath() %>/jsp/doxmo/login.jsp">로그인</a>
<%} else {%>
<a href="<%=request.getContextPath() %>/jsp/doxmo/logout.jsp">로그아웃</a>
<%} %>
<a>회원가입</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/list.jsp">장바구니</a>
</h2>
<hr>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=01">피자</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=03">사이드디시</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=05">특가제품</a>
</h2>
<hr>
<h1>도미노피자 메인화면</h1>
</center>
</body>
</html>
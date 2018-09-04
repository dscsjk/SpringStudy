<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8"); %>

<html>
<head>
<jsp:useBean id="sl" scope="request" class="pizza.selstoreDAO"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Select Store</title>
</head>

<body>
<form method=post name="StoreList" action="<%=request.getContextPath() %>/jsp/oooo.jsp">

<%
	session.setAttribute("login",request.getParameter("ad_id"));
	System.out.println("세션id"+session.getAttribute("login"));


	ArrayList<StoreList> datas = sl.getStoreist();
	int i=0; 
	for(StoreList storelist : (ArrayList<StoreList>)datas) {
%>	

	<li>
		 <input type="text" name="StoreNo" value="<%=sl.getStoreNo()%>">
		 <input type="text" name="Storename" value="<%=sl.getStorename()%>">
		 <input type="text" name="address" value="<%=sl.getAddress()%>">
		 <input type="text" name="tel" value="<%=sl.getTel()%>">
	</li>
	<button type="submit" class="btn btn-lg btn-primary" >매장선택</button>
</form>
</body>
</html>

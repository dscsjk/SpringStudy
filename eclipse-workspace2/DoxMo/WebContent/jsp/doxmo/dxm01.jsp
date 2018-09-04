<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, doxmo.*" %>    
<jsp:useBean id="dxm" class="doxmo.DoxMoDAO"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 	
	Dxm01 data =  dxm.getUserInfo(request.getParameter("uid"), request.getParameter("pswd"), 0);
	if ( data.getU_name() != null ) {
		session.setAttribute("login",data);
		System.out.println("세션id 설정");
		response.sendRedirect("dxm02.jsp?prdt_tp=01"); 
	} else {
		response.sendRedirect("login.jsp"); 
	}
%>
</body>
</html>
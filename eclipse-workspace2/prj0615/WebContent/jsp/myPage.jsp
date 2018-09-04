<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, prj0615.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dbCon" class="prj0615.DbConn" scope="application" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="logoutForm" method="post" action="<%= request.getContextPath() %>/jsp/logout.jsp">
	<input type="submit" value="로그아웃">
	<%=request.getParameter("userid") %>님 환영합니다.
</form>
<h2>여기는 Spring Class 모임입니다.</h2><hr>
멤버<hr>
<%
	// 데이터베이서 연결관련 변수 선언
	PreparedStatement pstmt = null;
	Connection conn = dbCon.setDb();
	
	int i = 1;
	
	try {
		String sql="select userid, username, useraddr from user_info";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			out.println(i +". "+rs.getString(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+"<br>");
			i++;
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	} catch (Exception e) {System.out.println(e);}
%>
<!-- %= name +" "+ addr +"<hr>" % -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, prj0615.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dbCon" class="prj0615.DbConn" scope="application" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 데이터베이서 연결관련 변수 선언
	PreparedStatement pstmt = null;
	Connection conn = dbCon.setDb();
/*	Connection conn = null;
	
	// 데이터베이스 연결관련 정보를 문자열로 선언
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
	
	try {
		//jdbc 드라이버 로드
		Class.forName(jdbc_driver);
		
		//데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
		conn = DriverManager.getConnection(jdbc_url,"root","1234");
*/		
		
	try {
		//Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한  Statement준비
		String sql = "insert into user_info values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,request.getParameter("userid"));
		pstmt.setString(2,request.getParameter("pwd"));
		pstmt.setString(3,request.getParameter("username"));
		pstmt.setString(4,request.getParameter("useraddr"));
		
		int i=0;
		//username 값을 입력한 경우 sql문장을 수행.
		if(request.getParameter("userid") != null) {
			i = pstmt.executeUpdate();
			
		}
	} catch (Exception e) {
		System.out.println(e);
	}
%>
<form name=joincheckForm method=post action=myPage.jsp >
	<input type=hidden name="userid" value="<%= request.getParameter("userid") %>">
</form>
<script>
document.joincheckForm.submit();
</script>%>
</body>
</html>
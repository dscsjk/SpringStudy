<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	// 데이터베이서 연결관련 변수 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	// 데이터베이스 연결관련 정보를 문자열로 선언
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
	
	try {
		//jdbc 드라이버 로드
		Class.forName(jdbc_driver);
		
		//데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
		conn = DriverManager.getConnection(jdbc_url,"root","1234");
		
		//Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한  Statement준비
		String sql = "insert into test values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,request.getParameter("username"));
		pstmt.setString(2,request.getParameter("email"));
		
		int i=0;
		//username 값을 입력한 경우 sql문장을 수행.
		if(request.getParameter("username") != null) {
			i = pstmt.executeUpdate();
		}
	} catch (Exception e) {
		System.out.println(e);
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JDBC 테스트</title>
</head>
<body>
<hr>이벤트 등록</hr>
<form name=form1 method=post action=jdbc_test.jsp>
등록이름:<input type=text name =username>
email주소 : <input type=text name=email size=20>
<input type=submit value="등록">
<hr>
</form>
# 등록목록
<%
	try {
		String sql="select username, email from test";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int i =1;
		
		while(rs.next()) {
			out.println(i+" : " +rs.getString(1)+" , "+rs.getString("email")+"<br>");
			i++;
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	} catch (Exception e) {System.out.println(e);}
%>

</body>
</html>
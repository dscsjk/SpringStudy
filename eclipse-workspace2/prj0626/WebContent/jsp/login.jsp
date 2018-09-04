<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>수정 분식</title>
</head>
<body>
<hr2>로그인 화면</hr2>
<hr> <!-- 분식메뉴 리스트로 간다.(list.jsp) -->
	<form name="loginForm" action="<%=request.getContextPath() %>/jsp/list.jsp">
	아이디<input type="text" name="ad_id" size="20">
		<input type="submit" value="로그인">
	</form>
</body>
</html>
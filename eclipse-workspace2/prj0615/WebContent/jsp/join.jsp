<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Spring Class 수강신청</h2>
<hr>
과목 : Spring과정<hr>
	<form name=joinForm method=post action=joinResult.jsp>
	아이디 <input type="text" size=10 name=userid><br><hr>
	패스워드<input type="password" size=10 name=pwd><br><hr>
	이름 <input type="text" size=20 name=username><br><hr>
	주소<input type="text" size=50 name=useraddr><br><hr>
	<input type= submit value="신청">
	<input type= reset value="취소">
	</form>
</body>
</body>
</html>
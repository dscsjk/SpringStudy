<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>join.jsp</title>
</head>
<body>

<form name=form1 method=post action=join_check.jsp>
<hr>이름  <input type="text" size=10 name=username1> <input type="text" size=10 name=username2>
<hr>아이디  (이메일)<input type="text" size=30 name=id>
<hr>비밀번호<input type="password" size=30 name=password1>
<hr>비밀번호 확인<input type="password" size=30 name=password2>
<input type=submit value="확인">
<input type=reset value="취소">
</form>

</body>
</html>
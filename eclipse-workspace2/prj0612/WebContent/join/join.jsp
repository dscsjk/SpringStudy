<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<hr>
	<form name=joinForm method=post action=joinResult.jsp>
	아이디 <input type="text" size=10 name=userid><br><hr>
	패스워드<input type="text" size=10 name=pwd><br><hr>
	직업<select name=job>
		<option selected>학생</option>
		<option>회사원</option>
		<option>전문직</option>
	</select><br><hr>
	관심분야
	<input type=checkbox name=favorite value="정치">육아</input>
	<input type=checkbox name=favorite value="사회">Working</input>
	<input type=checkbox name=favorite value="정보통신">IT</input>
	<br><hr>
	<input type= submit value="확인">
	<input type= reset value="취소">
	</form>
</body>

</html>
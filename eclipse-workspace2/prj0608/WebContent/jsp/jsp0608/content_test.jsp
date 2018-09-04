<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- include지시어
현재 jsp파일에 다른 html이나 jsp를 포함하기 위해 사용 -->
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<center>
<hr> include 지시어 테스트 </h2>
<hr>
<%@ include file="menu.jsp"%>
<hr>
<%@ include file="news.jsp" %>
<hr>
<%@ include file="shopping.jsp" %>
<hr>

<form name=form1 method=post action=request_result.jsp>
<hr>이름  <input type="text" size=10 name=username>
<hr>직업  <select name=job>
<option selected>주부</option>
<option>회사원</option>
<option>전문직</option>
<option>학생</option>
</select>
<hr>관심분야<input type="checkbox" name=favorite value="정치">정치</input>
<input type="checkbox" name=favorite value="사회">사회</input>
<input type="checkbox" name=favorite value="정보통신">정보통신</input>
<input type=submit value="확인">
<input type=reset value="취소">
</form>
</body>
</html>
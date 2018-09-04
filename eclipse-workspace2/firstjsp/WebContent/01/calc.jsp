<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!
int n1,n2;
int result=0;
String op="";
public int cal() {
	if(op.equals("+")) {
		result = n1+n2;
	} else if(op.equals("-")) {
		result = n1-n2;
	} else if(op.equals("*")) {
		result = n1*n2;
	} else if(op.equals("/")) {
		result = n1/n2;
	}
	return result;
}
%>
<%
if(request.getMethod().equals("POST")) {
	n1=Integer.parseInt(request.getParameter("n1"));
	n2=Integer.parseInt(request.getParameter("n2"));
	op= request.getParameter("operator");
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>선언태그를 이용한 계산기 예제</title>
</head>
<body>
<center>
<h3>계산기</h3>
<hr>
<form name=form1 method=post>
<input type="text" name = "n1" value="0"  width=200 size="5">
<select name="operator">
<option selected>+</option>
<option >-</option>
<option >*</option>
<option >/</option>
</select>
<input type = "text" name = "n2" value="0"   width=200 size="5">
<input type = "submit" value = "계산"  name="B1">
<input type = "reset" value = "다시계산"  name="B2">
</form>
<hr>계산결과:<%=cal() %>
</center>
</body>
</html>
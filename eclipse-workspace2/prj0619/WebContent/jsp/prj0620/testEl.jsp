<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String somValue="2004";
request.setAttribute("title", "EL연습");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form1" method=post action="testEl1.jsp">
<input type="text" name="name">
<input type="text" name="age">
<input type="submit" value="확인">
</form>

1.수치연산자+-*/%정수타입과 실수타입만 동작.숫자와 객체연산은 숫자로 변환 후 연산 수행<br>
\${10+1} : ${10+1}</br>
\${"10"+1} : ${"10"+1}</br>
\${"십"+1} : \${"십"+1}</br>
\${null+1} : ${null+1}</br>
\${3/2} : ${3/2}</br>
<hr>
2.비교연산자<br>
\${somValue=='2004'} \${somValue} : ${somValue} -> ${somValue=='2004'}<br>
\${empty somValue} : ${empty somValue}<br>
\${somValue='2002'} : ${somValue='2002'}<br>
\${somValue+1} : ${somValue+1}<br>
<%=(somValue.compareTo("2004")==0)%><br>
\${somValue=='2004'} : ${somValue} -> ${somValue=='2004'}<br>
<hr>
3.문자열 연결<br>
${"제목"+=title }<br>
</body>
</html>
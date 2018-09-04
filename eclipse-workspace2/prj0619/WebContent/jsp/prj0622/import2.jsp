<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>import 태그</title>
</head>
<!--  url속성의 자원은 var에 지정된 변수로 문자열 형태로 저장된다.
포함한 자원의 내용을 출력하려면 var변수를 출력한다.
동적으로 간단한 페이지를 포함할 경우 편리
파일용량이 클때 특히 외부자원 포함시 성능 저하 발생 -->
<body bgcolor="#FFFFFF">
<h3>&lt;c:import&gt;</h3>
다음은 import를 이용해 포함한 것입니다.<hr>

<!--  단순 텍스트 페이지인 경우 c:out을 사용하지 않고 EL로 출력해도 됨
포함하는 페이지가 html태그를 포함하고 있으므로 화면에 태그가 아닌
정상화면으로 보이게 하기 위해 c:out,escape="false"로 설정함 -->
<c:import url="choose.jsp" var="myurl"/>
<c:out value="${myurl}" escapeXml="false"/>
<hr>
<c:import url="test.txt" var="myurl3"/>
<c:out value="${myurl3}" escapeXml="false"/>
<hr>
<c:import url="http://www.hanbit.co.kr/academy/" var="myurl2"/>
<c:out value="${myurl2}" escapeXml="false"/>
</body>
</html>
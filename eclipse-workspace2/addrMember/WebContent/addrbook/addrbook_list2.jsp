<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,addrMember.*"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>

<!-- jsp:useBean id="datas" scope="request" class="java.util.ArrayList"/-->
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="addrbook.css" type="text/css" media="screen" />

<script type="text/javascript">
	function check(ab_id) {
		pwd = prompt('수정/삭제 하려면 비밀번호를 넣으세요');
		document.location.href=
			"addrbook_control.jsp?action=edit&ab_id="+ab_id;
//			"addrbook_control.jsp?action=edit&ab_id="+ab_id+"&upasswd="+pwd;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:목록화면</title>
</head>
<body>
<div align="center"> 
<H2>주소록:목록화면</H2>
<HR>
<form>
<a href="addrbook_form.jsp">주소록 등록</a><P>
<mytag:item border="10" bgcolor="red"></mytag:item>
</form>
</div>
</body>
</html>


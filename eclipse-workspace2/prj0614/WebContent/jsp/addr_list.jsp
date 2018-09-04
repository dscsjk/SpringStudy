<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="prj0614_01.AddrBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="am" class="prj0614_01.AddrManager" scope="application" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 목록</title>
</head>

<body>
<h2>주소록</h2>
<hr>
<a href="addr_form.html">주소추가</a>
<hr>
이름	전화번호	이메일	성별
<form name=form1 method="post" >
	<input type=hidden name="username" >
	<input type=hidden name="tel" >
	<input type=hidden name="email" >
	<input type=hidden name="sex" >
	<input type=hidden name="index">
<%
	int i=0;
	for( AddrBean ab : am.getAddrList()) {
%>
		<%= ab.getUsername()%>  
		<%= ab.getTel()%> 
		<%= ab.getEmail()%> 
		<%= ab.getSex()%>
		<input type=button value="삭제" onClick="goDel('<%=i%>','<%= ab.getUsername()%>','<%= ab.getTel()%>','<%= ab.getEmail()%>','<%= ab.getSex()%>')">
		<BR>
<%
		i++;
	}
%>	
</form>
</body>
<script type="text/javascript">
	function goDel(idx,uname,tell,em,sss){
		document.form1.index.value = idx;
		document.form1.username.value = uname;
		document.form1.tel.value = tell;
		document.form1.email.value = em;
		document.form1.sex.value = sss;
		document.form1.action="<%= request.getContextPath() %>/jsp/addr_del.jsp";
		document.form1.submit();
	}
</script>
</html>
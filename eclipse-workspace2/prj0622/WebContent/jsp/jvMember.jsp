<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,jvMember.*"%>
<jsp:useBean id="datas" scope="request" class="java.util.ArrayList"/>
<!DOCTYPE HTML>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:목록화면</title>
</head>
<body>
<div align="center"> 
<H2>My Simple Twitter</H2>

<form name=form1 method=post action=jvMember_control.jsp>
<input type="hidden" name="action" value="insert">
<table border="0">
  <tr>
    <th><input type="hidden" name="ab_id" value="<%=session.getAttribute("login")%>"/><%=session.getAttribute("login")%></th>	
    <td><input type="text" name="ab_memo" maxlength="300" /></td>
    <td colspan=2 align=center><input type=submit value="twit">
    <input type=reset value="취소">
    </td>
</tr>
    
  </tr>
</table>
</form>
<hr>
		<table border="1">
<%
	for(JvMember ab : (ArrayList<JvMember>)datas) {
%>	
			  <tr>
				<td><%=ab.getAb_id()%></a></td>
				<td><%=ab.getAb_memo()%></td>
				<td><%=ab.getAb_tdate()%></td>
			  </tr>
<% } 
%>
		</table>
</div>
</body>
</html>


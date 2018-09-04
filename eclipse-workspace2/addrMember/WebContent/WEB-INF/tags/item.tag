<%@ tag body-content="scriptless" language="java" pageEncoding="UTF-8" import="java.util.*, addrMember.*"%>
<%@ attribute name="bgcolor" %>
<%@ attribute name="border" %>

<jsp:useBean id="datas" scope="request" class="java.util.ArrayList"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">

<h2><jsp:doBody/></h2>
<table border="${border}" bgcolor="${bgcolor}" width="150">
<tr><th>번호</th><th>이 름</th><th>전화번호</th><th>생 일</th><th>회 사</th><th>메 모</th></tr>
<%
	for(AddrBook ab : (ArrayList<AddrBook>)datas) {
		out.print("<tr><td><a href=\"javascript:check("+ab.getAb_id()+")\">"+ab.getAb_id()+"</a></td>");
		out.print("<td>"+ab.getAb_name()+"</td>");
		out.print("<td>"+ab.getAb_tel()+"</td>");
		out.print("<td>"+ab.getAb_birth()+"</td>");
		out.print("<td>"+ab.getAb_comdept()+"</td>");
		out.print("<td>"+ab.getAb_memo()+"</td></tr>");
	} 
%>
</table>

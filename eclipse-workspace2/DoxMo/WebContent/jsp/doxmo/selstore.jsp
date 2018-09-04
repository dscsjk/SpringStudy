<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, doxmo.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8"); %>

<html>
<head>
<jsp:useBean id="sl" scope="request" class="doxmo.DoxMoDAO"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Select Store</title>
</head>

<body>
<form method=post name="StoreList" action="<%=request.getContextPath() %>/jsp/oooo.jsp">

<%
	session.setAttribute("store_no",request.getParameter("store_no"));


	ArrayList<StoreList> datas = sl.getDBList();
	int i=0; 
	for(StoreList storelist : (ArrayList<StoreList>)datas) {
%>	

	<li>
	<%=storelist.getStorename() %>
	<%=storelist.getAddress() %>
	<%=storelist.getTel() %>
		</li>
	<a href="<%=request.getContextPath() %>/jsp/doxmo/000.jsp?store_no=<%=storelist.getStoreNo() %>">매장선택</a>
	
<%
}
%>	

<script type="text/javascript">
alert("매장이 선택되었습니다.");
</script>
</form>
</body>
</html>

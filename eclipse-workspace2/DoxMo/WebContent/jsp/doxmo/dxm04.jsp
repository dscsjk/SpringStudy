<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, doxmo.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="ab" class="doxmo.DoxMoDAO"/>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>매장리스트</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<style>
.frame {width:500px;margin:0 auto;}
.list-unstyled > li {float:left;width:33%;padding:5px;}
.form-submit {float:none;clear:both;margin-top:30px;text-align:center;}
.card {position:relative;}
.form-chekbox {position:absolute;right:10px;bottom:10px;}
</style>
</head>
<body>
매장 선택
<form method=post name="listForm" action="<%=request.getContextPath() %>/jsp/order.jsp">
<table>
<%
	// 메뉴테이블에서 메뉴를 가져온다.
	ArrayList<Dxm06> datas = ab.getStoreList();
	for(Dxm06 dxm06 : (ArrayList<Dxm06>)datas) {
%>	
<td><%=dxm06.getStore_nm()%> </td>
<td><%=dxm06.getStore_tel()%> </td>
<td><%=dxm06.getStore_addr()%></td>
<td>
<a href="javascript:setAddress('86485', '', '4412026', 'N', '');" class="btn"><span class="btn_txt">선택</span></a>

		    <input type="hidden" value="<%= dxm06.getStore_cd()%>">
		    <input type="button" value="선택">
</td><tr>
<% 
	} 
%>		  
</table>
</form>
</div>
</body>
</html>
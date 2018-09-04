<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, prj0626.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="ab" class="prj0626.OrderDAO"/>

<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>수정 분식</title>
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
<!-- 주문음식만 보이는 화면으로 간다. order.jsp -->
<form method=post name="listForm" action="<%=request.getContextPath() %>/jsp/order.jsp">
<div class="frame">
<ul class="list-unstyled">
<%
	// 세션 생성
	session.setAttribute("login",request.getParameter("ad_id"));
	System.out.println("세션id"+session.getAttribute("login"));

	// 메뉴테이블에서 메뉴를 가져온다.
	ArrayList<Menu> datas = ab.getMenuList();
	int i=0; // 체크화면 배열넘버 설정
	for(Menu menu : (ArrayList<Menu>)datas) {
%>	
	<li>
		<div class="card">
		  <div class="card-body">
		  	<input type="hidden" name="mcd" value="<%=menu.getmCd()%>">
		  	<input type="hidden" name="mname" value="<%=menu.getmName()%>">
		  	<input type="hidden" name="mprice" value="<%=menu.getmPrice()%>">
		    <h5 class="card-title"><%=menu.getmName()%></h5>
		    <p class="card-text"><%=menu.getmPrice()%></p>
		  </div>
		  <input type="checkbox" name="mck" value="<%=i%>" class="form-chekbox">
		</div>
	</li>
<% 
		i++; //체크 옵션 배열값 설정
	} 
%>		  
</ul>
<div class="form-submit" method=post>
	<button type="submit" class="btn btn-lg btn-primary" >주문</button>
</div>
</form>
</div>
</body>
</html>
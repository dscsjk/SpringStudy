<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, doxmo.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="ab" class="doxmo.DoxMoDAO"/>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html lang="ko">
<% 
Dxm01 data = (Dxm01) session.getAttribute("login"); 
%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>물품리스트</title>
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
<center>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/orderList.jsp">주문조회</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/main.jsp">DoxMo피자</a>
<%
Dxm01 dxm01;
if (!session.isNew()) {
	dxm01 = (Dxm01) session.getAttribute("login");
} else { dxm01 = null; }

if ( dxm01 == null ) { %>
<a href="<%=request.getContextPath() %>/jsp/doxmo/login.jsp">로그인</a>
<%} else {%>
<a href="<%=request.getContextPath() %>/jsp/doxmo/logout.jsp">로그아웃</a>
<%} %>
<a>회원가입</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/basketList.jsp">장바구니</a>
</h2>
<hr>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=01">피자</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=03">사이드디시</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=05">특가제품</a>
</h2>
<hr>
<h2>
<%
	String prdt_tp = request.getParameter("prdt_tp");
	System.out.println("prdt_tp->"+prdt_tp);
	if (prdt_tp.compareTo("01")==0 || prdt_tp.compareTo("02")==0 ) {
%>		
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=01">프리미엄</a>
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=02">클래식</a>
<%		
	} else if ( prdt_tp.compareTo("03")==0 || prdt_tp.compareTo("04")==0 ) {
%>		
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=03">사이드디시</a>
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=04">음료</a>
<%		
	} else {
	}
%>
</h2>
<hr>
<form method=post name="listForm" action="<%=request.getContextPath() %>/jsp/doxmo/order.jsp">
<div class="frame">
<ul class="list-unstyled">
<%
	// 메뉴테이블에서 메뉴를 가져온다.
	ArrayList<Dxm03> datas = ab.getPrdtList(prdt_tp);
	for(Dxm03 dxm03 : (ArrayList<Dxm03>)datas) {
%>	
	<li>
		<div class="card">
		  <div class="card-body">
		    <a href="<%=request.getContextPath() %>/jsp/doxmo/dxm03.jsp?prdt_tp=<%=prdt_tp%>&prdt_cd=<%=dxm03.getPrdt_cd()%>">
		    	<img src="http://localhost:9999/Doxmo/img/<%=dxm03.getPrdt_img() %>" alt="<%=dxm03.getPrdt_nm() %>" height="100" width="100">
		    </a>
		    <h5 class="card-title"><%=dxm03.getPrdt_nm()%></h5>
		    <p class="card-text">
<%
		ArrayList<Dxm04> datas2 = ab.getPriceList(dxm03.getPrdt_cd());
		for(Dxm04 dxm04 : (ArrayList<Dxm04>)datas2) {
			if (dxm04.getPrdt_cd().charAt(0)=='P') { 
%>	
			    <%=dxm04.getPrdt_sz() %>:<%=dxm04.getPrice() %> &nbsp&nbsp&nbsp
<%
			} else {
%>
			    <%=dxm04.getPrice() %>
<%
			}
		}
%>		    
		    </p>
		  </div>
		</div>
	</li>
<% 
	} 
%>		  
</ul>
</form>
</div>
</body>
</html>
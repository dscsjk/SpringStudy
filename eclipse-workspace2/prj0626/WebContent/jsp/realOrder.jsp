<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,prj0626.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="ab" class="prj0626.OrderDAO"/>
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
<form name="form1"  method=post action=<%=request.getContextPath() %>/jsp/list.jsp>
<div class="frame">
<ul class="list-unstyled">
<%
	OrdNum odList = new OrdNum();
	
	System.out.println(String.valueOf(System.currentTimeMillis()));
	System.out.println("세션login"+session.getAttribute("login"));
	System.out.println("세션tprice"+session.getAttribute("tprice"));
	
	// 주문정보를 주문구조체에 담는다.
	odList.setOrderN(String.valueOf(System.currentTimeMillis()));
	odList.setuId((String) session.getAttribute("login"));
	odList.settPrice((int) session.getAttribute("tprice"));
	
	// DB에 주문정보를 집어넣는다.
	boolean bResult = ab.setOderList((ArrayList<OrdList>)session.getAttribute("datas"), odList);
	
	// DB에서 주문한 메뉴와 값을 리스트로 가져온다. 
	ArrayList<OrdList> datas = ab.getOrderList(odList);
	
	int i=0;
	for(OrdList odNum : (ArrayList<OrdList>)datas) {
%>	
		<li>
			<div class="card">
			  <div class="card-body">
			    <h5 class="card-title"><%=odNum.getmName()%></h5>
			    <p class="card-text"><%=odNum.getmPrice()%></p>
			  </div>
			</div>
		</li>
	
<%
	}
%>
</ul>
총액 : <%=session.getAttribute("tprice")%>
<div class="form-submit" method=post action=<%=request.getContextPath() %>/jsp/order.jsp>
	<input type="hidden" name="ad_id" value="<%=session.getAttribute("login") %>" size="20">
	<button type="submit" class="btn btn-lg btn-primary">다시 주문화면</button>
</div>
</div>
<%
// 주문이 끝났으므로 주문관련 세션정보를 초기화한다.
session.removeAttribute("datas"); 
session.removeAttribute("tprice"); 
%>
</form>
</body>
</html>
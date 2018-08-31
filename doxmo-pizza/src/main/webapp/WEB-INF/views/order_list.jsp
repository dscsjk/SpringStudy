<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>도아니모피자</title>
	<meta name="viewport" id="viewport" content="width=1119px, user-scalable=yes">
	<link rel="shortcut icon" href="resources/img/ico/favicon.ico.png"/>
	<link rel="stylesheet" type="text/css" href="resources/css/font.css">
	<link rel="stylesheet" type="text/css" href="resources/css/layout.css?v1.0">
	<link rel="shortcut icon" href="resources/img/ico/favicon.ico.png"/>
</head>
<body>
	<!-- wrap  -->
<jsp:include page="header.jsp"/>

<!-- //container -->

<div id="container">
	<!-- content -->
	<div id="content" class="mypage">
		<!-- sub_title -->
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>주문조회</h2>
			</div>
		</div>
<div class="container">
	<div class="wrapper">
		<div class="order_table">
			<table class="tbl_type">
				<caption>피자 주문</caption>
				<colgroup>
					<col style="width:82px;">
					<col style="width:85px;">
					<col style="width:130px;">
					<col>
					<col style="width:90px;">
					<col style="width:110px;">
					<col style="width:140px;">
				</colgroup>
				<thead>
					<tr>
						<th>주문일자</th>
						<th>주문방식</th>
						<th>주문번호</th>
						<th>주문내역</th>
						<th>결제금액</th>
						<th>주문매장</th>
						<th>주문상태</th>
					</tr>
				</thead>
				<tbody>
<c:forEach items='${orderList}' var='dto'>
							<tr>
								<td>${dto.crt_dt}</td>
								<td><span class="ico ico_tag">${dto.rcpt_tp}</span></td>
								<td><p class="order_num"><a href="order_detail?order_no=${dto.order_no}">${dto.order_no}</a></p></td>
								<td><p>${dto.order_prdt}</p></td>
								<td>${dto.tt_pay}원</td>
								<td>${dto.store_nm}<br>${dto.store_tel}</td>
								<td>${dto.order_st}</td>
							</tr>
</c:forEach>
					</tbody>
			</table>
			
			<div class="page_nav">
				<ul>
				<li><a href='order_list?pageNo=1' onclick=''><<</a></li>
<c:forEach  var = "i" begin="1" end="${totCnt}">		
				
					<c:if test="${nowPage == i}"><li><strong>${i}</strong></li>  </c:if>
					<c:if test="${nowPage != i}"><li><a href='order_list?pageNo=${i}' onclick=''><c:out value = "${i}"/></a></li>  </c:if>
</c:forEach>					
				<li><a href='order_list?pageNo=${totCnt}'>>></a></li>
				</ul>
			</div>
			
		</div>
	</div>
</div>
	</div>
</div>

</body>
</html>







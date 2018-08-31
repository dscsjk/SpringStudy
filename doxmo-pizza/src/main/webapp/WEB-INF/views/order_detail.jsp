<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<script type="text/javascript">
	function goOrderCnt(sel){
		f=sel.form;
		f.action="basket_add";
		f.submit();
	}
	
	function goBasketDel(sel){
		f=sel.form;
		f.action="basket_del";
		f.submit();
	}
</script>
</head>

<body>
<jsp:include page="header.jsp"/>
<div id="container">
	<div id="content" class="mypage">
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>주문조회</h2>
			</div>
		</div>
	
		<div class="container">
			<div class="wrapper">
				<div class="order_total_table">
					<p class="title"><strong>* 주문번호</strong>${orderDetail.order_no} &nbsp&nbsp
					  				<strong>* 주문일시</strong>${orderDetail.crt_dt}</p>
					<table class="tbl_type">
						<caption>피자 주문</caption>
						<colgroup>
							<col>
							<col style="width:161px;">
							<col style="width:222px;">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th><span class="txt_navy">주문제품</span></th>
								<th><span class="txt_navy">수량</span></th>
								<th><span class="txt_navy">가격</span></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td><span class="txt_navy">총합</span></td>
								<td colspan="2"><span class="txt_navy">${orderDetail.tt_pay} 원</span></td>
							</tr>
						</tfoot>
						<tbody>
<c:forEach items='${OrderPrdtList}' var='dto'>						
							<tr>
								<td class="txt_align_lft">
									<span>${dto.prdt_nm}</span>
									</td>
								<td>${dto.order_cnt}</td>
								<td><p class="price">${dto.price} 원</p></td>
							</tr>
</c:forEach>							
						</tbody>
					</table>
					<!-- //table -->
				</div>
				<!-- //order_table -->
			</div>
			<div class="wrapper">
				<ul class="order_info_inner">
					<li>
						<ul class="order_info_list">
							<li>
								<div class="info_title"><span class="ico order_lst_ico01"></span>결제방법</div>
								<div class="info_content">${orderDetail.pay_tp} ${orderDetail.tt_pay} 원 ${orderDetail.order_st} 
								</div>
							</li>

							<li>
								<div class="info_title"><span class="ico order_lst_ico03"></span>수령인</div>
								<div class="info_content">${orderDetail.rcpt_nm}</div>
							</li>
							<li>
								<div class="info_title"><span class="ico order_lst_ico05"></span>수령인 연락처</div>
								<div class="info_content">${orderDetail.rcpt_tel}</div>
							</li>
						</ul>
					</li>
					<li>
						<ul class="order_info_list">
							<li>
								<div class="info_title"><span class="ico order_lst_ico09"></span>매장명</div>
								<div class="info_content">${orderDetail.rcpt_tp}</div>
								</li>
							<li>
								<div class="info_title"><span class="ico order_lst_ico06"></span>매장정보</div>
								<div class="info_content">${orderDetail.store_nm} (${orderDetail.store_tel})</div>
							</li>
							</ul>
					</li>
				</ul>
		</div>

	</div>

<script type="text/javascript">
function goOrder() {
	document.OrderForm.submit();
}
</script>

</body>
</html>


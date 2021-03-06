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
</head>
<body>
<script type="text/javascript">
	function goOrderCnt(sel){
		f=sel.form;
		f.action="basket_add";
		f.submit();
	}
	
	function goBasketDel(sel){
		f=document.querySelector("#basketDelForm"+sel);
		//console.log("#basketDelForm"+sel)
		f.submit();
	}
	
	function goBasketOrder(cnt){
		if (cnt == 0) {
			alert("장바구니가 비어 있습니다.");
		} else {
			orderForm.submit();
		}
	}

</script>

<jsp:include page="header.jsp"/>


<!-- container -->
<div id="container">
	<!-- content -->
	<div id="content" class="cart_payment">

		<!-- sub_title -->
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>장바구니</h2>
			</div>
		</div>
		<!-- //sub_title -->

		<div class="order_cart">
			<!-- 배달 -->
			<!-- // 배달 -->
			<!-- 포장 -->
			<div class="order_section order_type">
					<div class="tit_order btn_tit2">
						<strong><c:if test="${RcptTp.rcpt_tp == '01' }">배달주문</c:if><c:if test="${RcptTp.rcpt_tp == '02' }">방문포장</c:if></strong>
					</div>
					<div class="order_adr">
						<strong class="order_store_info">${RcptTp.rcpt_nm}<span>(${RcptTp.rcpt_tel})</span></strong>
						<p class="addr_info">${RcptTp.rcpt_addr}</p>
					</div>
				</div>
			<!-- // 포장 -->

			<div class="order_section cart_lst">
					<div class="tit_order">
						<strong>주문제품</strong>
					</div>
					<div class="cart_lst_warp">
						<div class="cart_lst_tbl">
							<table class="tbl_type">
								<caption>주문제품 리스트</caption>
								<colgroup>
									<col>
									<col width="100px">
									<col width="100px">
									<col width="100px">
								</colgroup>
								<thead>
									<tr>
										<th>제품정보</th>
										<th>판매가격</th>
										<th>수량</th>
										<th>삭제</th>
									</tr>
								</thead>
								<tbody>
<c:set var="index" value="0" />
<c:set var="totPrice" value="0"/>
<c:forEach items="${OrderList}" var="dto">
<c:set  var="index" value="${index+1}" />
								
								<tr>
										<td>
											<div class="prd_info_view">
												<div class="prd_img">
													<img src="resources/img/${dto.prdt_img}" alt="${dto.prdt_nm}" />
																</div>
												<div class="prd_info">
													<div class="prd_name">
														${dto.prdt_nm} &nbsp ${dto.prdt_sz}</div>
												</div>
											</div>
										</td>
										<td><fmt:formatNumber value="${dto.price}" pattern="###,###,###"/> 원</td>
<c:set var="totPrice" value="${totPrice+(dto.price*dto.order_cnt)}"/>										
										<td>

										<div class="sel_box">
<form name="basketChangeForm${index}" action="basket_add" method="post">
<input type="hidden" name="prdt_cd" value="${dto.prdt_cd}">
<input type="hidden" name="prdt_sz" value="${dto.prdt_sz}">
											
											<select name="order_cnt" onchange="goOrderCnt(this)" title="수량">
	<option value="1" <c:if test="${dto.order_cnt eq 1 }">selected="selected"</c:if> >1 </option>
	<option value="2" <c:if test="${dto.order_cnt eq 2 }">selected="selected"</c:if> >2 </option>
	<option value="3" <c:if test="${dto.order_cnt eq 3 }">selected="selected"</c:if> >3 </option>
	<option value="4" <c:if test="${dto.order_cnt eq 4 }">selected="selected"</c:if> >4 </option>
	<option value="5" <c:if test="${dto.order_cnt eq 5 }">selected="selected"</c:if> >5 </option>
													    </select>	
</form>
<form id="basketDelForm${index}" action="basket_del" method="post">
<input type="hidden" name="prdt_cd" value="${dto.prdt_cd}">
<input type="hidden" name="prdt_sz" value="${dto.prdt_sz}">
</form>													    										
										</div>

										</td>
										<td><a href="#" id="deltest" onclick="goBasketDel(${index})" class="btn"><span class="btn_txt">삭제</span></a></td>
									</tr>
									
</c:forEach>									
								</tbody>
							</table>
						</div>
						<div class="basic_providing">
							<dl>
								<dt>※ 피클&amp;소스 기본 제공 안내</dt>
								<dd>
									<div class="lst_type v2">
										<ul>
											<li>L :  피클 L (120g) 1개 / 핫소스 2개 / 갈릭디핑소스 15g, M : 피클 M (75g) 1개 / 핫소스 1개 / 갈릭디핑소스 15g 1개</li>
											<li>씬, 더블크러스트 치즈멜팅 피자는 갈릭디핑소스 미 제공</li>
											<li>사이드디시 &gt; 피클&amp;소스 추가 구매 가능</li>
										</ul>
									</div>
								</dd>
							</dl>
						</div>
					</div>
				</div>
				<div class="order_section cart_total">
				
					<div class="tit_order">
						<strong>총 주문 금액</strong>
					</div>
					<div class="cart_total_wrap">
						<div class="price_wrap">
							<p><fmt:formatNumber value="${totPrice}" pattern="###,###,###"/> 원</p>
						</div>
						<div class="btn_wrap">
							<a href="prdt_list" class="btn btn_mdle btn_basic"><span class="btn_txt">제품 추가 +</span></a>
							<a href="#" onclick="goBasketOrder(${index})"  class="btn btn_mdle btn_red btn_basic"><span class="btn_txt">주문하시겠어요?</span></a>
								</div>
					</div>
				</div>
			</div>
	</div>
	<!-- //content -->
</div>
<!-- //container -->
<form name="orderForm" action="order_view" ></form>
</body>
</html>


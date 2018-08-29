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
<iframe id="inicisFrame" name="inicisFrame" title="시스템용" src="" style="display:none;width:0px;height:0px;"></iframe>
<form name="OrderForm" action="order" method="post">
	<div id="hidden_info">
		<input type="hidden" name="order_gubun" id="order_gubun" value="O">
	</div>
	<div id="content" class="cart_payment">
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>주문서 작성</h2>
			</div>
		</div>

		<div class="order_info">
			<!-- 배달 -->
			<div class="order_section order_type">
					<div class="tit_order btn_tit2">
						<strong>
<c:if test="${RcptTp.rcpt_tp == 01 }">배달주문</c:if>
<c:if test="${RcptTp.rcpt_tp == 02 }">방문포장</c:if>
						</strong>
						<a href="#" class="btn"><span class="btn_txt">주문매장 변경</span></a>
					</div>
					<div class="order_adr">
						<p class="addr_info">${RcptTp.rcpt_addr}</p>
						<strong class="order_store_info">${RcptTp.rcpt_nm}<span>(${RcptTp.rcpt_tel})</span></strong>
					</div>
				</div>
			<!-- // 배달 -->
			<!-- 포장 -->
			<!-- // 포장 -->

			<div class="order_section_wrap variable">
				<!-- 주문제품 -->
				<div class="order_section order_prd">
					<div class="tit_order btn_tit">
						<strong>주문제품</strong>
						<a href="prdt_list" class="btn"><span class="btn_txt">메뉴 변경하기</span></a>
					</div>
					<div class="order_prd_info">
						<div id="goodsBrief">
						</div>
						<div id="goods_info">
							<div class="order_prd_lst">
								<table class="tbl_type">
									<colgroup>
										<col>
										<col>
										<col>
									</colgroup>
									<thead>
										<tr>
											<th>주문제품</th>
											<th>수량</th>
											<th>가격</th>
										</tr>
									</thead>
									<tbody id="goodsList">
<c:set var="totPrice" value="0"/>
<c:forEach items="${OrderList}" var="dto">
									
										<tr>
												<td class="txt_align_lft" id="goods_name">
													<span>${dto.prdt_nm} ${dto.prdt_sz}</span>
													<span style="display:none;" id="goods_name_brief">${dto.prdt_nm} ${dto.prdt_sz}</span>
												</td>
												<td>${dto.order_cnt}</td>
												<td><fmt:formatNumber value="${dto.price_t}" pattern="###,###,###"/></td>
												<c:set var="totPrice" value="${totPrice+dto.price_t}"/>
											</tr>
</c:forEach>											
										</tbody>
								</table>
								<input type="hidden" name="total_price" id="total_price" value="33900" />
							</div>
						</div>
					</div>
				</div>
				<!-- // 주문제품 -->

								<!-- 수령인 정보 -->
				<div class="order_section order_sale" id="dc_info">
					<div class="tit_order chk_tit">
						<strong>수령인 정보</strong>
						<span class="custom_form">
							<input type="checkbox" name="chk1" id="recipient" onchange="recipientChange()" checked>
							<label for="recipient" id="recipient_label" class="ip_chk checked">
								<em></em><span>주문자와 동일</span>
							</label>
						</span>
					</div>
					<div class="order_receipt_info">
						<div class="receipt_form">
							<ul>
								<li class="form_name">
									<label for="customerName">이름</label>
									<div class="form_group">
										<div class="form_field">
											<div class="form_item">
												<span class="i_label" style="position: absolute;"></span>
												<input type="text" id="customerName" name="rcpt_nm" value="${User.u_name}" maxlength="30" class="i_text">
											</div>
										</div>
									</div>
								</li>
								<li class="form_name">
									<label for="customerName">전화번호</label>
									<div class="form_group">
										<div class="form_field">
											<div class="form_item">
												<span class="i_label" style="position: absolute;"></span>
												<input type="text" id="customerName" name="rcpt_tel" value="${User.u_tel}" maxlength="30" class="i_text">
											</div>
										</div>
									</div>
								</li>
								<!-- 2017-06-22 // 문구 추가(s) -->
								<li class="num_message">※ 제품 수령을 위하여 연락처를 꼭 확인 해주세요.</li>
								<!-- 2017-06-22 // 문구 추가(e) -->
							</ul>
							<dl>
								<dt>기타 요청 사항</dt>
								<dd>
									<div class="form_item">
										<span class="i_label" style="position: absolute;"></span>
										<textarea id="more_req" name="memo" onkeyup="checkByte(this, 50)" class="i_text" title="기타요청사항"></textarea>
									</div>
								</dd>
							</dl>
						</div>
					</div>
				</div>
				<!-- // 수령인 정보 -->
				
			</div>

			<div class="order_section_wrap variable">

			</div>

			<!-- 결제방법 -->
			<div id="pay_info">
			
			</div>
			<!-- // 결제방법 -->

			<!-- 결제 금액, 퀵 오더로 설정, 결제 및 주문완료 -->
			<div class="order_section order_total" id="final_pay_info">
			
				<div class="order_total_info">

					<dl class="price_total">
						<dt>결제방법</dt>
						<dd><input type="radio" name="pay_tp" value="0" checked="checked" /> 신용카드
							<input type="radio" name="pay_tp" value="1" /> 현금
							<input type="hidden" name="tt_pay" value="${totPrice}" /></dd>
					</dl>
					<div class="order_complete">
						<a href="javascript:goOrder()" id="doOrder" class="btn btn_mdle btn_red btn_basic"><span class="btn_txt">결제 및 주문완료</span></a>
					</div>
					
				</div>
				<div class="order_total_info">
					<dl class="price_total">
						<dt>총 주문 금액</dt>
						<dd><fmt:formatNumber value="${totPrice}" pattern="###,###,###"/>
						</dd>
					</dl>
				</div>
			</div>
			<!-- // 결제 금액, 퀵 오더로 설정, 결제 및 주문완료 -->
		</div>
	</div>
</form>
</div>

<script type="text/javascript">
function goOrder() {
	document.OrderForm.submit();
}
</script>

</body>
</html>


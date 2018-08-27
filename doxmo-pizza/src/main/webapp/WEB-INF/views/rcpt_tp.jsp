<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>도아니모피자</title>
	<meta name="viewport" id="viewport" content="width=1119px, user-scalable=yes">
	<link rel="shortcut icon" href="https://cdn.dominos.co.kr/renewal2016/ko/w/img/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="/resources/css/font.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.dominos.co.kr/renewal2016/ko/w/css/layout.css?v1.0">
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- container -->
<div id="container">
	<!-- content -->
	<div id="content" class="cart_payment">

		<!-- sub_title -->
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>주문매장 선택</h2>
			</div>
		</div>
		<!-- //sub_title -->

		<div class="order_store">
			<div class="order_section order_way">
				<!-- 주문방법 -->
				<div class="tit_order">
					<strong>주문방법<em>(주문방법/배달주소 선택 후 장바구니 담기가 가능합니다.)</em></strong>
				</div>
				<div class="order_way_sel">
					<div class="form_group">
						<div class="form_field">
							<span class="custom_form">
								<input type="radio" id="way_rdo" name="order_gubun_radio" value="O"  onchange="selectOG();" checked>
								<label for="way_rdo" class="ip_rdo2 checked">
									<em></em><span>방문포장</span>
								</label>
							</span>
						</div>
						<div class="form_field">
							<span class="custom_form">
								<input type="radio" id="way_rdo2" name="order_gubun_radio" value="W" checked  onchange="selectOG();" disabled>
								<label for="way_rdo2" class="ip_rdo2 ">
									<em></em><span>배달주문</span>
								</label>
							</span>
						</div>
					</div>
				</div>
				<!-- // 주문방법 -->
				<!-- 배달주소 -->
				<div class="order_adr_wrap" id="addr_O" style="display:none;">
					<div class="order_adr_chk">
						<strong>배달주소</strong>
						<a href="javascript:addDelivery('O');" class="btn"><span class="btn_txt">배달주소 등록</span></a>
					</div>
					<div class="order_lately" style="display:none;">
						<table>
								<colgroup>
									<col>
									<col width="170px">
								</colgroup>
								<tbody>
									<tr>
										<td class="empty_data">
											<span class="ico ico_smile3"></span>
											배달주소를 등록해주세요.
										</td>
									</tr>
								</tbody>
							</table>
						</div>
				</div>
				<!-- // 배달주소 -->
				<!-- 포장주소 -->
				<div class="order_addr" id="addr_W" style="">
					<div class="order_adr_chk">
						<strong>포장매장</strong>
						<a href="javascript:addBranch();" class="btn"><span class="btn_txt">포장매장 등록</span></a>
					</div>
				</div>
				<div class="order_lately" style="">
					<table>
							<colgroup>
								<col>
								<col width="170px">
							</colgroup>
							<tbody>
<c:set var="index" value="0" />
<c:forEach items="${RcptTpList}" var="dto">
								<tr id="W_7412370">
										<td>
											<div class="order_adr">
												<strong class="order_store_info">${dto.store_nm}<span>(${dto.store_tel})</span></strong>
												<p class="addr_info">${dto.store_addr}</p>
											</div>
										</td>
										<td class="txt_rgt">
<form name="rcptForm${index}" action="rcpt_tp_choice" method="post">
<input type="hidden" name="prdt_cd" value="${Order.prdt_cd}" >
<input type="hidden" name="prdt_img" value="${Order.prdt_img}" >
<input type="hidden" name="prdt_nm" value="${Order.prdt_nm}" >
<input type="hidden" name="prdt_sz" value="${Order.prdt_sz}" >
<input type="hidden" name="price" value="${Order.price}" >
<input type="hidden" name="order_cnt" value="${Order.order_cnt}" >
<input type="hidden" name="rcpt_tp" value="02" >
<input type="hidden" name="rcpt_addr" value="${dto.store_addr}" >
<input type="hidden" name="rcpt_cd" value="${dto.store_cd}" >
<input type="hidden" name="rcpt_nm" value="${dto.store_nm}" >
<input type="hidden" name="rcpt_tel" value="${dto.store_tel}" >
</form>										
											<a name="test" href="#" class="btn" onclick="document.rcptForm${index}.submit();"><span class="btn_txt">선택</span></a>
										</td>
									</tr>
<c:set var="index" value="${index+1}"/>
</c:forEach>									
								</tbody>
						</table>
					</div>
				<!-- // 포장주소 -->
			</div>
		</div>
	</div>
	<!-- //content -->
</div>
<!-- //container -->

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="ko">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>도아니모피자</title>
	<meta name="viewport" id="viewport" content="width=1119px, user-scalable=yes">
	<link rel="shortcut icon" href="resources/img/ico/favicon.ico.png"/>
	<link rel="stylesheet" type="text/css" href="resources/css/font.css">
	<link rel="stylesheet" type="text/css" href="resources/css/layout.css?v1.0">
	<link rel="shortcut icon" href="resources/img/ico/favicon.ico.png"/>
</head>
<body>
<div class="pop_layer pop_type topping" id="rpzLayer_pop"></div>

<script type="text/javascript">
	function goBasket(sel){
		console.log("#basketForm"+sel)
		f=document.querySelector("#basketForm"+sel);
		
		var cnt1 = Number(f.prdt_cnt.value);
		var cnt2 = Number(f.order_cnt.value);
		var cnt3 = cnt1+cnt2;
		if (cnt3 > 5 ) {
			alert("5개까지 주문 가능합니다. 장바구니 확인하세요");
		} else {
			f.submit();
		}
	}
</script>

<jsp:include page="header.jsp"/>

<!-- container -->
<div id="container">
	<!-- content -->
	<div id="content" class="product">

		<!-- sub_title -->
<c:if test="${prdt_tp == '01' || prdt_tp == '02' }">
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>피자</h2>
			</div>
		</div>
		<!-- //sub_title -->
		<div class="tab_type4 event">
			<ul class="btn_tab">
				<li class="C0102"><a href="prdt_list?prdt_tp=01">프리미엄</a></li>
				<li class="C0104"><a href="prdt_list?prdt_tp=02">클래식</a></li>
			</ul>
		</div>				
</c:if>				
<c:if test="${prdt_tp == '03' || prdt_tp == '04' }">
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>사이드디시</h2>
			</div>
		</div>
		<!-- //sub_title -->
		<div class="tab_type4 event">
			<ul class="btn_tab">
				<li class="C0102"><a href="prdt_list?prdt_tp=03">사이드디시</a></li>
				<li class="C0104"><a href="prdt_list?prdt_tp=04">음료</a></li>
			</ul>
		</div>
</c:if>				
			<div class="tab_content_wrap">
				<div class="tab_content active">
					<div class="lst_prd_type ">
					  <c:set  var="listCnt" value="1" />  
					  <c:forEach items='${dxm03}' var='dto'>					
						<ul>
						
						
						<c:if test="${listCnt%4 == 1 }"><li class="prd_list_rgt"></c:if>
						<c:if test="${listCnt%4 != 1 }"><li class=""></c:if>
<c:if test="${prdt_tp == '01' || prdt_tp == '02' || prdt_tp == '03' }">
							<a href="prdt_detail?prdt_cd=${dto.prdt_cd}&prdt_tp=${prdt_tp}">
</c:if>
								<div class="prd_img">
									<div class="prd_img_view"><img src="resources/img/${dto.prdt_img}" alt="${dto.prdt_nm}"></div>
								</div>
								<div class="prd_info">
									<div class="prd_title">${dto.prdt_nm}</div>
								</div>
<c:if test="${prdt_tp == '01' || prdt_tp == '02' || prdt_tp == '03' }">
							</a>
</c:if>
							<div class="prd_price" >${dto.prdt_sz}
<c:if test="${prdt_tp == '03' || prdt_tp == '04' }">
  				    <c:set  var="prdt_price" value="${fn:replace(dto.prdt_sz,',','')}" />  
                    <form id="basketForm${listCnt}" action="basket" method="post">
                        <input type="hidden" name="prdt_cd" value="${dto.prdt_cd}">
                        <input type="hidden" name="prdt_img" value="${dto.prdt_img}">
                        <input type="hidden" name="prdt_nm" value="${dto.prdt_nm}">
                        <input type="hidden" name="prdt_cnt" value="${sideCnt[dto.prdt_cd]}">
                        <input type="hidden" name="prdt_sz" value=":${fn:replace(prdt_price,'원','')}">
								<div style="text-align:center" class="prd_option">
								<table width="100%" height="100%">
<c:if test="${prdt_tp == '03' || prdt_tp == '04' }">
									<td style="width:60%; vertical-align: middle;" align="right">
                                    <select name="order_cnt">
                                       <option value=1>1&nbsp&nbsp&nbsp&nbsp</option>
                                       <option value=2>2 </option>
                                       <option value=3>3 </option>
                                       <option value=4>4 </option>
                                       <option value=5>5 </option>
                                    </select>
                                    </td>
</c:if>
									<td style="width:40%; vertical-align: middle;" align="center">
									<a href="#" id="basket" onclick="goBasket(${listCnt})"><img src="resources/img/ico/btn_cart2.png" width="60" height="30" ></a>
									</td>
									</table>
								</div>
                    </form>
</c:if>								
							</div>
						</li>
						<c:set  var="listCnt" value="${listCnt+1}" />
						</c:forEach>
						</ul>
					</div>

				</div>

				<div class="lst_guide">
					<ul>
						<li>※ 일부 리조트 및 특수매장은 상기 가격과 차이가 있음 </li>
						<li>※ 모든 사진은 이미지 컷이므로 실제 제품과 다를 수 있습니다.</li>
					</ul>
				</div>
 			</div>
		</div>
	</div>
</div>


</body>
</html>














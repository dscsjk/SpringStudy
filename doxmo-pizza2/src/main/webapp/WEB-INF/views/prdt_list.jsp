<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html lang="ko">
<head>
	<meta charset="euc-kr">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>도아니모피자</title>
	<meta name="viewport" id="viewport" content="width=1119px, user-scalable=yes">
	<link rel="shortcut icon" href="https://cdn.dominos.co.kr/renewal2016/ko/w/img/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="http://localhost:8181/web/resources/css/font.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.dominos.co.kr/renewal2016/ko/w/css/layout.css?v1.0">
</head>
<body>

<jsp:include page="header.jsp"/>



<!-- container -->
<div id="container">
	<!-- content -->
	<div id="content" class="product">

		<!-- sub_title -->
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>피자</h2>
			</div>
		</div>
		<!-- //sub_title -->
		<div class="tab_type4 event">
			<ul class="btn_tab">
				<li class="C0102"><a href="?dsp_ctgr=C0102">프리미엄</a></li>
				<li class="C0104"><a href="?dsp_ctgr=C0104">클래식</a></li>
		</ul>
			<div class="tab_content_wrap">
				<div class="tab_content active">
					<div class="lst_prd_type ">
					  <c:set  var="listCnt" value="1" />  
					  <c:forEach items='${dxm03}' var='dto'>					
						<ul>
						<c:if test="${listCnt%4 == 1 }"><li class="prd_list_rgt"></c:if>
						<c:if test="${listCnt%4 != 1 }"><li class=""></c:if>
							<a href="prdt_detail?prdt_cd=${dto.prdt_cd}">
								<div class="prd_img">
										<div class="prd_img_view"><img src="resources/img/${dto.prdt_img}" alt="${dto.prdt_nm}"></div>
									</div>
									<div class="prd_info">
										<div class="prd_title">${dto.prdt_nm}</div>
									</div>
							</a>
							<div class="prd_price">
							  <c:forEach items='${dto.prdt_sz}' var='pto'>${pto.prdt_sz} : ${pto.price}<em>원</em>
								<c:if test="${dto.prdt_sz == 'L' }">
									<p class="price_large"><span class="ico ico_s_large"></span>${pto.price}<em>원</em></p></c:if>
								<c:if test="${dto.prdt_sz == 'M' }">
									<p class="price_medium"><span class="ico ico_s_medium"></span>${pto.price}<em>원</em></p></c:if>
							  </c:forEach>
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














<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
	<meta charset="euc-kr">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>도아니모피자</title>
	<meta name="viewport" id="viewport" content="width=1119px, user-scalable=yes">
	<link rel="shortcut icon" href="https://cdn.dominos.co.kr/renewal2016/ko/w/img/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="/resources/css/font.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.dominos.co.kr/renewal2016/ko/w/css/layout.css?v1.0">
	<link rel="shortcut icon" href="https://cdn.dominos.co.kr/renewal2016/ko/w/img/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="/resources/css/font.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.dominos.co.kr/renewal2016/ko/w/css/layout.css?v1.0">
<script type="text/javascript" src="/resources/js/jquery1.11.1.js"></script>
	<script type="text/javascript" src="https://cdn.dominos.co.kr/renewal2016/ko/w/js/ui.js"></script>
	<script type="text/javascript" src="https://cdn.dominos.co.kr/renewal2016/ko/w/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="resources/js/selectbox.js"></script><!-- js 수정함. -->
	<script type="text/javascript" src="resources/js/d2CommonUtil.js?ver=1.5"></script>
	<script type="text/javascript" src="resources/js/Cookie.js"></script>
	<script type="text/javascript" src="resources/js/basket_w.js"></script>
	
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
        
                <!-- prd_detail -->
                <div class="prd_detail">
                    <form name="basketform" action="basket" method="post">
                        <input type="hidden" name="prdt_cd" value="${prdt.prdt_cd}">
                        <input type="hidden" name="prdt_img" value="${prdt.prdt_img}">
                        <input type="hidden" name="prdt_nm" value="${prdt.prdt_nm}">
                                
                    <div class="prd_info">
                        <div class="prd_img_view">
                            <p class="view_pic">* 모든 사진은 이미지 컷이므로 실제 제품과 다를 수 있습니다.</p>
                            
                            <div class="prd_img">
                                <div class="slide_wrap btn_lft btn_type">
                                    <ul class="slides">
                                    <li><img src="resources/img/${prdt.prdt_img}" alt="${prdt.prdt_nm}" /></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
        
                        <div class="prd_order_view">
                            <div class="prd_title">
                                ${prdt.prdt_nm}</div>

						<div class="prd_price">
							<p class="price_large">${prdt.prdt_sz}</p>
						</div>
                            <div class="prd_order">
        
                            <div class="prd_section prd_style">
                                    <dl class="prd_size ">
                                        <dt>사이즈</dt>
                                        <dd>
                                            <div class="sel_box">
                                                <select id="size" class="opt_size" title="사이즈" name="prdt_sz">

                                                        <c:forEach items='${prdtPrice}' var='pto'>
                                                                <option value="${pto.prdt_sz}:${pto.price}">${pto.prdt_sz} : ${pto.price_n} </option>
                                                        </c:forEach>

                                                </select>
                                            </div>
                                        </dd> 
                                    </dl>
                            </div>
						<div class="prd_section prd_quantity">
							<dl>
								<dt>수량&nbsp&nbsp&nbsp</dt>
								<dd>
                                       <select name="order_cnt">
                                              <option value="1">1&nbsp&nbsp&nbsp&nbsp</option>
                                                        <option value="2">2 </option>
                                                        <option value="3">3 </option>
                                                        <option value="4">4 </option>
                                                        <option value="5">5 </option>
                                                    </select>
								</dd>
							</dl>
					</div>
					</div>
					
					<a href="javascript:goBasket()" class="btn btn_mdle btn_red" id="btn_basket"><span class="btn_txt">장바구니 담기</span></a>
                    </div>
                    </div>
                    </form>
                </div>
                
                
                
        
                <div class="prd_detail_view">
                    <div class="tab tab_type4">
						<ul class="btn_tab">
						</ul>
                        <div class="tab_content_wrap">
                            <div class="tab_content active">
                                <div class="detail_view_info">
                                        <p>${prdtDetail.prdt_exp}</p>
                                    </div>
                            </div>
                            <div class="tab_content active">
                                <div class="detail_view_topping">
                                    <table class="tbl_type">
                                            <caption>토핑 정보</caption>
                                            <colgroup>
                                                <col>
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th>메인토핑</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${prdtDetail.prdt_toping}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    <table class="tbl_type">
                                            <caption>원산지 정보</caption>
                                            <colgroup>
                                                <col>
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th>원산지</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>${prdtDetail.prdt_origin}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                            </div>
                            <div class="tab_content active">
                                    <div class="detail_view_nutrient">
                                        <table class="tbl_type">
                                            <caption>영양성분 정보</caption>
                                            <colgroup>
                                                <col/>
                                                <col width="10%">
                                                <col width="10%">
                                                <col width="10%">
                                                <col width="10%">
                                                <col width="10%">
                                                <col width="10%">
                                                <col width="10%">
                                                <col width="10%">
                                            </colgroup>
                                            <thead>
                                                <tr>
                                                    <th colspan="9">영양성분</th>
                                                </tr>
                                            
                                                <tr>
                                                    <th>제품명</th>
                                                    <th>총 중량(g)</th>
                                                    <th>1회분 기준</th>
                                                    <th>1회분 중량<br>(g)</th>
                                                    <th>열량<br>(kcal/1회분)</th>
                                                    <th>단백질<br>(g/1회분)</th>
                                                    <th>포화지방<br>(g/1회분)</th>
                                                    <th>나트륨<br>(mg/1회분)</th>
                                                    <th>당류<br>(g/1회분)</th>
                                                </tr>
                                            </thead>
                                            <tbody id="nutritionTable">
                                                    <c:forEach items='${prdtNutri}' var='nto'>
                                                            <tr>
                                                            <td>${nto.prdt_nm} ${nto.prdt_sz}</td>
                                                            <td>${nto.tt_weight}</td>
                                                            <td>${nto.once_piece}</td>
                                                            <td>${nto.once_weight}</td>
                                                            <td>${nto.calorie}</td>
                                                            <td>${nto.protein}</td>
                                                            <td>${nto.fat}</td>
                                                            <td>${nto.sodium}</td>
                                                            <td>${nto.sugar}</td>
                                                            </tr>
                                                    </c:forEach>
                                            </tbody>
                                        </table>
                                        <p>단위 -총중량, 중량, 단백질, 포화지방, 당류:G/나트륨:MG/ 열량:KCAL</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                     </div>
        
                </div>
                <!-- //prd_detail -->
        
            </div>
            
         
</body>
<script type="text/javascript">
function goBasket() {
	basketform.submit();
}



</script>

</html>














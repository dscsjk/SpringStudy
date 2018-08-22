<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div id="header">
			<div class="header_top">
				<div class="logo_area">
					<div class="util_left">
						<a href="javascript:;" class="btn_ico btn_menu">GNB</a>
						<ul class="util_menu">
							<li><a href="order_list">주문조회 <span id="gnbOrderCnt"></span></a></li>
						</ul>
					</div>
					<h1 class="logo"><a href="/"><img src="https://cdn.dominos.co.kr/renewal2016/ko/w/images/logo.png" alt="Domino"></a></h1>
					<div class="util_right">
						<ul class="util_menu">
						<li><a href="/global/login">로그아웃</a></li>
							<li><a href="/mypage/myLevel">나의정보</a></li>
							</ul>
						<a href="basket_view" class="btn_ico btn_cart"><span class="cart_count"></span>장바구니</a>
					</div>
				</div>
			</div>
			<div class="menu_area">
				<ul class="gnb_menu">
					<li>
						<a href="prdt_list?prdt_tp=01" class="menu01">피자</a>
						<div class="depth2">
							<ul class="list_depth2">
								<li><a href="prdt_list?prdt_tp=01">프리미엄</a></li>
								<li><a href="prdt_list?prdt_tp=02">클래식</a></li>
							</ul>
						</div>
					</li>
					<li>
						<a href="prdt_list?prdt_tp=03" class="menu02">사이드디시</a>
						<div class="depth2">
							<ul class="list_depth2">
								<li><a href="prdt_list?prdt_tp=03">사이드디시</a></li>
								<li><a href="prdt_list?prdt_tp=04">음료</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
			<div class="whole_menu_area">
				<div class="whole_menu_wrap">
					<ul class="whole_menu">
						<li>
							<a href="prdt_list?prdt_tp=01">피자</a>
							<ul class="list_depth2">
								<li><a href="prdt_list?prdt_tp=01">프리미엄</a></li>
								<li><a href="prdt_list?prdt_tp=02">클래식</a></li>
							</ul>
						</li>
						<li>
							<a href="prdt_list?prdt_tp=03">사이드디시</a>
							<ul class="list_depth2">
								<li><a href="prdt_list?prdt_tp=03">사이드디시</a></li>
								<li><a href="prdt_list?prdt_tp=04">음료</a></li>
							</ul>
						</li>
				</div>
			</div>
		</div> 

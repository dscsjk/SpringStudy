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
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
	<!-- content -->
	<div id="content" class="login_wrap">

		<!-- sub_title -->
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2>로그인</h2>
			</div>
		</div>
		<!-- //sub_title -->

		<div class="login_area">
			<form id="loginFrm" name="login_basket" action="login" method="post">
<input type="hidden" name="prdt_cd" value="${Order.prdt_cd}" >
<input type="hidden" name="prdt_img" value="${Order.prdt_img}" >
<input type="hidden" name="prdt_nm" value="${Order.prdt_nm}" >
<input type="hidden" name="prdt_sz" value="${Order.prdt_sz}:${Order.price}" >
<input type="hidden" name="order_cnt" value="${Order.order_cnt}" >
			
				<fieldset>
					<div class="form_box">
						<ul>
							<li>
								<div class="form_item">
									<label for="id" class="i_label"></label>
									<input type="text" name="u_id" id="id" maxlength="20" class="i_text" placeholder="아이디">
								</div>
							</li>
							<li>
								<div class="form_item">
									<label for="passwd" class="i_label"></label>
									<input type="password" name="pswd" id="passwd" maxlength="20" placeholder="비밀번호" class="i_text" onkeydown="javascript:if(event.keyCode==13){doLoginSSL();}">
								</div>
							</li>
						</ul>
						<a href="javascript:doLogin();" class="btn btn_mdle btn_red"><span class="btn_txt">로그인</span></a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<!-- //content -->
</div>
</body><script type="text/javascript">
function doLogin() {
	loginForm.submit();
}


</script>
</html>


</html>
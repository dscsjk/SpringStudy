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
			<form id="loginFrm" name="loginForm" action="login" method="post">
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
</body>
<script type="text/javascript">
function doLogin() {
	loginForm.submit();
}


</script>
</html>
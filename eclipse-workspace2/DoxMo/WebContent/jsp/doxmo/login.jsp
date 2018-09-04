<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
var id_uuid = '';

function doLoginSSL() {
	alert("테스트1");
	if (id.value == "") {
		alert("아이디를 입력해주세요.");
		id.focus();
		return;
	}
	if ($('#id').val().isBlank()){
		alert("아이디를 입력해주세요.");
		$('#id').focus();
		return;
	}
	if ($('#passwd').val().isBlank()){
		alert("비밀번호를 입력해주세요.");
		$('#passwd').focus();
		return;
	}
	var loginId = $('#id').val();

	//자동 로그인 체크(앱)
	var autoLogin = 'N';
	if ($('#autoLogin').prop('checked')) {
		autoLogin = 'Y';
	}

	var saveId = "N";
	//아이디 저장 체크	
	if ($('input:checkbox[id="idcheck"]').is(":checked") == true) { // 아이디 저장을 체크하였을때
		//cookieManager.setCookie("user_id", $('#id').val(), 365); // 쿠키이름을 id로 form.mb_id.value 값을 7일동안 저장
		saveId = "Y";
	} else { // 아이디 저장을 체크하지 않았을때
		//cookieManager.clearCookie("user_id"); // 날짜를 0으로 저장하여 쿠키 삭제
	}
	
	var loginType = sessionStorage.getItem("loginType");
	$.ajax({
		type: "POST",
		url: "/global/loginAjax",
		data: { "id" : loginId,
				"passwd" : $('#passwd').val(),
				"saveId" : saveId,
				"redirectUrl" : $('#redirectUrl').val(),
				"id_type":"D",
				"id_uuid":id_uuid,
				"loginType" : loginType
		},
		dataType : "json",
		success:function(data) {			
		 	if (data.resultData.status == "success") {
		 		if (data.resultData.msg == "changePwd"){
		 			$("#redirect_url").val(data.resultData.redirectUrl);
					$("#chgPasswdFrm").submit();
		 		}else{
		 			location.href = data.resultData.redirectUrl;
		 		}
			} else {
				if (data.resultData.msg == "noId" || data.resultData.msg == "noPasswd" || data.resultData.msg == "noPasswd1" || data.resultData.msg == "noPasswd2") {
					$('#login_fail').addClass("open");
					var top = $(window).scrollTop();
					$('#login_fail').find('.pop_wrap').css('top',top+30+'px');
				} else if (data.resultData.msg == "noPasswd3" || data.resultData.msg == "noPasswd4"){
					var cnt = data.resultData.msg.replace("noPasswd", "");
					alert("로그인 "+cnt+"회 실패하셨습니다.\n5회 이상 로그인 실패 시 로그인이 불가하며,\n비밀번호 찾기 페이지에서 비밀번호 변경 후 이용 가능합니다.");
				} else if (data.resultData.msg == "block"){
					alert("로그인 5회 이상 실패하셨습니다.\n5회 이상 로그인 실패 시 로그인이 불가하며,\n비밀번호 찾기 페이지에서 비밀번호 변경 후 이용 가능합니다.");
					location.href = "/member/findIdPw";
				} else if (data.resultData.msg == "dormancy") {
					if (confirm('회원님의 ID는 휴면 계정으로 관리 중 입니다. 기존 ID 및 정보는 휴면 계정 해제 후 재이용이 가능합니다. 휴면 계정을 해제하시겠습니까?')) {
						$("#loginFrm").attr("action","/member/restartMem").submit();
					} else {
						return;
					}
				} else 
				{
					alert(decodeURIComponent(data.resultData.msg));
					if (data.resultData.redirectUrl) {
						location.href = data.resultData.redirectUrl;
					}
				}
			}
		},
		error: function (error){
			alert("다시 시도해주세요.");
		}
	});
}
</script>
<head>
<title>도아니모피자</title>
</head>
<body>
<center>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/list.jsp">주문조회</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/main.jsp">DoxMo피자</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/login.jsp">로그인</a>
<a>회원가입</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/list.jsp">장바구니</a>
</h2>
<hr>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=01">피자</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=03">사이드디시</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=05">특가제품</a>
</h2>
<hr>
<form name="loginForm" method="post" action="<%=request.getContextPath() %>/jsp/doxmo/dxm01.jsp">
아이디	<input type="text" name="uid"  size="20">
패스워드	<input type="password" name="pswd"  size="20">
		<input type="hidden" name="prdt_tp" value="01">
		<input type="submit" value="로그인">
</form>
</center>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
</head>

<body>

<form name="goPageForm" method="post">
	<input type="button" value="로그인" onclick="go(1)" />
	<input type="button" value="게스트로 메인 가기" onclick="go(2)" />
	<input type="button" value="회원가입" onclick="go(3)" />
</form>

<a href="login/login.jsp">[로그인하기]</a>
<!-- 절대경로 풀 패키지 -->
<a href="<%= request.getContextPath() %>/main/main.jsp">[게스트로 메인 가기]</a>
<a href="join/join.jsp">[회원가입]</a>

</body>
<script type="text/javascript">
	function go(index) {
		if (index == 1){
			// indext.jsp 경로에서 시작
			document.goPageForm.action="login/login.jsp";
		} else if (index == 2) {
			document.session = false;
			document.goPageForm.action="main/main.jsp";
		} else if (index == 3) {
			document.goPageForm.action="join/join.jsp";
		}
		document.goPageForm.submit();
	}
</script>
</html>
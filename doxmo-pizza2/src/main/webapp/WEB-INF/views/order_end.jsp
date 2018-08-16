<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DoxMo Pizza</title>
</head>
<body>

${rtn}
<c:if test="${rtn == 'true' }">주문이 완료 되었습니다.
<a href="prdt_list">피자 주문하기</a>
</c:if>
<c:if test="${rtn == 'false' }">
<script type="text/javascript">
	alert("오류가 발생되었습니다.");
	history.go(-1);
</script></c:if>

</body>
</html>
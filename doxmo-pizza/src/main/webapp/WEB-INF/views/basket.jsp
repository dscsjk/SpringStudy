<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doxmo Pizza</title>
</head>
<body>
장바구니 확인
<form action="rcptTp_basket" method="post">

<table width="600" cellpadding="0" cellspacing="0" border="1">
<td>${User.u_id}</td>
<td>${User.u_name}</td>
<td>${User.u_tel}</td>
</tr>
</table>

<table width="600" cellpadding="0" cellspacing="0" border="1">
<td>${RcptTp.rcpt_tp}</td>
<td>${RcptTp.rcpt_addr}</td>
<td>${RcptTp.rcpt_cd}</td>
<td>${RcptTp.rcpt_nm}</td>
<td>${RcptTp.rcpt_tel}</td>
</tr>
</table>

<table width="600" cellpadding="0" cellspacing="0" border="1">
<c:forEach items="${OrderList}" var="dto">
<tr>
<td>${dto.prdt_cd}</td>
<td>${dto.prdt_img}</td>
<td>${dto.prdt_nm}</td>
<td>${dto.prdt_sz}</td>
<td>${dto.price}</td>
<td>${dto.order_cnt}</td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>

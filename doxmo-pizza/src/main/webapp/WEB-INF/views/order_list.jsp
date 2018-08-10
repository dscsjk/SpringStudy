<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>DoxMo Pizza</title>
</head>
<body>
주문조회

<table width='600' cellpadding='0' cellspacing='0' border='1'>
<c:forEach items='${orderList}' var='dto'>
<tr>
<td>${dto.crt_dt}</td>
<td>${dto.rcpt_tp}</td>
<td>${dto.order_no}</td>
<td>${dto.order_prdt}</td>
<td>${dto.tt_pay}</td>
<td>${dto.store_nm} ${dto.store_tel}</td>
<td>${dto.order_st}</td>
</tr>
</c:forEach>
</table>

</body>
</html>














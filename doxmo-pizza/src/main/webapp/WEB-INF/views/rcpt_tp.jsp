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
주문방법 화면
<table width="600" cellpadding="0" cellspacing="0" border="1">
<c:forEach items="${RcptTpList}" var="dto">
<tr>
<td>
<form action="rcpt_tp_choice" method="post">
<input type="hidden" name="prdt_cd" value="${Order.prdt_cd}" >
<input type="hidden" name="prdt_img" value="${Order.prdt_img}" >
<input type="hidden" name="prdt_nm" value="${Order.prdt_nm}" >
<input type="hidden" name="prdt_sz" value="${Order.prdt_sz}" >
<input type="hidden" name="price" value="${Order.price}" >
<input type="hidden" name="order_cnt" value="${Order.order_cnt}" >
<input type="hidden" name="rcpt_tp" value="02" >
<input type="hidden" name="rcpt_addr" value="${dto.store_addr}" >
<input type="hidden" name="rcpt_cd" value="${dto.store_cd}" >
<input type="hidden" name="rcpt_nm" value="${dto.store_nm}" >
<input type="hidden" name="rcpt_tel" value="${dto.store_tel}" >
<input type="submit" value="확인">
</form>
</td>
<td><a href="?
prdt_cd=${Order.prdt_cd}
&prdt_img=${Order.prdt_img}
&prdt_nm=${Order.prdt_nm}
&prdt_sz=${Order.prdt_sz}
&price=${Order.price}
&order_cnt=${Order.order_cnt}
&rcpt_tp=02
&rcpt_addr=${dto.store_addr}
&rcpt_cd=${dto.store_cd}
&rcpt_nm=${dto.store_nm}
&rcpt_tel=${dto.store_tel}">선택</a>
</td>
<td>${dto.store_nm}</td>
<td>${dto.store_tel}</td>
<td>${dto.store_zip}</td>
<td>${dto.store_addr}</td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>

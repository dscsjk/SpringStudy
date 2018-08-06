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
PRDT_DETAIL.jsp 피자 리스트 화면
<form action="basket" method="post">
<table width='600' cellpadding='0' cellspacing='0' border='1'>
<input type="hidden" name="prdt_cd" value="${prdt.prdt_cd}">
<input type="hidden" name="prdt_img" value="${prdt.prdt_img}">
<input type="hidden" name="prdt_nm" value="${prdt.prdt_nm}">
<tr>
<td>${prdt.prdt_cd}</td>
<td>${prdt.prdt_nm}</td>
<td>${prdt.prdt_tp}</td>
<td>${prdt.prdt_img}</td>
<td>
<select name="prdt_sz">
<c:forEach items='${prdt.prdt_sz}' var='pto'>
	<option value="${pto.prdt_sz}:${pto.price}">${pto.prdt_sz} : ${pto.price} </option>
</c:forEach>
</select>
<select name="order_cnt">
	<option value="1">1 </option>
	<option value="2">2 </option>
	<option value="3">3 </option>
</select>
<input type="submit" value="주문">
</td>
</tr>
</table>
</form>
<table width='600' cellpadding='0' cellspacing='0' border='1'>
<tr><td>${prdtDetail.prdt_exp}</td></tr>
<tr><td>${prdtDetail.prdt_origin}</td></tr>
<tr><td>${prdtDetail.prdt_toping}</td></tr>
</table>
<hr>
<table width='600' cellpadding='0' cellspacing='0' border='1'>
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
</table>
</body>
</html>














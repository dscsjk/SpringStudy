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
prdt_detail.jsp 피자 상세 화면

<table width='600' cellpadding='0' cellspacing='0' border='1'>
<c:forEach items='${prdt}' var='dto'>
<tr>
<td>${dto.prdt_cd}</td>
<td>${dto.prdt_nm}</td>
<td>${dto.prdt_tp}</td>
<td><a href='prdt_detail?prdt_cd=${dto.prdt_cd}'>${dto.prdt_img}</a></td>
<td>
<c:forEach items='${dto.prdt_sz}' var='pto'>
${pto.prdt_sz}: 
${pto.price} &nbsp
</c:forEach>
</td>
</tr>
</c:forEach>
</table>
<hr>

<table width='600' cellpadding='0' cellspacing='0' border='1'>
<tr><td>${prdtDetail.prdt_exp}</td></tr>
<tr><td>${prdtDetail.prdt_origin}</td></tr>
<tr><td>${prdtDetail.prdt_toping}</td></tr>
</table>
<hr>
<table width='600' cellpadding='0' cellspacing='0' border='1'>
<c:forEach items='${prdtNutri}' var='nto'>
<tr>
<td>${nto.prdt_nm}</td>
<td>${nto.tt_weight}</td>
<td>${nto.once_piece}</td>
<td>${nto.once_weight}</td>
<td>${nto.calorie}</td>
<td>${nto.protein}</td>
<td>${nto.fat}</td>
<td>${nto.sodium}</td>
<td>${nto.sugar}</td>
<td><a href='prdt_detail?prdt_cd=${dto.prdt_cd}'>${dto.prdt_img}</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>














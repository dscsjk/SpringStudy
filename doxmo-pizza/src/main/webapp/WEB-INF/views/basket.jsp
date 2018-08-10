<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<script type="text/javascript">
	function goOrderCnt(sel){
		f=sel.form;
		f.action="basket_add";
		f.submit();
	}
	
	function goBasketDel(sel){
		f=sel.form;
		f.action="basket_del";
		f.submit();
	}
</script>


<head>
<meta charset="UTF-8">
<title>Doxmo Pizza</title>
</head>
<body>
주문제품
<table width="600" cellpadding="0" cellspacing="0" border="1">
<tr>
<td>${User.u_id}</td>
<td>${User.u_name}</td>
<td>${User.u_tel}</td>
</tr>
</table>

<table width="600" cellpadding="0" cellspacing="0" border="1">
<tr>
<td>${RcptTp.rcpt_tp}</td>
<td>${RcptTp.rcpt_addr}</td>
<td>${RcptTp.rcpt_cd}</td>
<td>${RcptTp.rcpt_nm}</td>
<td>${RcptTp.rcpt_tel}</td>
</tr>
</table>
<c:if test="${dto.order_cnt == 'null' }">장바구니가 비어 있습니다.</c:if>
<c:if test="${dto.order_cnt != 'null' }">
<table width="600" cellpadding="0" cellspacing="0" border="1">
<tr>
<td>제품코드</td>
<td>제품이미지</td>
<td>제품명</td>
<td>제품사이즈</td>
<td>판매가격</td>
<td>수량</td>
</tr>
<c:set var="index" value="0" />
<c:forEach items="${OrderList}" var="dto">
<tr>
<td>${dto.prdt_cd}</td>
<td>${dto.prdt_img}</td>
<td>${dto.prdt_nm}</td>
<td>${dto.prdt_sz}</td>
<td>${dto.price}</td>
<td>
<form name="basketChangeForm${index}" method="post">
<input type="text" name="prdt_cd" value="${dto.prdt_cd}">
<input type="text" name="prdt_sz" value="${dto.prdt_sz}">
<select name="order_cnt" onchange="goOrderCnt(this)">
	<option value="1" <c:if test="${dto.order_cnt eq 1 }">selected="selected"</c:if> >1 </option>
	<option value="2" <c:if test="${dto.order_cnt eq 2 }">selected="selected"</c:if> >2 </option>
	<option value="3" <c:if test="${dto.order_cnt eq 3 }">selected="selected"</c:if> >3 </option>
	<option value="4" <c:if test="${dto.order_cnt eq 4 }">selected="selected"</c:if> >4 </option>
	<option value="5" <c:if test="${dto.order_cnt eq 5 }">selected="selected"</c:if> >5 </option>
</select>
<input type="button" value="삭제" onClick="goBasketDel(this)">
</form>

</td>
</tr>
<c:set var="index" value="${index+1}"/>
</c:forEach>
</table>
</c:if>

<form name="PrdtListForm" action="prdt_list" method="post"><input type="submit" value="제품추가"></form>

<form name="OrderForm" action="order_view" method="post"><input type="submit" value="제품주문"></form>

</body>


</html>


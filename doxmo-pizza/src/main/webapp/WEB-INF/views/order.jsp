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
>> 주문서 작성
<table width="600" cellpadding="0" cellspacing="0" border="1">
<tr>
<td>
<c:if test="${RcptTp.rcpt_tp == 01 }">배달주문</c:if>
<c:if test="${RcptTp.rcpt_tp == 02 }">방문포장</c:if>
</td>
</tr>
<tr>
<td>${RcptTp.rcpt_addr}</td>
</tr>
<tr>
<td>${RcptTp.rcpt_nm} (${RcptTp.rcpt_tel}) </td>
</tr>
</table>

>> 주문제품
<c:set var="totPrice" value="0"/>
<table width="600" cellpadding="0" cellspacing="0" border="1">
<c:forEach items="${OrderList}" var="dto">
<tr>
<td>${dto.prdt_nm} ${dto.prdt_sz}</td>
<td>${dto.order_cnt}</td>
<td><c:set var="tPrice" value="${dto.price*dto.order_cnt}"/>${tPrice}</td>
<c:set var="totPrice" value="${totPrice+tPrice}"/>

</tr>
</c:forEach>
</table>
<form name="OrderForm" action="order" method="post">
>> 수령인 정보
<table width="600" cellpadding="0" cellspacing="0" border="1">
<tr>
<td>이름 </td>
<td><input type="text" name="rcpt_nm" value="${User.u_name}"></td>
</tr>
<tr>
<td>전화번호 </td>
<td><input type="text" name="rcpt_tel" value="${User.u_tel}"></td>
</tr>
<tr>
<td>기타 요청사항 </td>
<td><textarea name="memo" cols="30" rows="4"></textarea></td>
</tr>
</table>
# 제품 수령을 위하여 연락처를 꼭 확인 해주세요.
>> 결제방법
<table width="600" cellpadding="0" cellspacing="0" border="1">
<tr>
<td><input type="radio" name="pay_tp" value="0" checked="checked" /> 신용카드
	<input type="radio" name="pay_tp" value="1" /> 현금
	<input type="hidden" name="tt_pay" value="${totPrice}" />
</td>
</tr>
</table>

결제 금액 : ${totPrice}
<input type="submit" value="결제 및 주문완료">
</form>
</body>
</html>


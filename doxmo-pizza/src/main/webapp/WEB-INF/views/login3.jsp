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
장바구니 담기 위한 Login 화면

<form action="login_basket" method="post">
<input type="text" name="prdt_cd" value="${Order.prdt_cd}" >
<input type="text" name="prdt_img" value="${Order.prdt_img}" >
<input type="text" name="prdt_nm" value="${Order.prdt_nm}" >
<input type="text" name="prdt_sz" value="${Order.prdt_sz}:${Order.price}" >
<input type="text" name="order_cnt" value="${Order.order_cnt}" >
<input type="text" name="u_id">
<input type="password" name="pswd">
<input type="submit" value="확인">
</form>

</body>
</html>
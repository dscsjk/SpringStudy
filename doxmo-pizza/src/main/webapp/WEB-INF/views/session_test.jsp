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
<form action="basket" method="post">
<input type="text" name="prdt_cd" >
<input type="text" name="prdt_img" >
<input type="text" name="prdt_nm" >
<input type="text" name="prdt_sz"  >
<input type="text" name="price"  >
<input type="text" name="order_cnt"  >
<input type="submit" value="확인">
</form>


<form action="logout" method="post">
<input type="submit" value="logout">
</form>

</body>
</html>

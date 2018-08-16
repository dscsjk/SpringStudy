<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<script >
	function goOrderCnt(){
		document.basketChangeForm.action="test";
		alert(document.basketChangeForm.action);
		document.basketChangeForm.submit();
	}
</script>

<head>
<meta charset="UTF-8">
<title>Doxmo Pizza</title>
</head>
<body>
주문제품
<form name="basketChangeForm">
<select name="order_cnt" onchange="goOrderCnt()">
	<option value="1" >1 </option>
	<option value="2" >2 </option>
	<option value="3" >3 </option>
	<option value="4" >4 </option>
	<option value="5" >5 </option>
</select>
</form>
<select name="" id="" onchange="selectChangeEvent(this)">

   <option value="">사과</option>

   <option value="">바나나</option>

   <option value="">귤</option>

</select>

    <p id="demo">이곳에 설명이 나옵니다.</p>


<script>

   function selectChangeEvent(sel) {
		alert("test");
<!--
      var choiceText = sel.options[sel.selectedIndex].text;

      if(choiceText == '사과') {

         document.getElementById("demo").innerHTML = '사과는 빨갛습니다.';

      } else if(choiceText == '바나나') {

         document.getElementById("demo").innerHTML = '바나나는 노랗습니다.';

      } else {

         document.getElementById("demo").innerHTML = '이곳에 설명이 나옵니다.';

      }
-->
   }

</script>

</html>


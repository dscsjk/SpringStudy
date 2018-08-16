<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="600" cellpadding="0" cellspacing="0" border="1">
<td>번호</td>
<td>이름</td>
<td>제목</td>
<td>날짜</td>
<td>HIT</td>
<tr>
<c:forEach items="${dxm03}" var="dto">
<tr>
<td>
	<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm03.jsp?prdt_tp=${dto.prdt_tp}&prdt_cd=${dto.prdt_cd}">
	<img src="http://localhost:9999/Doxmo/img/${dto.prdt_img}" alt="${dto.prdt_nm}" height="100" width="100"></a>
</td>
<td>${dto.prdt_nm}</td>
<td>
<!-- c:forEach items="${ }begin="1" end="${dto.bIndent}" >-</c:forEach-->
<a href="content_view?bId=${dto.bId }">${dto.bTitle}</a>
</td>
<td>${dto.bDate}</td>
<td>${dto.bHit}</td>
<tr>
<!-- /c:forEach-->
</table>
</body>
</html>
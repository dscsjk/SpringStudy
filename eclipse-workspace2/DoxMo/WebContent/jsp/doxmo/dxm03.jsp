<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, doxmo.*" %>
<jsp:useBean id="ab" class="doxmo.DoxMoDAO"/>

<% request.setCharacterEncoding("utf-8"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/orderList.jsp">주문조회</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/main.jsp">DoxMo피자</a>
<%
Dxm01 dxm01;
String action;
if (!session.isNew()) {
	dxm01 = (Dxm01) session.getAttribute("login");
	if ( session.getAttribute("rcpt_tp") != null ) {
		action="basket";
	} else {
		action="rcpt_tp";
	}
} else { dxm01 = null; action="login"; }

if ( dxm01 == null ) { %>
<a href="<%=request.getContextPath() %>/jsp/doxmo/login.jsp">로그인</a>
<%} else {%>
<a href="<%=request.getContextPath() %>/jsp/doxmo/logout.jsp">로그아웃</a>
<%} %>
<a>회원가입</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/basketList.jsp">장바구니</a>
</h2>
<hr>
<h2>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=01">피자</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=03">사이드디시</a>
<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=05">특가제품</a>
</h2>
<hr>
<h2>
<%
	String prdt_tp = request.getParameter("prdt_tp");
	System.out.println("prdt_tp->"+prdt_tp);
	if (prdt_tp.compareTo("01")==0 || prdt_tp.compareTo("02")==0 ) {
%>		
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=01">프리미엄</a>
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=02">클래식</a>
<%		
	} else if ( prdt_tp.compareTo("03")==0 || prdt_tp.compareTo("04")==0 ) {
%>		
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=03">사이드디시</a>
		<a href="<%=request.getContextPath() %>/jsp/doxmo/dxm02.jsp?prdt_tp=04">음료</a>
<%		
	} else {
	}
%>
</h2>
<hr>

<%	
String prdt_cd = request.getParameter("prdt_cd");
Dxm03 dxm03 = ab.getPrdtInfo(prdt_cd);
%>
<form method="post" action="dxm05.java">
<input type="hidden" name="action" value="<%=action%>">
<table>
<td>
<img src="http://localhost:9999/Doxmo/img/<%=dxm03.getPrdt_img() %>" alt="<%=dxm03.getPrdt_nm() %>" height="200" width="200">
</td>
<td>
<%=dxm03.getPrdt_nm() %></td><tr>
<td>
<%
	ArrayList<Dxm04> datas2 = ab.getPriceList(dxm03.getPrdt_cd());
	for(Dxm04 dxm04 : (ArrayList<Dxm04>)datas2) {
		if (dxm04.getPrdt_cd().charAt(0)=='P') {
%>	
		    <%=dxm04.getPrdt_sz() %>:<%=dxm04.getPrice() %>
<%
		} else {
%>
		    <%=dxm04.getPrice() %>
<%
		}
	}
%>
</td>
<%
	if (prdt_cd.charAt(0)=='P') {
%>		
		<td>사이즈 <select>
<%		for(Dxm04 dxm04 : (ArrayList<Dxm04>)datas2) {
%>	
			<option><%=dxm04.getPrdt_sz() %>:<%=dxm04.getPrice() %> </option>
<%
		}
%>
</select></td>
<%
	}
%>
<td>수량<select>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select></td>
<td>
<input type="submit" value="장바구니 담기">
</td>
</table>
</form>

<% Dxm05 dxm05 = ab.getPrdtDetail(prdt_cd); %>
<h3>제품상세</h3>
<table>
<td><%=dxm05.getPrdt_exp()%></td></tr>
</table>
<hr>

<h3>토핑 및 원산지</h3>
<table>
<td>토핑</td><tr>
<td><%=dxm05.getPrdt_toping() %></td><tr>
</table>
<table>
<td>원산지</td><tr>
<td><%=dxm05.getPrdt_origin() %></td><tr>
</table>
<hr>
<h3>영양정보</h3>
<table>
<td>제품명</td><td>총열량(g)</td><td>1회분기준</td><td>1회분중량(g)</td><td>열량(Kcal/회분)</td><td>단백질(g/1회분)</td><td>포화지방(g/회분)</td><td>나트륨(mg/1회분)</td><td>당류(g/회분)</td><tr>
<% 
	ArrayList<Dxm15> datas3 = ab.getNutrientList(prdt_cd);
	for(Dxm15 dxm15 : (ArrayList<Dxm15>)datas3) {
%>
<td><%=dxm15.getPrdt_nm() %></td>
<td><%=dxm15.getTt_weight() %></td>
<td><%=dxm15.getOnce_piece() %></td>
<td><%=dxm15.getOnce_weight() %></td>
<td><%=dxm15.getCalorie() %></td>
<td><%=dxm15.getProtein() %></td>
<td><%=dxm15.getFat() %></td>
<td><%=dxm15.getSodium() %></td>
<td><%=dxm15.getSugar() %></td>
<tr>
<%
	}%>
</table>
</center>
</body>
</html>

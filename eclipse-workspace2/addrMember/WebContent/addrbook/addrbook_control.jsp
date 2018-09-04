<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,addrMember.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="ab" class="addrMember.AddrBeanDAO"/>
<jsp:useBean id="addrbook" class="addrMember.AddrBook"/>
<jsp:setProperty name="addrbook" property="*"/>
<%
	String action = request.getParameter("action");

	if(action.equals("list")) {
		ArrayList<AddrBook> datas = ab.getDBList();
		request.setAttribute("datas",datas);
		pageContext.forward("addrbook_list.jsp");
	} 
	else if (action.equals("insert")) {
		if(ab.insertDB(addrbook)) {
	response.sendRedirect("addrbook_control.jsp?action=list");
		}else
	throw new Exception("DB 입력 오류");
	} 
	else if (action.equals("edit")) {
		
		AddrBook abook = ab.editDB(addrbook.getAb_id());
		if(abook.getAb_name() != null) {
	request.setAttribute("ab",abook);
	pageContext.forward("addrbook_edit_form.jsp");
		} else
	throw new Exception("DB 조회 오류");
	} else if (action.equals("update")) {
		
		if(ab.updateDB(addrbook)) {
	response.sendRedirect("addrbook_control.jsp?action=list");
		}else
	throw new Exception("DB 갱신 오류");
	} else if (action.equals("delete")) {
		if(ab.deleteDB(addrbook.getAb_id())) {
	response.sendRedirect("addrbook_control.jsp?action=list");
		}else {
	out.println("<script>alert('action 파라미터를 확인해 주세요!!!')</script>");
		}
		
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
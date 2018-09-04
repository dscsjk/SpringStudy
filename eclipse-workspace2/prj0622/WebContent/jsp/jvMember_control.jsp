<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,jvMember.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="ab" class="jvMember.JvMemberDAO"/>
<jsp:useBean id="jvMember" class="jvMember.JvMember"/>
<jsp:setProperty name="jvMember" property="*"/>
<%
	String action = request.getParameter("action");
	if(session.isNew())
	{
		System.out.println("세션 생성");
		session.setAttribute("login",request.getParameter("ad_id"));
	}
	if(action.equals("list")) {
		ArrayList<JvMember> datas = ab.getDBList();
		request.setAttribute("datas",datas);
		System.out.println("1.ad_id:"+jvMember.getAb_id());
		System.out.println("2.ad_id:"+request.getParameter("ad_id"));
		System.out.println(session.getAttribute("login"));
		pageContext.forward("jvMember.jsp");
	} 
	else if (action.equals("insert")) {
		if(ab.insertDB(jvMember)) {
			String str ;
			str="jvMember_control.jsp?action=list";
			System.out.println("ad_id:"+str);
			response.sendRedirect(str);
		}else
			throw new Exception("DB 입력 오류");
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
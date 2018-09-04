<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,prj0626.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8"); %>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>수정 분식</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<style>
.frame {width:500px;margin:0 auto;}
.list-unstyled > li {float:left;width:33%;padding:5px;}
.form-submit {float:none;clear:both;margin-top:30px;text-align:center;}
.card {position:relative;}
.form-chekbox {position:absolute;right:10px;bottom:10px;}
</style>
</head>
<body>
<!-- 결제수행 및 결과 화면 보여주는 곳으로 간다. realOrder.sjp -->
<form method=post name="listForm" action="<%=request.getContextPath() %>/jsp/realOrder.jsp">
<div class="frame">
<ul class="list-unstyled">
<%
	String mCd[] = request.getParameterValues("mcd");		//메뉴코드
	String mName[] = request.getParameterValues("mname");	//메뉴이름
	String mPrice[] = request.getParameterValues("mprice");	//메뉴가격
	String mCk[] = request.getParameterValues("mck");		//메뉴선택

	ArrayList<OrdList> datas = new ArrayList<OrdList>();
	
	if (mCk[0] != null) {
		
		String rmCd;
		String rmName;
		
		int tPrice = 0, rmPrice = 0;
		OrdList odNum = new OrdList();

		// 선택한 메뉴만 세션에 담을 리스트로 만들고 화면에 뿌려준다.
		for (int i =0; i<mCk.length; i++ ) { 
	// 선택한 메뉴 정보를 추출한다.
	rmCd = mCd[Integer.parseInt(mCk[i])];		
	rmName = mName[Integer.parseInt(mCk[i])];
	rmPrice = Integer.parseInt(mPrice[Integer.parseInt(mCk[i])]);
	
	System.out.println(mCk[i]);
	System.out.println("rmcd :"+rmCd);
	System.out.println("rmName :"+rmName);
	System.out.println("rmPrice :"+rmPrice);
	
	// 선택한 메뉴정보를 구조체에 담아 리스트에 추가한다.
	odNum.setmCd(rmCd);
	odNum.setmName(rmName);
	odNum.setmPrice(rmPrice);
	
	// 리스트 추가
	datas.add(odNum);
	// 주문 총액 계산
	tPrice +=rmPrice;
%>
	<li>
		<div class="card">
		  <div class="card-body">
		  	<input type="hidden" name="mcd" value="<%=odNum.getmCd()%>">
		  	<input type="hidden" name="mname" value="<%=odNum.getmName()%>">
		  	<input type="hidden" name="mprice" value="<%=odNum.getmPrice()%>">
		    <h5 class="card-title"><%=odNum.getmName()%></h5>
		    <p class="card-text"><%=odNum.getmPrice()%></p>
		  </div>
		</div>
	</li>

<%
	// 메뉴구조체 reset
	odNum = new OrdList();
		}
		// 세션에 주문정보 설정
		session.setAttribute("datas", datas);
		session.setAttribute("tprice",tPrice);
	}
%>	
</ul>
<div class="form-submit" method=post action=realOder.jsp>
	<button type="submit" class="btn btn-lg btn-primary">결제</button>
</div>
</div>
</form>
</body>
</html>
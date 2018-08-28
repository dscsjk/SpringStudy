<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>도아니모피자</title>
	<meta name="viewport" id="viewport" content="width=1119px, user-scalable=yes">
	<link rel="shortcut icon" href="resources/img/ico/favicon.ico.png"/>
	<link rel="stylesheet" type="text/css" href="resources/css/font.css">
	<link rel="stylesheet" type="text/css" href="resources/css/layout.css?v1.0">
	<link rel="shortcut icon" href="resources/img/ico/favicon.ico.png"/>
    <!meta name="google-signin-client_id" content="508212130822-406iib86tcrhhkoaoc9if90b6fqhebsu.apps.googleusercontent.com">
    <meta name="google-signin-client_id" content="508212130822-v9f1prh29b3ia4o8phra9li41g4uodk1.apps.googleusercontent.com ">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="resources/js/jquery.bxslider.min.js"></script>
        <link href="resources/js/jquery.bxslider.css" rel="stylesheet" />
 
    <script>
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
            console.log('Name: ' + profile.getName());
            console.log('Image URL: ' + profile.getImageUrl());
            console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
        }
    </script>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
	<!-- content -->
	<div id="content" class="mypage">
		<!-- sub_title -->
		<div class="sub_title">
			<div class="sub_title_wrap">
				<h2></h2>
			</div>
		</div>

<div class="container">
	<div class="wrapper">

    <span id="hello"></span><div class="g-signin2" data-onsuccess="onSignIn"></div>    

    <div> 
        <ul class="bxslider">
        <li><img src="resources/img/20180814_rolling2.jpg"/></li>
        <li><img src="resources/img/20180814_rolling3.jpg"/></li>
        <li><img src="resources/img/20180814_rolling4.jpg"/></li>
        </ul>    
    </div>

    <script type="text/javascript">
      var main = new CNTLib.Main('.container','main');
    </script> 
    <script type="text/javascript">
    
    $('.bxslider').bxSlider({
          auto: true,
          //speed: 1400,
          pager : false,
          autoControls: true
    });
  
</script>
		</div>
	</div>

 	</div>
</div>
 
</body>
</html>
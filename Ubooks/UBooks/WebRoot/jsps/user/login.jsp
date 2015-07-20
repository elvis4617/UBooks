<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/jsps/user/login-assets/css/reset.css'/>">
    <link rel="stylesheet" href="<c:url value='/jsps/user/login-assets/css/supersized.css'/>">
    <link rel="stylesheet" href="<c:url value='/jsps/user/login-assets/css/style.css'/>">

	<!-- Javascript -->
	<script type="text/javascript" src="<c:url value='/jsps/user/login-assets/js/jquery-1.8.2.min.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/jsps/user/login-assets/js/supersized.3.2.7.min.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/jsps/user/login-assets/js/supersized-init.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/jsps/user/login-assets/js/scripts.js'/>" ></script>

  </head>
  
  <body>
  	<div class="page-container">
           <h1>Login</h1>
           <br/>
           <p style="color: red; font-weight: 900">${msg }</p>
            <form action="<c:url value='/jsps/user/UserServlet'/>" method="post">
            	<input type="hidden" name="method" value="login"/>	
                <input type="text" name="username" class="username" value="${form.username }"/>
                <input type="password" name="password" class="password" />
                 <input type="Captcha" class="Captcha" name="Captcha" />
                <button type="submit" class="submit_button">Login</button>
                <div class="error"><span>+</span></div>
            </form> 
     </div>
  </body>
</html>

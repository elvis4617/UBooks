<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- CSS -->
    <link rel="stylesheet" href="<c:url value='/adminjsps/login-assets/css/reset.css'/>">
    <link rel="stylesheet" href="<c:url value='/adminjsps/login-assets/css/supersized.css'/>">
    <link rel="stylesheet" href="<c:url value='/adminjsps/login-assets/css/style.css'/>">

	<!-- Javascript -->
	<script type="text/javascript" src="<c:url value='/adminjsps/login-assets/js/jquery-1.8.2.min.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/adminjsps/login-assets/js/supersized.3.2.7.min.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/adminjsps/login-assets/js/supersized-init.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/adminjsps/login-assets/js/scripts.js'/>" ></script>

  </head>
  
  <body>
	<div class="page-container">
           <h1>Admin Login</h1>
           <br/>
           <span style="color: red; font-weight: 900">${msg }</span>
            <form action="<c:url value='/adminjsps/AdminServlet'/>" method="post">
            	<input type="hidden" name="method" value="adminLogin"/>	
                <input type="text" name="username" class="username" value="${form.username }"/>
                <input type="password" name="password" class="password" value="${form.password }"/>
                <button type="submit" class="submit_button">Login</button>
                <div class="error"><span>+ </span></div>
            </form> 
            
     </div>
</html>

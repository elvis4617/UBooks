<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body style="background: rgb(254,238,189);">
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" >
	<c:forEach items="${orderList }" var="order">
		<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
			<td colspan="6">
				订单：${order.oid }　成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.orderTime }"/>　金额：<font color="red"><b>${order.total }</b></font>	已收货（完成）
			</td>
		</tr>
		<c:forEach items="${order.orderItems }" var="item">
			<tr bordercolor="gray" align="center">
			<td width="15%">
				<div><img src="<c:url value='/${item.book.image }'/>" height="75"/></div>
			</td>
				<td>书名：${item.book.bname }</td>
				<td>单价：${item.book.price }元</td>
				<td>作者：${item.book.author }</td>
				<td>数量：${item.count }</td>
				<td>小计：${item.subtotal }元</td>
			</tr>
		</c:forEach>
	</c:forEach>
 
</table>
  </body>
</html>

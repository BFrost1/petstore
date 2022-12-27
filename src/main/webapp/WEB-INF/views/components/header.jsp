<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page isELIgnored = "false" %>
	
<!DOCTYPE html>
<html lang="ua">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
	<link rel="stylesheet" href="./static/css/style.css">
	<title>Pet Shop</title>
</head>
<body>
	<header class="header">
		<a class="logo"> <i class="fas fa-paw"></i> Dog</a>
		<nav class="navbar">
			<a href="./">Головна</a>
			<a href="./shop">Магазин</a>
			<a href="./services">Послуги</a>
			<a href="./hotel">Готель</a>
			<a href="./contacts">Контакти</a>
		</nav>
		<div class="icons">
			<div class="fas fa-shopping-cart" id = "cart-btn"></div>		
			<c:choose>
			    <c:when test="${sessionScope.user == null}">
					<div class="fas fa-user" id = "login-btn"></div>
			    </c:when>    
			    <c:otherwise>
					<div id='account'>
						<a  href='./account' class='fa-solid fa-user-check'></a>
						<div class='fa-solid fa-right-from-bracket' id ='logout'></div>
					</div>
			    </c:otherwise>
			</c:choose>
		</div>
		<%@include file="/WEB-INF/views/components/login_form.jsp"%>
		<%@include file="/WEB-INF/views/components/cart_form.jsp"%>
	</header>

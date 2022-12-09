<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="/WEB-INF/views/components/header.jsp"%>
<main>
	<h1 class="heading">
		Наші <span>товари</span>
	</h1>
	<section class="shop">
		<div class="category">
			<h4>Що бажаєте?</h4>
			<nav class="navbar-category">
				<%@include file="/WEB-INF/views/components/categories_shop.jsp"%>
			</nav>
		</div>
		<div class="box-container">
			<%@include file="/WEB-INF/views/components/products_shop.jsp"%>
		</div>
	</section>
</main>
<%@include file="/WEB-INF/views/components/footer.jsp"%>

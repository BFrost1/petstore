<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<c:forEach var="product" items="${products}">
	<div class="box" id="${product.id}">
		<div class="image">
			<img
				src="./static/images/products/${product.category.url}/${product.imageURL}" alt="">
		</div>
		<div class="content">
			<h4>${product.name}</h4>
			<h4>${product.description}</h4>
			<div class="amount">
				<h4>${product.price} ₴</h4>
				<form action="./cart" method = "post">
					<input type="hidden" name="id" value = "${product.id}">
					<input type="hidden" name="value" value = "1">
					<button type="submit"class="fa-solid fa-cart-plus" ></button>
				</form>
			</div>
		</div>
	</div>
</c:forEach>

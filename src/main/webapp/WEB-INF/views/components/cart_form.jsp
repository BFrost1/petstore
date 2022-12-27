<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<div class="cart-form">
	<h3>Ваше замолення</h3>
	<div class="items-cart">
		<c:forEach var="cart" items="${cart}">
			<div class="box-cart" id="${cart.key.id}">
				<div class="image">
					<img
						src="./static/images/products/${cart.key.category.url}/${cart.key.imageURL}"
						alt="">
				</div>
				<h3>${cart.key.name}</h3>
				<span>${cart.key.price} ₴</span>
				<button class="delet-items">x</button>
			</div>
		</c:forEach>
	</div>
	<a href="./cart" class="btn">Замовити</a>
</div>
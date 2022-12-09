<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="/WEB-INF/views/components/header.jsp"%>
	<main>
	<h1 class="heading">
		Оформлення <span>замовлення</span>
	</h1>
	<div class = "cart">
	    <div class="shopping-cart">
	      <div class="title">
	        <h3>Твій кошик</h3> 
		   </div>
		   	<c:forEach var="cart" items="${cart}">
		        <div class="item" id="${cart.key.id}">
		          <div class="buttons">
		            <i class="fa-solid fa-xmark"></i>
		          </div>
		          <div class="image">
		            <img src="./static/images/products/${cart.key.category.url}/${cart.key.imageURL}" alt="" />
		          </div>
		          <div class="description">
		            <span>${cart.key.name}</span>
		            <span>${cart.key.description}</span>
		          </div>
		          <div class="quantity">
		            <button class="minus-btn" type="button" name="button">
		              <i class="fa-solid fa-minus"></i>
		            </button>
		            <input type="text" name="name" value="${cart.value}" readonly>
		            <button class="plus-btn" type="button" name="button">
		              <i class="fa-solid fa-plus"></i>
		            </button>
		          </div>
		          <div class="price">${cart.key.price} ₴</div>
		          <div class="item-total">549 ₴</div>
		        </div>
		      </c:forEach>
	        <div class = "total-order">
	          <div>
	            <span>Всього:</span>
	            <span id="total"></span>
	          </div>
	        </div>
	      </div>
	      <form action="" method="post" class="delivery-form" id ="delivery-form">
		        <h3>Замовник</h3>
		        <input type="text" name="firstName" placeholder="введіт ім'я" class="box" required>
		        <input type="text" name="lastName" placeholder="введіт прізвище" class="box" required>
		        <input type="email" name="email" placeholder="введіть електронну пошту" class="box"  required>
		        <input type="tel" name="phone" placeholder="введіть телефон +380(__)___-__-__" class="box" required>
		       	<h3>Адреса доставки</h3>
		        <select name = "city" class="box">
		          <option value = "Kyiv">Київ</option>
		          <option value = "Lviv">Львів</option>
		          <option value = "Odesa">Одеса</option>
		          <option value = "Kharkiv">Харків</option>
		          <option value = "Dnipro">Дніпро</option>
		          <option value = "Zaporizhzhia">Запоріжжя</option>
		          <option value = "Kryvyi Rih">Кривий Ріг</option>
		          <option value = "Mykolayiv">Миколаїв</option>
		          <option value = "Vinnytsia">Вінниця</option>
		          <option value = "Kherson">Херсон</option>
		        </select>
		        <input type="text" name="street" placeholder="введіт вулицю" class="box" required>
		        <input type="number" name="house" min="0" placeholder="введіт номер будинку" class="box" required>
		        <input type="number" name="flat" min="0" placeholder="введіт номер квартири" class="box" required>
		        <label> Коли зручно: </label>
		        <input type="date" name="deliveryDate" min="0" placeholder="введіт номер квартири" class="delivery-date" required>
		        <input type="submit" value="Оформити замовлення" class = "btn">
	    	</form>
      </div>
    </main>
<%@include file="/WEB-INF/views/components/footer.jsp"%>
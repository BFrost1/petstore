<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
		<form action="" method="post" class="reg-form active" id ="reg-form">
			<h3>Реєстрація</h3>
			<input type="text" name="firstName" placeholder="введіт ім'я" class="box" required>
			<label class ="errors" id="firstNameError"></label>
			<input type="text" name="lastName" placeholder="введіт прізвище" class="box" required>
			<label class ="errors" id="lastNameError"></label>
			<input type="email" name="email" placeholder="введіть електронну пошту" class="box" pattern="^((([0-9A-Za-z]{1}[-0-9A-z\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\.){1,2}[-A-Za-z]{2,})$" required>
			<label class ="errors" id="emailRegError"></label>
			<label class ="errors" id="emailCheckError"> </label>
			<input type="password" name="password" placeholder="введіт пароль (3 великі літери та цифри)" class="box" pattern="^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$" required>
			<label class ="errors" id="passwordError"></label>
			<input type="password" name="rePassword" placeholder="введіть повтроно пароль" class="box" pattern="^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$" required>
			<label class ="errors" id="rePasswordError"></label>
			<input type="tel" name="phone" placeholder="введіть телефон +380(__)___-__-__" class="box" required>
			<label class ="errors" id="phoneError"></label>
			<div class="checkbox">
				<input type="checkbox" name="agreement" required>
				<label>я погоджуюсь на обробку персональних даних</label>
			</div>
			<label class ="errors" id="agreementError"></label>
			<input type="submit" value="зареєструватися" class = "btn">
			<div class="links">
				<div id="auth">Увійти</div>
			</div>
		</form>
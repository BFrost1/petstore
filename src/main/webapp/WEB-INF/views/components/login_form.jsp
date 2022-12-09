<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
		<form action="" method="post" class="login-form" id = "login-form">
			<h3>Увійти</h3>
			<input type="email" name="email" placeholder="введіть електронну пошту" class="box" required>
			<input type="password" name="password" placeholder="введіть пароль" class="box" required>
			<label class ="errors" id="emailCheckError"></label>
			<input type="submit" value="Увійти" class = "btn">
			<div class="links">
				<div>забули пароль</div>
				<div id = "reg">зареєструватися</div>
			</div>
		</form>
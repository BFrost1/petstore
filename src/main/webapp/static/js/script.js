let regForm = '<form action=\"\" method=\"post\" class=\"reg-form active\" id =\"reg-form\">\n\t\t\t<h3>Реєстрація</h3>\n\t\t\t<input type=\"text\" name=\"firstName\" placeholder=\"введіт ім\'я\" class=\"box\" required>\n\t\t\t<label class =\"errors\" id=\"firstNameError\"></label>\n\t\t\t<input type=\"text\" name=\"lastName\" placeholder=\"введіт прізвище\" class=\"box\" required>\n\t\t\t<label class =\"errors\" id=\"lastNameError\"></label>\n\t\t\t<input type=\"email\" name=\"email\" placeholder=\"введіт електронна пошта\" class=\"box\" pattern=\"^((([0-9A-Za-z]{1}[-0-9A-z\\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\\.){1,2}[-A-Za-z]{2,})$\" required>\n\t\t\t<label class =\"errors\" id=\"emailRegError\"></label>\n\t\t\t<label class =\"errors\" id=\"emailCheckError\"> </label>\n\t\t\t<input type=\"password\" name=\"password\" placeholder=\"введіт пароль (3 великі літери та цифри)\" class=\"box\" pattern=\"^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$\" required>\n\t\t\t<label class =\"errors\" id=\"passwordError\"></label>\n\t\t\t<input type=\"password\" name=\"rePassword\" placeholder=\"введіть повтроно пароль\" class=\"box\" pattern=\"^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$\" required>\n\t\t\t<label class =\"errors\" id=\"rePasswordError\"></label>\n\t\t\t<input type=\"tel\" name=\"phone\" placeholder=\"введіть телефон +380(__)___-__-__\" class=\"box\" required>\n\t\t\t<label class =\"errors\" id=\"phoneError\"></label>\n\t\t\t<div class=\"checkbox\">\n\t\t\t\t<input type=\"checkbox\" name=\"agreement\" required>\n\t\t\t\t<label>я погоджуюсь на обробку персональних даних</label>\n\t\t\t</div>\n\t\t\t<label class =\"errors\" id=\"agreementError\"></label>\n\t\t\t<input type=\"submit\" value=\"зареєструватися\" class = \"btn\">\n\t\t\t<div class=\"links\">\n\t\t\t\t<div id=\"auth\">Увійти</div>\n\t\t\t</div>\n\t\t</form>';
let loginForms = '<form action=\"\" method=\"post\" class=\"login-form\" id = \"login-form\">\n\t\t\t<h3>Увійти</h3>\n\t\t\t<input type=\"email\" name=\"email\" placeholder=\"введіть електронну пошту\" class=\"box\" required>\n\t\t\t<label class =\"errors\" id=\"emailCheckError\"></label>\n\t\t\t<input type=\"password\" name=\"password\" placeholder=\"введіть пароль\" class=\"box\" required>\n\t\t\t<label class =\"errors\" id=\"emailCheckError\"></label>\n\t\t\t<input type=\"submit\" value=\"Увійти\" class = \"btn\">\n\t\t\t<div class=\"links\">\n\t\t\t\t<div>забули пароль</div>\n\t\t\t\t<div id = \"reg\">зареєструватися</div>\n\t\t\t</div>\n\t\t</form>';

let iconsUser = "<div id='account'><a  href='./account' class='fa-solid fa-user-check'></a><div class='fa-solid fa-right-from-bracket' id ='logout'></div></div>";
let useForm = $('header #login-form');
let cartForm = $('header .cart-form');
let user = $('.header .icons');


$(document).on("click", '#login-btn', function() {
	if (useForm.hasClass('active')) {
		useForm.removeClass('active');
	} else {
		useForm.addClass('active');
		cartForm.removeClass('active');
	}
});

$(document).on("click", "#reg", function() {
	$("#login-form").remove();
	$("header").append(regForm);
	useForm = $('header #reg-form');
});

$(document).on("click", "#auth", function() {
	$("#reg-form").remove();
	$("header").append(loginForms);
	useForm = $('header #login-form');
	useForm.addClass('active');
});


$(document).on("click", "#cart-btn", function() {
	if ($('header .cart-form').hasClass('active')) {
		cartForm.removeClass('active');
	} else {
		useForm.removeClass('active');
		cartForm.addClass('active');
	}
});

$(document).on("click", '.delet-items', function() {
	$(this).parent().remove();
});



$(document).on("submit", "#login-form", function(e) {
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "./authorization",
		data: $(this).serialize(),
		dataType: 'json',
		success: function(data) {
			if($.isEmptyObject(data)){
				$('header #login-form').remove();
				$(".fa-user").remove();
				user.append(iconsUser);
			}else{
				$.each(data, function(key, val) {
					$(key).text(val);
				});
			}
		}
	});
});

$(document).on("submit", "#reg-form", function(e) {
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "./registration",
		data: $(this).serialize(),
		dataType: 'json',
		success: function(data) {
			if($.isEmptyObject(data)){
				$("#reg-form").remove();
				$("header").append(loginForms);
				$('header #login-form').addClass('active');
				useForm = $('.header #login');
			}else{
				$.each(data, function(key, val) {
					$(key).text(val);
				});
			}
		}
	});
});

$(document).on("click", '#logout', function() {
	$.ajax({
		type: "GET",
		url: "./authorization",
		data: {"logout": "logout"},
		success: function(data) {
			location.reload();
		}
	});
});



$(document).ready(function() {
 sumItem();
});

 $('.minus-btn').on('click', function(e) {
  e.preventDefault();
  var $this = $(this);
  var $input = $this.closest('div').find('input');
  var value = parseInt($input.val());

  if (value > 1) {
    value = value - 1;
  } else {
    value = 1;
  }

  $input.val(value);
  sum($this.closest('.item'), value);
});

$('.plus-btn').on('click', function(e) {
  e.preventDefault();
  var $this = $(this);
  var $input = $this.closest('div').find('input');
  var value = parseInt($input.val());

  if (value < 100) {
    value = value + 1;
  } else {
    value = 100;
  }
  $input.val(value);
  sum($this.closest('.item'), value);
});

$('.like-btn').on('click', function() {
  $(this).toggleClass('is-active');
});

$('.buttons').on('click', function() {
  $(this).closest('.item').remove();
  sumTotal();
});

function sum($item, value){
    var $price = $item.find('.price');
    var $total = $item.find('.item-total');
    $total.text(parseInt($price.text()) * value + ' ₴');
    sumTotal();
}

function sumTotal(){
    var items = $('.item');
    var elemsTotal = items.length;
    var sum = 0;

    for(var i=0; i < elemsTotal; ++i){
      sum = sum + parseInt($(items[i]).find('.item-total').text());
    }
    $('#total').text(sum + ' ₴');
}


function sumItem(){
    var items = $('.item');
    var elemsTotal = items.length;

    for(var i=0; i < elemsTotal; ++i){		
		$(items[i]).find('.item-total').text(parseInt($(items[i]).find('input').val()) * parseInt($(items[i]).find('.price').text()));
    }
    sumTotal();
}





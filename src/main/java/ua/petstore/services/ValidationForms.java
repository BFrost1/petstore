package ua.petstore.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import ua.petstore.dao.UserDAO;
import ua.petstore.model.User;

public class ValidationForms {
	public static final String REG_EMAIL = "^((([0-9A-Za-z]{1}[-0-9A-z\\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\\.){1,2}[-A-Za-z]{2,})$";
	public static final String REG_PASSWORD = "^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$";

	public static Map<String, String> isFormValidReg(User user, String rePassword, UserDAO userManager) {
		Map<String, String> errors = new HashMap<String, String>();
		
		if (isNoValidText(user.getFirstName())) {
			errors.put("#firstNameError", "поле не заповнене");
		}
		if (isNoValidText(user.getLastName())) {
			errors.put("#lastNameError", "поле не заповнене");
		}
		if (isNoValidText(user.getEmail(), REG_EMAIL)) {
			errors.put("#emailRegError", "поле не відповідає формату");
		}
		if(Objects.nonNull(userManager.getUserByLogin(user.getEmail()))) {
			errors.put("#emailCheckError", "такий email існує");
		}
		if (isNoValidText(user.getPassword(), REG_PASSWORD)) {
			errors.put("#passwordError", "поле не відповідає фармату");
		}
		if (!Objects.equals(user.getPassword(), rePassword)) {
			errors.put("#rePasswordError", "паролі не співпадають");
		}
		if (isNoValidText(user.getPhone())) {
			errors.put("#phoneError", "поле не відповідає фармату");
		}
		if (!user.isAgreement()) {
			errors.put("#agreementError", "поле не відповідає фармату");;
		}
		return errors;
	}
	
	public static boolean isNoValidText(String text, String reg) {
		boolean check = false;
		if (Objects.isNull(text) || !text.matches(reg)) {
			check = true;
		}
		return check;
	}

	public static boolean isNoValidText(String text) {
		boolean check = false;
		if (Objects.isNull(text) || text.isEmpty()) {
			check = true;
		}
		return check;
	}	
}

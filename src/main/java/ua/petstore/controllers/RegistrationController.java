package ua.petstore.controllers;

import ua.petstore.dao.UserDAO;
import ua.petstore.model.User;
import ua.petstore.services.ValidationForms;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserDAO userManager;

	@PostMapping
	@ResponseBody
	public String addUser(@ModelAttribute User user, @RequestParam String rePassword) {
		Map<String, String> errors = ValidationForms.isFormValidReg(user, rePassword, userManager);
		if (errors.isEmpty()) {
			userManager.addUser(user);
		}
		return new Gson().toJson(errors);
	}
}

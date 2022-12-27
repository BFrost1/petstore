package ua.petstore.controllers;

import ua.petstore.dao.UserDAO;
import ua.petstore.model.User;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {
	
	@Autowired
	private UserDAO userManager;

	@PostMapping
	@ResponseBody
	public String getLogin(HttpSession session, @RequestParam String email, @RequestParam String password) {
		User user = userManager.getUserByLoginPassword(email, password);
		HttpStatus status = HttpStatus.OK;
		if (Objects.nonNull(user)) {
			session.setAttribute("user", user);
		} else {
			status = HttpStatus.NOT_FOUND;
		}
		return status.getReasonPhrase();
	}

	@DeleteMapping
	@ResponseBody
	public String getLogout(HttpSession session) {
		session.setAttribute("user", null);
		return HttpStatus.OK.getReasonPhrase();
	}
}

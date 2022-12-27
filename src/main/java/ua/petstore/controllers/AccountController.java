package ua.petstore.controllers;

import ua.petstore.services.ViewURL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController{
    
	@GetMapping
	public String getAccount() {
		return ViewURL.URL_ACCOUNT_PAGE;
	}
}

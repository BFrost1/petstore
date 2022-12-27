package ua.petstore.controllers;

import ua.petstore.services.ViewURL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController{

	@GetMapping
	public String getHome() {
		return ViewURL.URL_HOME_PAGE;
	}
}

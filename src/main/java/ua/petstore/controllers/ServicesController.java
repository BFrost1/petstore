package ua.petstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.petstore.services.ViewURL;

@Controller
@RequestMapping("/services")
public class ServicesController {

	@GetMapping
	public String getServices() {
		return ViewURL.URL_SERVICES_PAGE;
	}
}

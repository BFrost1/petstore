package ua.petstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.petstore.services.ViewURL;

@Controller
@RequestMapping("/contacts")
public class ContactsController{
	
	@GetMapping
	public String getContacts() {
		return ViewURL.URL_CONTACTS_PAGE;
	}
}

package ua.petstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.petstore.services.ViewURL;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@GetMapping
	public String getHotel() {
		return ViewURL.URL_HOTEL_PAGE;
	}
}

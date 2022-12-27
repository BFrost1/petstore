package ua.petstore.controllers;

import ua.petstore.services.ViewURL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@GetMapping
	public String getShop(ModelMap modelMap) {
		return ViewURL.URL_SHOP_PAGE;
	}	
}

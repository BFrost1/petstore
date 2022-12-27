package ua.petstore.controllers;

import jakarta.servlet.http.HttpSession;
import ua.petstore.dao.ProductDAO;
import ua.petstore.model.Product;
import ua.petstore.services.ViewURL;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ProductDAO productManager;

	@GetMapping
	public String getCartPage() {
		return ViewURL.URL_CART_PAGE;
	}

	@PostMapping(produces = "text/html; charset=utf-8")
	@ResponseBody()
	public String addProduct(HttpSession session, @RequestParam String id) {
		Map<Product, Integer> cart = getCart(session);
		Product product = productManager.getProductById(Integer.parseInt(id));
		if (!cart.containsKey(product) && Objects.nonNull(product)) {
			cart.put(product, 1);
		}
		session.setAttribute(ViewURL.URL_CART, cart);
		return new Gson().toJson(cart.keySet());
	}

	@PostMapping(value = "/delete", produces = "text/html; charset=utf-8")
	@ResponseBody()
	public String deleteProduct(HttpSession session, @RequestParam String id) {
		Map<Product, Integer> cart = getCart(session);
		Product product = productManager.getProductById(Integer.parseInt(id));
		if (Objects.nonNull(product)) {
			cart.remove(product);
		}
		session.setAttribute(ViewURL.URL_CART, cart);
		return HttpStatus.OK.getReasonPhrase();
	}
	
	@PostMapping(value = "/count", produces = "text/html; charset=utf-8")
	@ResponseBody()
	public String addCount(HttpSession session, @RequestParam String id, @RequestParam String count) {
		Map<Product, Integer> cart = getCart(session);
		for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
			if(entry.getKey().getId() == Integer.parseInt(id)) {
				entry.setValue(Integer.valueOf(count));		
			}
		}
		session.setAttribute(ViewURL.URL_CART, cart);
		return HttpStatus.OK.getReasonPhrase();
	}

	private Map<Product, Integer> getCart(HttpSession session) {
		if (Objects.isNull(session.getAttribute(ViewURL.URL_CART))) {
			session.setAttribute(ViewURL.URL_CART, new HashMap<Product, Integer>());
		}
		return (Map<Product, Integer>) session.getAttribute(ViewURL.URL_CART);
	}
}

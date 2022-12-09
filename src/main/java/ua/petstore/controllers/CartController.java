package ua.petstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.petstore.model.Product;
import ua.petstore.services.ViewURL;
import ua.petstore.services.database.DBWorker;
import ua.petstore.services.database.ProductManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartController extends HttpServlet {

	private static final long serialVersionUID = -7232317147604569834L;
	private ProductManager productManager;
	
	@Override
	public void init() throws ServletException {
		productManager = new ProductManager(new DBWorker());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(ViewURL.URL_CART).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		if(Objects.isNull(sesion.getAttribute(ViewURL.CART))) {
			sesion.setAttribute(ViewURL.CART, new HashMap<Product, Integer>());
		}
		
		Map<Product, Integer> cart = (Map<Product, Integer>) sesion.getAttribute(ViewURL.CART);
		Product product = productManager.getProductById(request.getParameter("id"));
		
		if(cart.containsKey(product)) {
			cart.put(product, cart.get(product) + 1);
		}else {
			cart.put(product, 1);
		}
		sesion.setAttribute(ViewURL.CART, cart);
		response.sendRedirect(request.getHeader("Referer"));
	}

}

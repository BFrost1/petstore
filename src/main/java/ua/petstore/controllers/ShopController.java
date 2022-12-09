package ua.petstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.petstore.services.ViewURL;
import ua.petstore.services.database.CaterogyManager;
import ua.petstore.services.database.DBWorker;
import ua.petstore.services.database.ProductManager;

import java.io.IOException;
import java.util.Objects;

public class ShopController extends HttpServlet {

	private static final long serialVersionUID = -8642734428818554191L;
	private ProductManager productManager;
	private CaterogyManager caterogyManager;
	
	@Override
	public void init() throws jakarta.servlet.ServletException {
		DBWorker dbWorker = new DBWorker();
		productManager = new ProductManager(dbWorker);
		caterogyManager = new CaterogyManager(dbWorker);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", productManager.getAllProduct(Objects.isNull(request.getParameter("category")) ? "4": request.getParameter("category")));
		request.setAttribute("categories", caterogyManager.getAllCategory());
		request.getRequestDispatcher(ViewURL.URL_SHOP).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

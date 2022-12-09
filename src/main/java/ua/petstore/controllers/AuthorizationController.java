package ua.petstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.petstore.model.User;
import ua.petstore.services.ValidationForms;
import ua.petstore.services.database.DBWorker;
import ua.petstore.services.database.UserManager;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import com.google.gson.Gson;

public class AuthorizationController extends HttpServlet {

	private static final long serialVersionUID = -4867597385047375698L;

	private UserManager userManager;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		this.userManager = new UserManager(new DBWorker());
		this.gson = new Gson();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Objects.nonNull(request.getParameter("logout"))) {
			request.getSession().invalidate();
			request.getSession(true);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = ValidationForms.isValidFormLogin(request);
		if(errors.isEmpty()) {
			User user = userManager.getUser(request.getParameter("email"), request.getParameter("password"));
			if(Objects.nonNull(user)) {
				request.getSession().setAttribute("user", user);
			}else {
				errors.put("#emailCheckError", "Невірний пароль або логін");
			}
		}
		response.getWriter().write(gson.toJson(errors));
	}
}

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

import com.google.gson.Gson;

public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = -5258981648168239888L;
	
	private UserManager userManager;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		this.userManager = new UserManager(new DBWorker());
		this.gson = new Gson();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = ValidationForms.isFormValidReg(request, userManager);
		if (errors.isEmpty()) {
			userManager.addUser(new User().setFirstName(request.getParameter("firstName")).setLastName(request.getParameter("lastName"))
					.setEmail(request.getParameter("email")).setPassword(request.getParameter("password"))
					.setPhone(request.getParameter("phone")).setAgreement(Boolean.valueOf(request.getParameter("agreement"))));
		}
		response.getWriter().write(gson.toJson(errors));
	}
}

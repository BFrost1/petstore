package ua.petstore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.petstore.services.ViewURL;

import java.io.IOException;
import java.util.Objects;


public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Objects.nonNull(request.getSession().getAttribute("user"))) {
			request.getRequestDispatcher(ViewURL.URL_ACCOUNT).forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

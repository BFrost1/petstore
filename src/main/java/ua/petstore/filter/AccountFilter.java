package ua.petstore.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

public class AccountFilter extends HttpFilter {

	private static final long serialVersionUID = 6724214244981732734L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (Objects.isNull(((HttpServletRequest) request).getSession().getAttribute("user"))) {
			((HttpServletResponse) response).sendRedirect("./");
		}else {
			chain.doFilter(request, response);
		}
	}
}

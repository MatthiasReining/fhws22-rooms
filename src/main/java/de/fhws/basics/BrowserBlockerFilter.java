package de.fhws.basics;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" })
public class BrowserBlockerFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("before chain call");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String userAgent = httpRequest.getHeader("User-Agent");
		
		if (userAgent != null && userAgent.toLowerCase().contains("edg")) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.getWriter().println("Nutz lieber Firefox...");
			httpResponse.setStatus(418);
			System.out.println("chain interrupted");
			return;
			
		}

		chain.doFilter(request, response);
		System.out.println("after chain call");
	}

}

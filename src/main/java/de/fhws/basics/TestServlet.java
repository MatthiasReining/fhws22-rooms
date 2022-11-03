package de.fhws.basics;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// bad idea -> shared variable between requests
	private String myData = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String query = request.getQueryString();

		myData = query; // <- don't do this

		if (query.contains("json")) {
			response.setContentType("application/json");
			response.getWriter().append("{ \"uni\": \"fhws\" }");
			return;
		}

		if (query.contains("xml")) {
			response.setContentType("application/xml");
			response.getWriter().append("<uni>fhws</uni>");
			return;
		}

		if (query.contains("redirect")) {
			response.sendRedirect("https://www.fhws.de");
			return;
		}

		response.setStatus(400);

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		System.out.println("init is called");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("my data" + myData);
		resp.getWriter().append("<h1>This is post</h1>");
	}

}

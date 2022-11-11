package de.fhws.basics.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = request.getQueryString();
		if (data.contains("data")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("mydata", data);

			response.getWriter().append("Session: " + session.getId());
			return;
		}

		HttpSession session = request.getSession(true);
		data = (String) session.getAttribute("mydata");

		response.getWriter().append("Session: " + session.getId() + "\n" + session.getId() + "\ndata: " + data);
		System.out.println(data);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init is called");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String myData = req.getQueryString();
		HttpSession session = req.getSession(true);
		session.setAttribute("mydata", myData);

		resp.getWriter().append("Session: " + session.getId());
	}

}

package se.ltu.M7017E.lab3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageListServlet extends HttpServlet {

	private static final long serialVersionUID = 7644831738545260865L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// indicate how you translate the data
		response.setContentType("text/html");
		// following lines not used if there is an error
		response.setStatus(HttpServletResponse.SC_OK);
		// construct the html page
		response.getWriter().println("<h1>Message List</h1>");
		response.getWriter().println("<a href=\"message?username=flore\">Flore</a><br/>");
		response.getWriter().println("<a href=\"message?username=dudule\">Dudule</a><br/>");
	}
}
package se.ltu.M7017E.lab3;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageServlet extends HttpServlet {
	private String username;

	// get the file content
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// indicate how you translate the data
		response.setContentType("text/html");
		// following lines not used if there is an error
		response.setStatus(HttpServletResponse.SC_OK);
		// construct the html page
		response.getWriter().println("<h1>Message List</h1>");
		username = request.getParameter("username");
		response.getWriter().println("Hello " + username);

		File directory = new File("files/" + username);
		System.out.println(directory.getAbsolutePath());
	}
}

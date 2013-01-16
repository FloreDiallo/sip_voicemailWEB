package se.ltu.M7017E.lab3;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteMessageServlet extends HttpServlet {

	private static final long serialVersionUID = -2341191464512945171L;

	/**
	 * Delete a message from the server
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("name"); // name of the file
		String fromFolder = request.getParameter("from"); // folder where stored
		String username = request.getParameter("username"); // user's name

		response.setStatus(HttpServletResponse.SC_OK);

		File toDelete = new File(fromFolder + message);
		toDelete.delete(); // the file

		response.setContentType("text/html");
		response.getWriter()
				.println(
						"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">"
								+ "<html><head>"
								+ "<head>"
								+ "<META http-equiv=Content-Type content=\"text/html; charset=UTF-8\">"
								+ "<link rel=\"stylesheet\" href=\"layout.css\" />"
								+ "</head><body><div id=\"sub\">");
		// Inform the user
		response.getWriter().println("<h1>Message Deleted</h1>");
		response.getWriter().println(
				"<h3>The file \" " + message
						+ " \" has been deleted from the server</h3><br />");
		response.getWriter()
				.println(
						"<br /><a href=\"/LoginServlet?username="
								+ username
								+ "\"><input type=\"button\" value=\"Back\"></a></div></body></html>");

	}
}

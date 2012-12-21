package se.ltu.M7017E.lab3;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = -1555000962871473755L;
	private String me = new String("flore");

	// get the file content
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = new String();
		// indicate how you translate the data
		response.setContentType("text/html");
		// following lines not used if there is an error
		response.setStatus(HttpServletResponse.SC_OK);
		// construct the html page
		response.getWriter().println("<h1>Message List</h1>");
		username = request.getParameter("username");
		response.getWriter().println("You are " + me + "<br /><br />");
		// TODO :not use the /tmp/sip-voicemail, but the files
		File directory = new File("/tmp/sip-voicemail/" + username);

		// TODO : mettre en forme le message / Message de ... le ...
		if (directory.exists() && (username.equals(me))) {
			File[] messageList = directory.listFiles();
			response.getWriter().println("<br /><h3>");
			for (File message : messageList) {
				response.getWriter().println(
						"<a href=\"/getmessage?name=" + message.getName()
								+ "\">" + message.getName() + "</a><br />");
			}
			response.getWriter().println("</h3>");
		} else {
			response.getWriter().println(
					"<br /><h3>No access to this file</h3>");
		}
		response.getWriter()
				.println("<br /><a href=\"/message_list\">Back</a>");
	}
}

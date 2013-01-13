package se.ltu.M7017E.lab3;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageListServlet extends HttpServlet {

	private static final long serialVersionUID = 7644831738545260865L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// following lines not used if there is an error
		response.setStatus(HttpServletResponse.SC_OK);

		response.getWriter().println("<h1>Message List</h1>");

		// TODO :not use the /tmp/sip-voicemail, but the files
		File directory = new File("/tmp/sip-voicemail/");
		File[] listFolder = directory.listFiles();
		String name = new String();
		for (File folder : listFolder) {
			// get the list of the users with recorded messages
			if (folder.isDirectory()) {
				name = folder.getName();
				response.getWriter().println(
						"<a href=\"message?username=" + name + "\">" + name
								+ "</a><br/>");
			}
		}
	}
}

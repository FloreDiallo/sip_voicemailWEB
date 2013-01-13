package se.ltu.M7017E.lab3;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3352555589253401049L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = new String();
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>Message List (Login)</h1>");
		username = request.getParameter("username");
		response.getWriter().println(
				"<h3>Identied as " + username + "</h3><br /><br />");
		// TODO :not use the /tmp/sip-voicemail, but the files
		File directory = new File("/tmp/sip-voicemail/" + username);
		String originDir = new String("/tmp/sip-voicemail/" + username + "/");
		request.setAttribute("originDir", originDir);

		if (directory.exists() && (username.equals("flore"))) { // TODO
			File[] messageList = directory.listFiles();
			response.getWriter().println("<br /><h3>");
			String displayedName = new String();
			for (File message : messageList) {
				displayedName = MessageNameFormat(message.getName());
				response.getWriter().println(displayedName + "<br />");
				displayButton(response, message, originDir);
			}
			response.getWriter().println("</h3>");
		} else {
			response.getWriter().println(
					"<br /><h3>No access to this file</h3>");
		}
		response.getWriter().println("<br /><a href=\"/\">Back</a>");

	}

	private String MessageNameFormat(String name) {
		String formatedName = new String();
		String split[] = name.split("-", 0);

		formatedName = "Message de " + split[0] + " le " + split[3] + " "
				+ split[2] + " " + split[1];
		return formatedName;
	}

	private void displayButton(HttpServletResponse response, File message,
			String originDir) throws IOException {
		response.getWriter().print(
				"<a href =\"/readmessage?name=" + message.getName()
						+ "\"><input type=\"button\" value=\"Listen\"></a> ");
		response.getWriter().print(
				"<a href =\"/getparam?name=" + message.getName() + "&from="
						+ originDir
						+ "\"><input type=\"button\" value=\"Save\"></a> ");
		response.getWriter()
				.print("<a href =\"/deletemessage?name="
						+ message.getName()
						+ "\"><input type=\"button\" value=\"Delete\"></a><br /><br />");
	}
}

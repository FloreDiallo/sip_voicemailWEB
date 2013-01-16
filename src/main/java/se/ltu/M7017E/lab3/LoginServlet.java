package se.ltu.M7017E.lab3;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3352555589253401049L;
	private FilesSetting settings = new FilesSetting();

	/**
	 * Display the page with all the message of the identified user.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		// HTML header
		response.getWriter()
				.println(
						"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">"
								+ "<html><head>"
								+ "<head>"
								+ "<META http-equiv=Content-Type content=\"text/html; charset=UTF-8\">"
								+ "<link rel=\"stylesheet\" href=\"layout.css\" />"
								+ "</head><body><div id=\"sub\">");
		// Get the username to access the right folder
		String username = new String();
		username = request.getParameter("username");

		response.getWriter().println("<h1>Message List</h1>");
		response.getWriter().println("<h3>Hello " + username + "</h3><br />");
		File directory = new File(settings.getMainFolder() + username);
		String originDir = new String(settings.getMainFolder() + username + "/");

		if (directory.exists()) {
			// there is at least one message
			File[] messageList = directory.listFiles();
			response.getWriter().println("<h3>");
			String displayedName = new String();
			// display the files
			for (File message : messageList) {
				displayedName = MessageNameFormat(message.getName());
				response.getWriter().println(displayedName + "<br />");
				displayButton(response, message, originDir, username);
			}
			response.getWriter().println("</h3>");
		} else {
			// No message for this user
		}
		response.getWriter()
				.println(
						"<br /><a href=\"/\"><input type=\"button\" value=\"Back\"></a></div></body></html>");
	}

	/**
	 * Format the way to display the name of the message
	 * 
	 * @param name
	 *            Name of the message
	 * @return
	 */
	private String MessageNameFormat(String name) {
		String formatedName = new String();
		String split[] = name.split("-", 0);

		formatedName = "Date: " + split[2] + "/" + split[3] + "/" + split[1]
				+ "<br /> Message from " + split[0];
		return formatedName;
	}

	/**
	 * Display the buttons to Listen, Save or delete a File from the server. All
	 * the information needed are in the parameters.
	 * 
	 * @param response
	 * @param message
	 *            the file to work with
	 * @param originDir
	 *            the folder where the message is stored
	 * @param username
	 *            name of the user
	 * @throws IOException
	 */
	private void displayButton(HttpServletResponse response, File message,
			String originDir, String username) throws IOException {
		response.getWriter().print(
				"<a href =\"/readmessage?name=" + message.getName()
						+ "&username=" + username + "&from=" + originDir
						+ "\"><input type=\"button\" value=\"Listen\"></a> ");
		response.getWriter().print(
				"<a href =\"/storemessage?username=" + username + "&save="
						+ message.getName() + "&from=" + originDir
						+ "\"><input type=\"button\" value=\"Save\"></a> ");
		response.getWriter()
				.print("<a href =\"/deletemessage?name="
						+ message.getName()
						+ "&username="
						+ username
						+ "&from="
						+ originDir
						+ "\"><input type=\"button\" value=\"Delete\"></a><br /><br />");
	}
}

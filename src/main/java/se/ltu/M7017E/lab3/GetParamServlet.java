package se.ltu.M7017E.lab3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetParamServlet extends HttpServlet {

	private static final long serialVersionUID = -679094352495057213L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("name");
		String originDir = request.getParameter("from");
		String username = request.getParameter("username");

		request.setAttribute("filename", filename);
		request.setAttribute("originDir", originDir);
		request.setAttribute("username", username);
		getServletContext().getRequestDispatcher("/savemessage.jsp").forward(
				request, response);
	}
}

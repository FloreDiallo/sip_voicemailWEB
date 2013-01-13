package se.ltu.M7017E.lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveMessageServlet extends HttpServlet {

	private static final long serialVersionUID = -3046864297832401702L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String oldname = request.getParameter("save"); // old file
		String fromFolder = request.getParameter("from"); // old folder
		String newFolder = request.getParameter("to"); // new folder
		String newname = request.getParameter("new_name"); // new file

		FileInputStream fin = new FileInputStream(fromFolder + oldname);

		// make sure the file is an audio one
		if (!newname.endsWith(".ogg")) {
			newname.concat(".ogg");
		}
		// make sure the folder is really a folder
		if (!newFolder.endsWith("/")) {
			newFolder.concat("/");
		}
		File savePlace = new File(newFolder);
		// if the folder does not exist, create it
		if (!savePlace.exists()) {
			savePlace.mkdirs();
		}
		// final destination of the file
		FileOutputStream fout = new FileOutputStream(savePlace + "/" + newname);

		int readbyte;
		while ((readbyte = fin.read()) != -1) {
			fout.write(readbyte);
		}
		// close all files
		fin.close();
		fout.close();
		getServletContext().getRequestDispatcher("/savemessage.jsp").forward(
				request, response);
	}
}

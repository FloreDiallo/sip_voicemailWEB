package se.ltu.M7017E.lab3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveMessageServlet extends HttpServlet {

	private static final long serialVersionUID = -3046864297832401702L;

	/**
	 * Download the file Selected
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("save");
		String from = request.getParameter("from");
		// download
		response.setContentType("text/plain");
		response.setStatus(HttpServletResponse.SC_OK);

		BufferedInputStream bufin = null;
		ServletOutputStream fout = null;

		try {
			File toSave = new File(from + filename);
			FileInputStream fin = new FileInputStream(toSave);
			// define the output
			fout = response.getOutputStream();
			// tell which file to download
			response.addHeader("Content-Disposition", "attachment; filename="
					+ filename);
			response.setContentLength((int) toSave.length());

			bufin = new BufferedInputStream(fin);
			int readBytes = 0;
			while ((readBytes = bufin.read()) != -1)
				fout.write(readBytes);
		} catch (IOException e) {
			throw new ServletException(e.getMessage());
		} finally {
			if (fout != null) {
				fout.close();
			}
			if (bufin != null) {
				bufin.close();
			}
		}

	}
}
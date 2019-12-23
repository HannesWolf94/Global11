// erstellt von Johannes Wolf
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import beans.User;

@WebServlet("UserLoeschen")
public class UserLoeschen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		String email = request.getParameter("email");
		String emailRepeat = request.getParameter("emailRepeat");

		User user = new User();
		user.setEmail(email);

		boolean error = false;

		if (email == null || email == "" || emailRepeat == null || emailRepeat == "")
			error = true;
		else {

			// Stimmen neues Email und Emailbestätigung überein?
			if (!email.equals(emailRepeat))
				error = true;

		}

		if (error) {
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/fehlerseite.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (email.equals(emailRepeat))

			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement("DELETE FROM users WHERE email = ?;")) {
				pstmt.setString(1, email);
				pstmt.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("UserverwaltungAdmin");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

//erstellt von Michael Haid
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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;

@WebServlet("Password")
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup ="java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String newPassword = request.getParameter("newPassword");
		String passwordConfirmation = request.getParameter("passwordConfirmation");
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String password = user.getPassword();

		
		boolean error = false;
		
		
		if (newPassword == null || newPassword == "" || passwordConfirmation == null || passwordConfirmation == "" || password == "" || password == null)
			error = true;
		else {
		
			// Stimmen neues Passwort und Passwortbestätigung überein?
			if (!newPassword.equals(passwordConfirmation))
				error = true;
			
			// Neues und altes Passwort müssen unterschiedlich sein
			if (newPassword.equals(user.getPassword()))
				error = true;
			
		
		}
		
		
		if (error) {
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/fehlerseite.jsp");
			dispatcher.forward(request, response);
			return;
		}else if((password.equals(request.getParameter("oldPassword"))))
		
		
		try(Connection conn = ds.getConnection(); 
			PreparedStatement pstm = conn.prepareStatement("UPDATE users"
					+ " SET password = ?"
					+ "WHERE email = ?");){

			pstm.setString(1, newPassword);
			pstm.setString(2, user.getEmail());
			pstm.executeUpdate();
			conn.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/passwordAenderung.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}

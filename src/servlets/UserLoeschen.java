// Hannes
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

/**
 * Servlet implementation class Demo09Servlet
 */
@WebServlet("UserLoeschen")
public class UserLoeschen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		String email = request.getParameter("email");
		String emailRepeat = request.getParameter("emailRepeat");
		
		if ((passwordCheck(email, emailRepeat) == true)) {
			delete(email);

	        final RequestDispatcher dispatcher = request.getRequestDispatcher("UserverwaltungAdmin");
	        dispatcher.forward(request, response);
        } else {
//        	Fehlermeldung.jsp oder die Eingabefelder rot umranden wenn email nicht übereinstimmt 
        	final RequestDispatcher dispatcher = request.getRequestDispatcher("html/fehlerseite.jsp");
             dispatcher.forward(request, response);
        }
		
		
		

	}

	private void delete(String email) throws ServletException {
		User user = new User(); 
		user.setEmail(email); 
		
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM users WHERE email = ?;")) {
			pstmt.setString(1,email);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	
	protected boolean passwordCheck(String email, String emailRepeat) throws ServletException {
		if (email.equals(emailRepeat)) {
			return true;
		} else {
			return false;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

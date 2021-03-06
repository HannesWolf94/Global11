// erstellt von Johannes Wolf
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


@WebServlet("/UserAendern")
public class UserAendern extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;
	
	public UserAendern() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		User form = new User();
		form.setEmail(request.getParameter("email1"));
		form.setFirstName(request.getParameter("firstName"));
		form.setLastName(request.getParameter("lastName"));
		form.setStreet(request.getParameter("street"));
		form.setCity(request.getParameter("city"));
		
		aendern(form);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", form);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("UserverwaltungAdmin");
		dispatcher.forward(request, response);

	}

	private void aendern(User form) throws ServletException {
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("UPDATE users SET first_name = ?, last_name = ?, street = ?, city = ? WHERE email = ?")) {
			pstmt.setString(1, form.getFirstName());
			pstmt.setString(2, form.getLastName());
			pstmt.setString(3, form.getStreet());
			pstmt.setString(4, form.getCity());
			pstmt.setString(5, form.getEmail());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
}
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
@WebServlet("/UserAendern")
public class UserAendern extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;
	
	public UserAendern() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		User form = new User();
		form.setEmail(request.getParameter("email"));
		form.setFirstName(request.getParameter("firstName"));
		form.setLastName(request.getParameter("lastName"));
		form.setStreet(request.getParameter("street"));
		form.setCity(request.getParameter("city"));
		form.setUserAdmin(Integer.parseInt(request.getParameter("userAdmin")));
		
		aendern(form);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", form);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("UserverwaltungAdmin");
		dispatcher.forward(request, response);

	}

	private void aendern(User form) throws ServletException {
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("UPDATE users SET first_name = ?, last_name = ?, street = ?, city = ?, admin = ? WHERE email = ?")) {
			pstmt.setString(1, form.getFirstName());
			pstmt.setString(2, form.getLastName());
			pstmt.setString(3, form.getStreet());
			pstmt.setString(4, form.getCity());
			pstmt.setInt(5,  form.getUserAdmin());
			pstmt.setString(6, form.getEmail());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}



}


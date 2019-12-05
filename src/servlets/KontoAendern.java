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

@WebServlet("/KontoAendern")
public class KontoAendern extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// aus dem formular
		User user = (User) session.getAttribute("user");
		
		System.out.println("==davor");
		System.out.println(user.getEmail());
		
		user.setEmail(user.getEmail());
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setStreet(request.getParameter("street"));
		user.setCity(request.getParameter("city"));
		
		System.out.println("=a=");
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getStreet());
		System.out.println(user.getCity());
		System.out.println(user.getEmail());
		System.out.println("=e=");
				
		try (
			Connection conn = ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(
					"UPDATE users SET first_name = ?, last_name = ?, street = ?, city = ? WHERE email = ?")) {
			pstm.setString(1, user.getFirstName());
			pstm.setString(2, user.getLastName());
			pstm.setString(3, user.getStreet());
			pstm.setString(4, user.getCity());
			pstm.setString(5, user.getEmail());
			pstm.executeUpdate();
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}

		session.setAttribute("user", user);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/kontobereich.jsp");
		dispatcher.forward(request, response);
	}
	
	protected String dbCheck(String infoDaten, String dbDaten) {
		if (infoDaten != null && infoDaten.length() > 0) {
			return infoDaten;
		} else {
			return dbDaten;
		}
	}

}

// erstellt von Michael
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import beans.User;

@WebServlet("Kontobereich")
@MultipartConfig
public class Kontobereich extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// aus der session
		String firstnameDb = user.getFirstName();
		String lastnameDb = user.getLastName();
		String streetDb = user.getStreet();
		String cityDb = user.getCity();
		String emailDb = user.getEmail();
		
		
		// aus dem formular
		User benutzer = new User();
		benutzer.setEmail(request.getParameter("email"));
		String email = benutzer.getEmail();
		benutzer.setFirstName(request.getParameter("firstName"));
		String firstName = benutzer.getFirstName();
		benutzer.setLastName(request.getParameter("lastName"));
		String lastName = benutzer.getLastName();
		benutzer.setStreet(request.getParameter("street"));
		String street = benutzer.getStreet();
		benutzer.setCity(request.getParameter("city"));
		String city = benutzer.getCity();
		
		

		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(
					"UPDATE users" + " SET first_name = ?, last_name = ?, street = ?, city = ? " + "WHERE email = ?");

			pstm.setString(1, dbCheck(firstName, firstnameDb));
			pstm.setString(2, dbCheck(lastName, lastnameDb));
			pstm.setString(3, dbCheck(street, streetDb));
			pstm.setString(4, dbCheck(city, cityDb));
			pstm.setString(5, dbCheck(email, emailDb));
			pstm.executeUpdate();
			conn.close();
		}
		

		catch (SQLException ex) {
			ex.printStackTrace();
		}
		session.setAttribute("user", benutzer);
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
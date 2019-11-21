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
		String emailDb = user.getEmail();
		
		// aus dem formular
		User benutzer = new User();
		benutzer.setFirstName(request.getParameter("firstName"));
		String firstName = benutzer.getFirstName();
		benutzer.setLastName(request.getParameter("lastName"));
		String lastName = benutzer.getLastName();
		
		

		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(
					"UPDATE user" + " SET first_name = ?, last_name = ? " + "WHERE email = ?");

			pstm.setString(1, dbCheck(firstName, firstnameDb));
			pstm.setString(2, dbCheck(lastName, lastnameDb));
			pstm.executeUpdate();
			conn.close();
		}
		

		catch (SQLException ex) {
			ex.printStackTrace();
		}
		session.setAttribute("user", benutzer);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/welcomeuser.jsp");
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
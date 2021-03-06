// erstellt von Michael Haid
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

@WebServlet("AccountLoeschen")
public class AccountLoeschen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		HttpSession session = request.getSession();
		User user =  (User) session.getAttribute("user");
		String email = user.getEmail();
		User form = new User();
		form.setEmail(request.getParameter("email"));
		String benutzer = form.getEmail();

		// DB-Zugriff;
		if (email.equals(benutzer)) {
			delete(form);
		} else{
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/fehlerseite.jsp");
			dispatcher.forward(request, response);
			return;
		}
		session.invalidate();

		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registrierung.jsp");
		dispatcher.forward(request, response);

	}

	private void delete(User form) throws ServletException {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM users WHERE email = ?;")) {
			pstmt.setString(1, form.getEmail());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

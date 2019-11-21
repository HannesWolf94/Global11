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
 * Servlet implementation class Registrierung
 */
@WebServlet("/Registrierung")
public class Registrierung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="java:jboss/datasources/MySqlGlobal11DS")
    private DataSource ds; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrierung() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User form = new User();
		form.setEmail(request.getParameter("email"));
		form.setPassword(request.getParameter("password"));
		form.setPasswordRepeat(request.getParameter("passwordRepeat"));
		form.setFirstName(request.getParameter("firstname"));
		form.setLastName(request.getParameter("lastname"));
		form.setStreet(request.getParameter("street"));
		form.setCity(request.getParameter("city"));
//		response.sendRedirect("html/welcomeUser.jsp");
		
		if ((passwordCheck(form.getPassword(), form.getPasswordRepeat()) == true)) {
            speichern(form);
            
			HttpSession session = request.getSession();
			session.setAttribute("user", form);
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/welcomeUser.jsp");
			dispatcher.forward(request, response);
        } else {
        	 final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userverwaltung.jsp");
             dispatcher.forward(request, response);
        }

    }
	

	private void speichern(User form) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO users (email, password, first_name, last_name, street, city, admin) VALUES (?, ?, ?, ?, ?, ?, '0')")) {
			pstmt.setString(1, form.getEmail());
			pstmt.setString(2, form.getPassword());
			pstmt.setString(3, form.getFirstName());
			pstmt.setString(4, form.getLastName());
			pstmt.setString(5, form.getStreet());
			pstmt.setString(6, form.getCity());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	
	protected boolean passwordCheck(String password, String passwordRepeat) throws ServletException {
		if (password.equals(passwordRepeat)) {
			return true;
		} else {
			return false;
		}
	}

}

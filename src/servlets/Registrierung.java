//erstellt von Michael Haid 
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


@WebServlet("/Registrierung")
public class Registrierung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="java:jboss/datasources/MySqlGlobal11DS")
    private DataSource ds; 

	public Registrierung() {
		super();

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
		
		
		if(emailCheck(form.getEmail())) {
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registrierung.jsp");
            dispatcher.forward(request, response);
		
		} else {
			if ((passwordCheck(form.getPassword(), form.getPasswordRepeat()) == true)) {
	            speichern(form);
	            
				HttpSession session = request.getSession();
				session.setAttribute("user", form);
				final RequestDispatcher dispatcher = request.getRequestDispatcher("html/welcomeUser.jsp");
				dispatcher.forward(request, response);
	        } else {
	        	final RequestDispatcher dispatcher = request.getRequestDispatcher("html/index.jsp");
	            dispatcher.forward(request, response);
	        }
		}
	}
	

	private void speichern(User form) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO users (email, password, first_name, last_name, street, city) VALUES (?, ?, ?, ?, ?, ?)")) {
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
	
	protected boolean emailCheck(String email) throws ServletException {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email = ?")) {
			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		return false;
	}

}

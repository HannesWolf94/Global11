//erstellt von Martin Scherzer
package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;

@WebServlet("Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	public Login() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		
		if (emailCheck(email)) {	
			anmelden(request, response);
		}else {
        	final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registrierung.jsp");
            dispatcher.forward(request, response);
		}

	}

	protected void anmelden(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		if (passwortPruefen(user.getEmail(), user.getPassword()) == true) {
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE Email =? ")) {
				pstmt.setString(1, user.getEmail());
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs != null && rs.next()) {
						User form = new User();
						form.setUserId(Integer.parseInt(rs.getString("user_id")));
						form.setEmail(rs.getString("email"));
						
						form.setFirstName(rs.getString("first_name"));
						form.setLastName(rs.getString("last_name"));
						form.setStreet(rs.getString("street"));
						form.setCity(rs.getString("city"));
						form.setPassword(rs.getString("password"));
						request.setAttribute("form", form);
						HttpSession session = request.getSession();
						session.setAttribute("user", form);
						final RequestDispatcher dispatcher = request.getRequestDispatcher("html/welcomeUser.jsp");
						dispatcher.forward(request, response);
					}
				}
			} catch (Exception e) {
				throw new ServletException(e.getMessage());
			}
		} else {
        	final RequestDispatcher dispatcher = request.getRequestDispatcher("html/login.jsp");
            dispatcher.forward(request, response);
            
		}

	}

	private boolean passwortPruefen(String email, String password) throws ServletException {
		boolean status = false;
		boolean isOk;
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT password FROM users WHERE email = ?")) {
			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				isOk = rs.next();
				if (isOk == true) {
					String pw = rs.getString("password");
					if (password.equals(pw)) {
						status = true;
					}
				}
			} catch (Exception ex) {
				ex.getMessage();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return status;
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

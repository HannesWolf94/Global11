package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

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
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		anmelden(request, response);

		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("password");

	}

	protected void anmelden(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		PrintWriter out = response.getWriter();

		if (passwortPruefen(user.getEmail(), user.getPassword()) == true) {
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE Email =? ")) {
				pstmt.setString(1, user.getEmail());
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs != null && rs.next()) {
						User form = new User();
						String email = rs.getString("email");
						form.setEmail(email);
						String firstname = rs.getString("first_name");
						form.setFirstName(firstname);
						String lastname = rs.getString("last_name");
						form.setLastName(lastname);
						String password = rs.getString("password");
						form.setPassword(password);
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
			out.println("Wrong username or password");
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

}

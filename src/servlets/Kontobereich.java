// erstellt von Michael Haid
package servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM users WHERE email = ?");
			pstm.setString(1, user.getEmail());

			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {				
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setStreet(rs.getString("street"));
				user.setCity(rs.getString("city"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
			}

			con.close();
		} catch (Exception ex) {
		//	ex.getMessage();
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/login.jsp");
			dispatcher.forward(request, response);
			return;
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
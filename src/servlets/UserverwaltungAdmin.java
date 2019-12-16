package servlets;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;
import beans.User;

@WebServlet("UserverwaltungAdmin")
public class UserverwaltungAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserverwaltungAdmin() {
		super();
	}

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<User> userverwaltungAdminList = new ArrayList<>();
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM users");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				User form = new User();

				form.setUserId(rs.getInt("user_id"));
				form.setEmail(rs.getString("email"));
				form.setFirstName(rs.getString("first_name"));
				form.setLastName(rs.getString("last_name"));
				form.setStreet(rs.getString("street"));
				form.setCity(rs.getString("city"));
				userverwaltungAdminList.add(form);
			}

			request.setAttribute("userverwaltungAdminList", userverwaltungAdminList);
			con.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userverwaltung.jsp");
		dispatcher.forward(request, response);
	}

}

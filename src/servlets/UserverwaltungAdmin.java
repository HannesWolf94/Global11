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
import beans.UserInfoAdmin;

@WebServlet("UserverwaltungAdmin")
public class UserverwaltungAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserverwaltungAdmin() {
		super();
	}

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "SELECT * FROM users";

		ArrayList<UserInfoAdmin> userverwaltungAdminList = new ArrayList<>();
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			int userId;
			String userEmail;
			String userPassword;
			String userFirstName;
			String userLastName;
			String userStreet;
			String userCity;
			int userAdmin;

			while (rs.next()) {
				UserInfoAdmin form = new UserInfoAdmin();
				userId = rs.getInt("user_id");
				form.setUserId(userId);
				userEmail = rs.getString("email");
				form.setUserEmail(userEmail);
				userPassword = rs.getString("password");
				form.setUserPassword(userPassword);
				userFirstName = rs.getString("first_name");
				form.setUserFirstName(userFirstName);
				userLastName = rs.getString("last_name");
				form.setUserLastName(userLastName);
				userStreet = rs.getString("street");
				form.setUserStreet(userStreet);
				userCity = rs.getString("city");
				form.setUserCity(userCity);
				userAdmin = rs.getInt("admin");
				form.setUserAdmin(userAdmin);

				userverwaltungAdminList.add(form);
			}

			userverwaltungAdminList.stream().forEach(u -> System.out.println(u.getUserFirstName()));
			
			request.setAttribute("userverwaltungAdminList", userverwaltungAdminList);
			con.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userverwaltung.jsp");
		dispatcher.forward(request, response);
	}

}

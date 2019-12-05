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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "SELECT * FROM users";

		ArrayList<User> userverwaltungAdminList = new ArrayList<>();
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			int userId;
			String email;
			String firstName;
			String lastName;
			String street;
			String city;

			while (rs.next()) {
				User form = new User();
				userId = rs.getInt("user_id");
				form.setUserId(userId);
				email = rs.getString("email");
				form.setEmail(email);
				firstName = rs.getString("first_name");
				form.setFirstName(firstName);
				lastName = rs.getString("last_name");
				form.setLastName(lastName);
				street = rs.getString("street");
				form.setStreet(street);
				city = rs.getString("city");
				form.setCity(city);
				

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

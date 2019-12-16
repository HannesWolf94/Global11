package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.User;

@WebServlet("UserSuche")
public class UserSuche extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== in  get ");

		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		String lastName = request.getParameter("lastName2");
		List<User> users = search(lastName);
			
		request.setAttribute("users", users);

		users.forEach(e -> System.out.println(e.getFirstName()));
		response.setCharacterEncoding("UTF-8");
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/testen.jsp");
		dispatcher.forward(request, response);	
	}

	private List<User> search(String lastName) throws ServletException {
		lastName = (lastName == null || lastName == "") ? "%" : "%" + lastName + "%";
		List<User> users = new ArrayList<User>();
		
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE last_name LIKE ?")) {

			pstmt.setString(1, lastName);
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					User user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setEmail(rs.getString("email"));					
					user.setFirstName(rs.getString("first_name"));	
					user.setLastName(rs.getString("last_name"));
					user.setStreet(rs.getString("street"));
					user.setCity(rs.getString("city"));
					users.add(user);
				} // while rs.next()
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return users;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

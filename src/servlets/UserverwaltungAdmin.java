package servlets;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.UserInfoAdmin;


@WebServlet("UserverwaltungAdmin")
public class UserverwaltungAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<UserInfoAdmin>userverwaltungAdminList = readUserInfoAdmin();
 		
		HttpSession session = request.getSession();
        session.setAttribute("userverwaltungAdminList", userverwaltungAdminList);
		
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("html/userverwaltung.jsp");
        requestDispatcher.forward(request, response);
		
	}

	private List<UserInfoAdmin> readUserInfoAdmin() throws ServletException {
		List<UserInfoAdmin> userverwaltungAdminList = new ArrayList<UserInfoAdmin>(); 
        try (Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users")) {
        	
        	try (ResultSet rs = pstmt.executeQuery()) {
                   while (rs != null && rs.next()) {
                       UserInfoAdmin form = new UserInfoAdmin();

                       int userId = rs.getInt("user_id");
                       form.setUserId(userId);
                       
                       String userEmail = rs.getString("email");
                       form.setUserEmail(userEmail);

                       String userPassword = rs.getString("password");
                       form.setUserPassword(userPassword);

                       String userFirstNameAll = rs.getString("first_name");
                       form.setUserFirstName(userFirstNameAll);

                       String userLastNameAll = rs.getString("last_name");
                       form.setUserLastName(userLastNameAll);

                       String userStreet = rs.getString("street");
                       form.setUserStreet(userStreet);

                       String userCity = rs.getString("city");
                       form.setUserCity(userCity);

                       int userAdmin = rs.getInt("admin");
                       form.setUserAdmin(userAdmin);

                       userverwaltungAdminList.add(form);
                   }
               }
           } catch (Exception ex) {
               throw new ServletException(ex.getMessage());
           }
           return userverwaltungAdminList;
       }	
	
}

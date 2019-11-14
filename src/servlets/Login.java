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
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;




@WebServlet("Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
				
		String name = request.getParameter("name"); 
		String pass = request.getParameter("password");
		
		if(name.equals("abc") && pass.equals("abc")) {
			HttpSession session = request.getSession(); 
			session.setAttribute("name", name);
			response.sendRedirect("html/welcomeUser.jsp");
		}else {
			// TODO: LoginFehlgeschlagen.jsp
			out.println("Wrong username or password");			
		}
		
	}

}


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
import java.sql.*;
import beans.Product;


@WebServlet("UserProductEinzeln")
public class UserProductEinzeln extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer prodId = Integer.valueOf(request.getParameter("prodId"));
		
		request.setAttribute("prodId", prodId);
		
		System.out.println(prodId);
		
		Product product = new Product();
		product.setProdId(prodId);
		
		System.out.println(prodId);

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product where prod_id =?")) {
				pstmt.setInt(1, prodId);
			//  pstmt.executeQuery();
			System.out.println("tryschleife");
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		System.out.println(prodId);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userProductEinzeln.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

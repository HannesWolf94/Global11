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


@WebServlet("/UserProductEinzeln")
public class UserProductEinzeln extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;
	
	private Product lesen(Integer id) throws ServletException {
		Product product = new Product();
		product.setProdId(id);

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * from product WHERE prod_id = '1'")) {
			pstmt.setInt(1, id);
					
				double price; 
				String label; 
				String type; 
				String colour; 
				
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {

					label = rs.getString("prod_label");
					product.setLabel(label);
					type = rs.getString("prod_type");
					product.setType(type);
					colour = rs.getString("prod_colour");
					product.setColour(colour);
					price = rs.getDouble("prod_price");
					product.setPrice(price);

				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return product;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.valueOf(request.getParameter("prodId"));

		lesen(id);
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userProductEinzeln.jsp");
		dispatcher.forward(request, response);
	}
}

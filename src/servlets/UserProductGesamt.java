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
import beans.Product;

@WebServlet("/UserProductGesamt")
public class UserProductGesamt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserProductGesamt() {
		super();
	}
	
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "SELECT * FROM product";
		
		ArrayList<Product> productUserList = new ArrayList<>();
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			int prodId;
			double price; 
			String label; 
			String type; 
			String colour; 

			while (rs.next()) {
				Product form = new Product();
				prodId = rs.getInt("prod_id");
				form.setProdId(prodId);
				label = rs.getString("prod_label");
				form.setLabel(label);
				type = rs.getString("prod_type");
				form.setType(type);
				colour = rs.getString("prod_colour");
				form.setColour(colour);
				price = rs.getDouble("prod_price");
				form.setPrice(price);
//				image = rs.getString("prod_image");
//				form.setImage(image);

				productUserList.add(form);
			}

			request.setAttribute("productUserList", productUserList);
			con.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userProductGesamt.jsp");
		dispatcher.forward(request, response);
	}

}

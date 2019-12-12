//erstellt von Johannes Wolf 
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

	public UserProductEinzeln() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int prodId = Integer.valueOf(request.getParameter("prodId"));
		String kategorie = request.getParameter("kategorie");
		String label = request.getParameter("label");
		String type = request.getParameter("type");
		String colour = request.getParameter("colour");
		double price = Double.valueOf(request.getParameter("price"));
		
		Product productDB = new Product();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product where prod_id = ?")) {
			pstmt.setInt(1, prodId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					prodId = rs.getInt("prod_id");
					productDB.setProdId(prodId);
					kategorie = rs.getString("cat_description");
					productDB.setKategorie(kategorie);
					// productDB.setKategorie(rs.getString("cat_description"));	=> LIEBER SO
					label = rs.getString("prod_label");
					productDB.setLabel(label);
					type = rs.getString("prod_type");
					productDB.setType(type);
					colour = rs.getString("prod_colour");
					productDB.setColour(colour);
					price = rs.getDouble("prod_price");
					productDB.setPrice(price);
				}

			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		request.setAttribute("productDB", productDB);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userProductEinzeln.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

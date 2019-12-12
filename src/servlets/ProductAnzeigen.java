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

@WebServlet("ProductAnzeigen")
public class ProductAnzeigen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductAnzeigen() {
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
		
		ArrayList<Product> produktverwaltungAdminList = new ArrayList<>();
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			int prodId;
			String label;
			String type;
			String colour;
			double price;
			String kategorie;

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
				kategorie = rs.getString("cat_description");
				form.setKategorie(kategorie);

				produktverwaltungAdminList.add(form);
			}

			request.setAttribute("produktverwaltungAdminList", produktverwaltungAdminList);
			con.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/productAnzeigen.jsp");
		dispatcher.forward(request, response);
	}

}

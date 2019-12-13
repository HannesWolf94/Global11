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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Product> produktverwaltungAdminList = new ArrayList<>();
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM product");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Product form = new Product();
				form.setProdId(rs.getInt("prod_id"));
				form.setKategorie(rs.getString("cat_description"));
				form.setLabel(rs.getString("prod_label"));
				form.setType(rs.getString("prod_type"));
				form.setColour(rs.getString("prod_colour"));
				form.setPrice(rs.getDouble("prod_price"));

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

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
		int prodId = Integer.parseInt((request.getParameter("prodId")));

		Product productDB = new Product();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product where prod_id = ?")) {
			pstmt.setInt(1, prodId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					productDB.setProdId(rs.getInt("prod_id"));
					productDB.setKategorie(rs.getString("cat_description"));
					productDB.setLabel(rs.getString("prod_label"));
					productDB.setType(rs.getString("prod_type"));
					productDB.setColour(rs.getString("prod_colour"));
					productDB.setPrice(rs.getDouble("prod_price"));
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

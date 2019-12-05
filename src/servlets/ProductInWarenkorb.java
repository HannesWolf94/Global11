//erstellt von Johannes Wolf 
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
import java.sql.*;
import beans.Product;

@WebServlet("ProductInWarenkorb")
public class ProductInWarenkorb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	public ProductInWarenkorb() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer prodId = Integer.valueOf(request.getParameter("prodId"));
		String label = request.getParameter("label");
		String type = request.getParameter("type");
		String colour = request.getParameter("colour");
		Double price = Double.valueOf(request.getParameter("price"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Integer anzahl = Integer.valueOf(request.getParameter("anzahl"));

		HttpSession session = request.getSession();
		session.setAttribute("user", form);
		
		Product product = new Product();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product where prod_id = ?")) {
			pstmt.setInt(1, prodId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					prodId = rs.getInt("prod_id");
					product.setProdId(prodId);
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
			ex.getMessage();
		}

		HttpSession session = request.getSession();
		session.setAttribute("product", product);
		
		request.setAttribute("productDB", productDB);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userProductEinzeln.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

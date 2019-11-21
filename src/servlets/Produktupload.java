//erstellt von Martin Scherzer
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Product;

/**
 * Servlet implementation class Produktupload
 */
@WebServlet("/Produktupload")
public class Produktupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="java:jboss/datasources/MySqlGlobal11DS")
    private DataSource ds; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Produktupload() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Product form = new Product();
		form.setLabel(request.getParameter("label"));
		form.setType(request.getParameter("type"));
		form.setColour(request.getParameter("colour"));
		form.setPrice(Double.parseDouble(request.getParameter("price")));
		form.setSize(Integer.parseInt(request.getParameter("size")));
		form.setImage(request.getParameter("image"));
		speichern(form);
		response.sendRedirect("html/newProduct.jsp");
	}

	private void speichern(Product form) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO product (prod_label, prod_type, prod_colour, prod_price, prod_size, prod_image) VALUES (?, ?, ?, ?, ?, ?)")) {
			pstmt.setString(1, form.getLabel());
			pstmt.setString(2, form.getType());
			pstmt.setString(3, form.getColour());
			pstmt.setDouble(4, form.getPrice());
			pstmt.setInt(5, form.getSize());
			pstmt.setString(6, form.getImage());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

}

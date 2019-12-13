//erstellt von Martin Scherzer
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Product;

@WebServlet("/Suche")
public class Suche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Lesen der Daten in einer DB
		// und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP

		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		String kategorie = request.getParameter("kategorie");
		String label = request.getParameter("label");

		// DB-Zugriff
		List<Product> products = search(kategorie, label);

		// Scope "Request"
		request.setAttribute("products", products);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("UserProductGesamt");
		dispatcher.forward(request, response);
	}

	private List<Product> search(String kategorie, String label) throws ServletException {
		kategorie = (kategorie == null || kategorie == "") ? "%" : "%" + kategorie + "%";
		label = (label == null || label == "") ? "%" : "%" + label + "%";
		List<Product> products = new ArrayList<Product>();

		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM product WHERE cat_description like ? and prod_label LIKE ?")) {

			pstmt.setString(1, kategorie);
			pstmt.setString(2, label);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					Product product = new Product();

					product.setProdId(rs.getInt("prod_id"));
					product.setKategorie(rs.getString("cat_description"));
					product.setLabel(rs.getString("prod_label"));
					product.setType(rs.getString("prod_type"));
					product.setColour(rs.getString("prod_colour"));
					product.setPrice(rs.getDouble("prod_price"));

					products.add(product);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return products;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

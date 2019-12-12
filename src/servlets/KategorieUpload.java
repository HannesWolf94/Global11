//erstellt von Johannes Wolf
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.servlet.http.Part;

import beans.Kategorie;

@WebServlet("/KategorieUpload")

public class KategorieUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="java:jboss/datasources/MySqlGlobal11DS")
    private DataSource ds; 

	public KategorieUpload() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Kategorie kategorie = new Kategorie();
		kategorie.setKategorieId(Integer.parseInt(request.getParameter("kategorieId")));
		kategorie.setKategorie(request.getParameter("kategorie"));

		// Filebehandlung 
		Part filepart = request.getPart("image");
		speichern(form,filepart);
		request.setAttribute("form", form);
		response.sendRedirect("html/newProduct.jsp");
	}

	private void speichern(Product form, Part filepart) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO product (prod_label, prod_type, prod_colour, prod_price, prod_image) VALUES (?, ?, ?, ?, ?)")) {
			pstmt.setString(1, form.getLabel());
			pstmt.setString(2, form.getType());
			pstmt.setString(3, form.getColour());
			pstmt.setDouble(4, form.getPrice());
			pstmt.setBinaryStream(5, filepart.getInputStream());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


//erstellt von Martin Scherzer
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

import beans.Product;

@WebServlet("/ProductUpload")
@MultipartConfig(
        maxFileSize=1024*1024*5,
        maxRequestSize=1024*1024*5*5, 
        location= "/tmp",
        fileSizeThreshold=1024*1024)

public class ProductUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="java:jboss/datasources/MySqlGlobal11DS")
    private DataSource ds; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUpload() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Speicherung der Daten in einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8");
		Product form = new Product();
		form.setLabel(request.getParameter("label"));
		form.setType(request.getParameter("type"));
		form.setColour(request.getParameter("colour"));
		form.setPrice(Double.parseDouble(request.getParameter("price")));
		form.setSize(Integer.parseInt(request.getParameter("size")));
		// Logausgabe über empfangene Parts
				for (Part part : request.getParts()) {
					log("Part received: " + part.getName());
					if (part.getSubmittedFileName() != null)
						log("Filename written via BinaryStream: " + part.getSubmittedFileName());
				}
		// Filebehandlung 
		Part filepart = request.getPart("image");
		speichern(form,filepart);
		request.setAttribute("form", form);
		response.sendRedirect("html/newProduct.jsp");
	}

	private void speichern(Product form, Part filepart) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO product (prod_label, prod_type, prod_colour, prod_price, prod_size, prod_image) VALUES (?, ?, ?, ?, ?, ?)")) {
			pstmt.setString(1, form.getLabel());
			pstmt.setString(2, form.getType());
			pstmt.setString(3, form.getColour());
			pstmt.setDouble(4, form.getPrice());
			pstmt.setInt(5, form.getSize());
			pstmt.setBinaryStream(6, filepart.getInputStream());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


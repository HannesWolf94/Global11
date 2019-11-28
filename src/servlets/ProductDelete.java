// Maddl, Michi
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.Product;


@WebServlet("ProductDelete")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		String label = request.getParameter("label");
		String labelRepeat = request.getParameter("labelRepeat");
		
		if ((labelCheck(label, labelRepeat) == true)) {
			delete(label);

	        final RequestDispatcher dispatcher = request.getRequestDispatcher("ProductAnzeigen");
	        dispatcher.forward(request, response);
        } else {
//        	Fehlermeldung.jsp oder die Eingabefelder rot umranden wenn email nicht übereinstimmt 
        	final RequestDispatcher dispatcher = request.getRequestDispatcher("html/impressum.jsp");
             dispatcher.forward(request, response);
        }
		
	}

	private void delete(String label) throws ServletException {
		Product product = new Product(); 
		product.setLabel(label); 
		
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM product WHERE prod_label = ?;")) {
			pstmt.setString(1, label);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	
	protected boolean labelCheck(String label, String labelRepeat) throws ServletException {
		if (label.equals(labelRepeat)) {
			return true;
		} else {
			return false;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

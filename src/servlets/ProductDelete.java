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
import javax.sql.DataSource;
import beans.Product;

@WebServlet("ProductDelete")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		Integer prodId = Integer.valueOf(request.getParameter("prodId"));
		Integer prodIdRepeat = Integer.valueOf(request.getParameter("prodIdRepeat"));
		request.setAttribute("prodId", prodId);

		if ((prodId == prodIdRepeat)) {
			delete(prodId);

			final RequestDispatcher dispatcher = request.getRequestDispatcher("ProductAnzeigen");
			dispatcher.forward(request, response);
		} else {
			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/fehlerseite.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void delete(Integer prodId) throws ServletException {
		Product product = new Product();
		product.setProdId(prodId);

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM product WHERE prod_id = ?")) {
			pstmt.setInt(1, prodId);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	 protected boolean prodIdCheck(Integer prodId, Integer prodIdRepeat) throws
	 ServletException {
	 if (prodId == prodIdRepeat) {
	 return true;
	 } else {
	 return false;
	 }
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
 
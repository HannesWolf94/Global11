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

@WebServlet("WarenkorbAendern")
public class WarenkorbAendern extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	public WarenkorbAendern() {
		super();
	}
	
	private Double berechneGesamtpreis(Integer anzahl, Double price) {
		Double gesamtpreis = anzahl * price;

		return gesamtpreis;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int orderId = Integer.parseInt((request.getParameter("orderId")));
		int anzahl = Integer.parseInt((request.getParameter("anzahl")));
		double price = Double.parseDouble(request.getParameter("price"));
		double gesamtpreis = berechneGesamtpreis(anzahl, price);

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE warenkorb SET number =?, gesamtpreis =? WHERE order_id = ?")) {
			pstmt.setInt(1, anzahl);
			pstmt.setDouble(2, gesamtpreis);
			pstmt.setInt(3, orderId);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("WarenkorbAnzeigen");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

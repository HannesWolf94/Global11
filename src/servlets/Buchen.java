// erstellt von Martin Scherzer
package servlets;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import beans.User;
import beans.Order;

@WebServlet("Buchen")

public class Buchen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	public Buchen() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Order bestellung = new Order();
		bestellung.setRechnungsbetrag(Double.parseDouble(request.getParameter("rechnungsbetrag")));
	
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		speichern(bestellung, user);
		delete(user);
		request.setAttribute("bestellung", bestellung);
		response.sendRedirect("html/buchungsbestaetigung.jsp");
	}

	private void speichern(Order bestellung, User user) throws ServletException {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO orders (user_id, rechnungsbetrag) VALUES (?, ?)")) {
			pstmt.setInt(1, user.getUserId());
			pstmt.setDouble(2, bestellung.getRechnungsbetrag());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	private void delete(User user) throws ServletException {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM warenkorb WHERE user_id = ?")) {
			pstmt.setInt(1, user.getUserId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

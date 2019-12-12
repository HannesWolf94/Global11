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
import beans.Warenkorb;
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
		Order order = new Order(); 
		
		order.setOrderId(Integer.parseInt(request.getParameter("orderId")));
		order.setUserId(Integer.parseInt(request.getParameter("userId")));
		order.setRechnungsbetrag(Double.parseDouble(request.getParameter("rechnungsbetrag")));
		
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user");

		speichern(order, user);
		request.setAttribute("order", order);
		response.sendRedirect("html/newKategorie.jsp");
	}
	
	private void speichern(Order order, User user) throws ServletException  {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO orders (order_id, user_id, rechnungsbetrag, rechnungs_datum ) VALUES (?, ?, ?, ?)")) {
			pstmt.setInt(1, order.getOrderId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setDouble(3, order.getRechnungsbetrag());

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

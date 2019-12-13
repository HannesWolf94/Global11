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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		Order bestellung = new Order(); 
		bestellung.setOrderId(Integer.parseInt(request.getParameter("orderId")));
		bestellung.setUserId(Integer.parseInt(request.getParameter("userId")));
		bestellung.setRechnungsbetrag(Double.parseDouble(request.getParameter("rechnungsbetrag")));
	
//		Date parsed = format.parse(datum);
//        return new java.sql.Date(parsed.getTime());
		
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user");

		speichern(bestellung);
		request.setAttribute("bestellung", bestellung);
		response.sendRedirect("html/buchungsbestaetigung.jsp");
	}
	
	private void speichern(Order bestellung) throws ServletException  {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO orders (user_id,) VALUES ( ?)")) {
//			pstmt.setInt(1, bestellung.getOrderId());
			pstmt.setInt(2, bestellung.getUserId());
//			pstmt.setDouble(3, bestellung.getRechnungsbetrag());
		
			
			

			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
		
//	public java.sql.Date setToSQLFormat(String datum) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date parsed = format.parse(datum);
//        return new java.sql.Date(parsed.getTime());
//    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

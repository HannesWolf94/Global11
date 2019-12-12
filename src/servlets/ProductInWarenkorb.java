//erstellt von Johannes Wolf 
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

@WebServlet("ProductInWarenkorb")

public class ProductInWarenkorb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	public ProductInWarenkorb() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Warenkorb warenkorb = new Warenkorb(); 
		
		warenkorb.setProdId(Integer.parseInt(request.getParameter("prodId")));
		warenkorb.setKategorie(request.getParameter("kategorie"));
		warenkorb.setLabel(request.getParameter("label"));
		warenkorb.setType(request.getParameter("type"));
		warenkorb.setColour(request.getParameter("colour"));
		warenkorb.setPrice(Double.parseDouble(request.getParameter("price")));
		warenkorb.setSize(Integer.parseInt((request.getParameter("size"))));
		warenkorb.setAnzahl(Integer.parseInt((request.getParameter("anzahl"))));
		
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user");

		speichern(warenkorb, user);
		request.setAttribute("warenkorb", warenkorb);
		response.sendRedirect("html/newKategorie.jsp");
	}
	
	private void speichern(Warenkorb warenkorb, User user) throws ServletException  {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO warenkorb (prod_id, number, size, user_id) VALUES (?, ?, ?, ?)")) {
			pstmt.setInt(1, warenkorb.getProdId());
			pstmt.setInt(2, warenkorb.getAnzahl());
			pstmt.setInt(3, warenkorb.getSize());
			pstmt.setInt(4, user.getUserId());	
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

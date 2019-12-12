//erstellt von Johannes Wolf 
package servlets;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

import beans.Product;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		user.setUserId(user.getUserId());
		
		Product productVar = new Product(); 
		productVar.setProdId(Integer.parseInt(request.getParameter("prodId")));
		productVar.setLabel((request.getParameter("label")));
		productVar.setType(request.getParameter("type"));
		productVar.setColour(request.getParameter("colour"));
		productVar.setPrice(Double.parseDouble(request.getParameter("price")));
		
		Warenkorb warenkorbVar = new Warenkorb();
		warenkorbVar.setSize(Integer.parseInt(request.getParameter("size")));
		warenkorbVar.setAnzahl(Integer.parseInt(request.getParameter("anzahl")));

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO warenkorb (prod_id, number, size, user_id, date ) values (?,?,?,?,'2019-12-11')")) {
			pstmt.setInt(1, productVar.getProdId());
			pstmt.setInt(2, warenkorbVar.getAnzahl());
			pstmt.setInt(3, warenkorbVar.getSize());
			pstmt.setInt(4, user.getUserId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
//			ex.getMessage();
		}
		
		request.setAttribute("warenkorbVar", warenkorbVar);
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userProductEinzeln.jsp"); // richtige Verlinkung einbauen
		dispatcher.forward(request, response);
	}
		
//		Integer prodId = Integer.valueOf(request.getParameter("prodId"));
//		String label = request.getParameter("label");
//		String type = request.getParameter("type");
//		String colour = request.getParameter("colour");
//		Double price = Double.valueOf(request.getParameter("price"));
//		Integer size = Integer.valueOf(request.getParameter("size"));
//		Integer anzahl = Integer.valueOf(request.getParameter("anzahl"));

//		ArrayList<Warenkorb> productWarenkorb = new ArrayList<>();		

//		warenkorb.setProdId(prodId);
//		warenkorb.setLabel(label);
//		warenkorb.setType(type);
//		warenkorb.setColour(colour);
//		warenkorb.setPrice(price);
//		warenkorb.setSize(size);
//		warenkorb.setAnzahl(anzahl);
//		
//		productWarenkorb.add(warenkorb);
//		
//		request.setAttribute("productWarenkorb", productWarenkorb);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);	
	}	

}

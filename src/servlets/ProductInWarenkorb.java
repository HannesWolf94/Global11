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

<<<<<<< HEAD
=======
public ProductInWarenkorb() {
	super();
}

>>>>>>> 0346098a0cdeae01c442b0f7957455f750e7c03e
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
		
<<<<<<< HEAD
		Warenkorb warenkorb = new Warenkorb();
		warenkorb.setSize(Integer.parseInt(request.getParameter("size")));
		warenkorb.setAnzahl(Integer.parseInt(request.getParameter("anzahl")));
		
=======
		Warenkorb warenkorbVar = new Warenkorb();
		warenkorbVar.setSize(Integer.parseInt(request.getParameter("size")));
		warenkorbVar.setAnzahl(Integer.parseInt(request.getParameter("anzahl")));

>>>>>>> 0346098a0cdeae01c442b0f7957455f750e7c03e
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
<<<<<<< HEAD
		request.setAttribute("warenkorb", warenkorb);
=======
		
		request.setAttribute("warenkorbVar", warenkorbVar);
>>>>>>> 0346098a0cdeae01c442b0f7957455f750e7c03e
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/userProductEinzeln.jsp"); // richtige Verlinkung einbauen
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);	
	}	

}

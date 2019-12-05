//erstellt von Johannes Wolf 
package servlets;

import javax.annotation.Resource;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
//import java.sql.*;
import java.util.ArrayList;
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
		Integer prodId = Integer.valueOf(request.getParameter("prodId"));
		String label = request.getParameter("label");
		String type = request.getParameter("type");
		String colour = request.getParameter("colour");
		Double price = Double.valueOf(request.getParameter("price"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Integer anzahl = Integer.valueOf(request.getParameter("anzahl"));

		ArrayList<Warenkorb> productWarenkorb = new ArrayList<>();
		
		Warenkorb warenkorb = new Warenkorb(); 
		warenkorb.setProdId(prodId);
		warenkorb.setLabel(label);
		warenkorb.setType(type);
		warenkorb.setColour(colour);
		warenkorb.setPrice(price);
		warenkorb.setSize(size);
		warenkorb.setAnzahl(anzahl);
		
		productWarenkorb.add(warenkorb);
		
		request.setAttribute("productWarenkorb", productWarenkorb);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

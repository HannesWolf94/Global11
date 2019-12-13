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
import java.util.ArrayList;
import java.sql.*;
import beans.Warenkorb;
import beans.User;

@WebServlet("WarenkorbAnzeigen")
public class WarenkorbAnzeigen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WarenkorbAnzeigen() {
		super();
	}

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Warenkorb> warenkorbList = new ArrayList<>();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement("SELECT warenkorb.order_id, warenkorb.user_id, product.prod_id, product.cat_description, product.prod_label, product.prod_type, product.prod_colour, product.prod_price, warenkorb.size, warenkorb.number FROM warenkorb INNER JOIN product ON warenkorb.prod_id = product.prod_id WHERE warenkorb.user_id = ?");
			
			pstm.setInt(1, user.getUserId());
			ResultSet rs = pstm.executeQuery();
							
			while (rs.next()) {
				Warenkorb warenkorb = new Warenkorb();
				warenkorb.setOrderId(rs.getInt("order_id"));
				warenkorb.setUserId(rs.getInt("user_id"));
				warenkorb.setProdId(rs.getInt("prod_id"));
				warenkorb.setKategorie(rs.getString("cat_description"));
				warenkorb.setLabel(rs.getString("prod_label"));
				warenkorb.setType(rs.getString("prod_type"));
				warenkorb.setColour(rs.getString("prod_colour"));
				warenkorb.setPrice(rs.getInt("prod_price"));
				warenkorb.setSize(rs.getInt("size"));
				warenkorb.setAnzahl(rs.getInt("number"));
				warenkorbList.add(warenkorb);
			}
			request.setAttribute("warenkorbList", warenkorbList);
			con.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/warenkorb.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

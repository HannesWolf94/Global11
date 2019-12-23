//Erstellt von Michael Haid
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
import java.util.ArrayList;
import java.sql.*;
import beans.Kategorie;

@WebServlet("KategorieAnzeigen")
public class KategorieAnzeigen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KategorieAnzeigen() {
		super();
	}

	@Resource(lookup = "java:jboss/datasources/MySqlGlobal11DS")
	private DataSource ds;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Kategorie> kategorieList = new ArrayList<>();
		try {
			final Connection con = ds.getConnection();
			PreparedStatement pstm = con.prepareStatement( "SELECT * FROM category");
			ResultSet rs = pstm.executeQuery();
			

			while (rs.next()) {
				Kategorie form = new Kategorie();
				form.setKategorieId(rs.getInt("cat_id"));
				form.setKategorie(rs.getString("cat_description"));
				

				kategorieList.add(form);
			}

			request.setAttribute("kategorieList", kategorieList);
			con.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/productUpload.jsp");
		dispatcher.forward(request, response);
	}

}

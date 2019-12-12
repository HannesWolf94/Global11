//erstellt von Johannes Wolf
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Kategorie;

@WebServlet("KategorieUpload")

public class KategorieUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="java:jboss/datasources/MySqlGlobal11DS")
    private DataSource ds; 
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Kategorie kategorie = new Kategorie();
		kategorie.setKategorie(request.getParameter("kategorie"));
		
		speichern(kategorie);
		request.setAttribute("kategorie", kategorie);
		response.sendRedirect("html/newKategorie.jsp");
	}
		
		
		
		
		
		
		
		
		
		
		//		if(kategorieCheck(kategorie.getKategorie())) {
//			final RequestDispatcher dispatcher = request.getRequestDispatcher("html/newKategorie.jsp");
//	        dispatcher.forward(request, response);
//		} else {
//	            speichern(kategorie);
//	            
//	            request.setAttribute("kategorie", kategorie);
//				final RequestDispatcher dispatcher = request.getRequestDispatcher("html/newKategorie.jsp");
//				dispatcher.forward(request, response);
//	    }
//	}
//
	private void speichern(Kategorie kategorie) throws ServletException {
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO category (cat_description) VALUES (?)")) {
			pstmt.setString(1, kategorie.getKategorie());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


//	protected boolean kategorieCheck(String kategorie) throws ServletException {
//		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement("SELECT * FROM category WHERE cat_description = ?")) {
//			pstmt.setString(1, kategorie);
//			try (ResultSet rs = pstmt.executeQuery()) {
//				if (rs.next()) {
//					return false;
//				} else {
//					return true;
//				}
//			} catch (Exception e) {
//			}
//		} catch (Exception e) {
//		}
//		return true;
//	}


}


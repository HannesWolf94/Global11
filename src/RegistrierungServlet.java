import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrierungServlet
 */
@WebServlet("/RegistrierungServlet")
public class RegistrierungServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		
		final PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Empfangene Formulardaten</h3>");
		out.println("Name: " + request.getParameter("name") + "<br>");
		out.println("Vorname: " + request.getParameter("vorname") + "<br>");
		out.println("Email: " + request.getParameter("email") + "<br>");
		out.println("Straße: " + request.getParameter("strasse") + "<br>");
		out.println("Hausnummer: " + request.getParameter("hausnummer") + "<br>");
		out.println("Stadt: " + request.getParameter("stadt") + "<br>");
		out.println("Postleitzahl: " + request.getParameter("postleitzahl") + "<br>");
		out.println("Passwort: " + request.getParameter("passwort") + "<br>");
		out.println("Wiederhole Passwort: " + request.getParameter("passwort2"));
		out.println("</body>");
		out.println("</html>");
		}

	
}

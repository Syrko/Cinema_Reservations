package servletpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databasepackage.Database;

/**
 * Servlet implementation class addingMovie
 */
@WebServlet("/addingMovie")
public class addingMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addingMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("filmTitle");
		String category = request.getParameter("filmCategory");
		String description = request.getParameter("filmDescription");
		Database.CreateFilm(title, category, description);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html>" +
						"<html>" +
						"<head>" +
						"  <title> Movie Added...</title>" +
						"</head>" +
						"<body>" +
						"  <form method='post' action='ContentAdminServlet'> "+
						"     <h1> Movie Added Successfully! </h1>" +
						"    <input type='submit' value='OK'>" +
						"  </form>" +
						"</body>" +
						"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

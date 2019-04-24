package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.omdb.MovieSearch;
import aiss.model.resources.omdbResource;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SearchController.class.getName());

	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String query = request.getParameter("searchQuery"); //Pasamos la búsqueda a
		// un string
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null; // Creamos un RequestDispatcher iniciado a null

		// Search for movies in OMDb
		log.log(Level.FINE, "Searching for OMDb movies that contain " + query);
		omdbResource omdb = new omdbResource(); // Creamos un recurso omdb
		MovieSearch omdbResults = omdb.getMovies(query); // Reunimos los resultados de la búsqueda

		if (omdbResults != null) { // Si los resultados no son null
			rd = request.getRequestDispatcher("/success.jsp"); // info.jsp es la vista donde se muestra la información
																// de la película
			request.setAttribute("movies", omdbResults.getSearch());
		} else {
				log.log(Level.SEVERE, "OMDb object: " + omdbResults);
				rd = request.getRequestDispatcher("/error.jsp"); // Y mandamos el control a "error.jsp" vista sencilla
			
			// Pase lo que pase, el requestDispatcher manda la información a un sitio u otro
		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
